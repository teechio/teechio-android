package teech.sdk;
import java.io.*;
import java.net.*;

import teech.sdk.exceptions.APIConnectionException;
import teech.sdk.exceptions.InvalidRequestException;
import teech.sdk.exceptions.TeechAuthenticationException;
import teech.sdk.exceptions.TeechException;
import android.os.StrictMode;

/**
 * @exclude 
 */
public class Connect{

private URL url;
private HttpURLConnection huc;
private String contetx = "";
private String apik;
private String appk;
private int respCode;

	
	public Connect(String address, String method, String text) throws InvalidRequestException, TeechAuthenticationException, APIConnectionException, TeechException {
		
		
		if(android.os.Build.VERSION.SDK_INT >9){
			StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
			StrictMode.setThreadPolicy(policy);
		}
		
		Teech t = new Teech();
		apik = t.getAPIkey();
		appk = t.APPid();
		
		if(text.equals("")){
			text = "{}";
		}
		
		try{
			url = new URL(address);
			huc = (HttpURLConnection) url.openConnection();
			huc.setRequestProperty("Teech-Application-Id", appk);
			huc.setRequestProperty("Teech-REST-API-Key",apik);
			huc.setRequestProperty("User-Agent", "SDK_Android");
				
			if(method.equals("GET")){
				huc.setRequestMethod("GET");
			}
				
			if(method.equals("POST")){
				huc.setRequestMethod("POST");
				huc.setRequestProperty("Content-Type", "application/json");
				OutputStream output = null;
				output = huc.getOutputStream();
				output.write(text.getBytes());
				output.close();
				
			}if(method.equals("DELETE")){
				huc.setRequestMethod("DELETE");
			}
				
			if(method.equals("PUT")){
				huc.setRequestMethod("PUT");
				huc.setRequestProperty("content-type", "application/json");
				huc.connect();
				OutputStreamWriter out = new OutputStreamWriter( huc.getOutputStream());
				out.write(text);
				out.close();
			}
				
			BufferedReader in = new BufferedReader(new InputStreamReader(huc.getInputStream()));
			String inputLine;
				
			while((inputLine = in.readLine())!= null){
				contetx += inputLine;
				contetx += "\r\n";
			}
				
			respCode = ((HttpURLConnection)huc).getResponseCode();
			in.close();
			
		}catch(IOException e){
			e.printStackTrace();
			respCode = this.getResponseCode();
			System.out.println("CODE"+respCode);
			if(respCode==400){
				throw new InvalidRequestException();
			}
			if(respCode==401){
				throw new TeechAuthenticationException();
			}
			if(respCode==404){
				throw new APIConnectionException();
			}else{
				throw new TeechException();
			}
		}
		
	}

	public String getResult(){
		return contetx;
	}
	
	public int getResponseCode(){
		try {
			respCode = ((HttpURLConnection)huc).getResponseCode();
			return respCode;
		} catch (IOException e1) {
			return 0;
		}
	}
	
	
}