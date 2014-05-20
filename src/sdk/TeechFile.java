package teech.sdk;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;

import org.json.JSONException;
import org.json.JSONObject;

import android.os.StrictMode;
import android.util.Log;

	/**
	 * Teech.io cloud storage let you store and retrieve files of size up to 64MB each.
	 */
public class TeechFile extends TeechModel {
	
	public TeechFile(){
		this.fields = new HashMap<String, Object>();
	}

	/**
	 * Return a Boolean value. If the TecchFile is correctly created, this boolean is true, false otherwise. 
	 * <p>
	 * @param name a name of the user
	 * @param path a local path where the file resides
	 * @return boolean
	 */
	public boolean upload(String name, String path) throws IOException{
		
		if(android.os.Build.VERSION.SDK_INT > 9){
			StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
			StrictMode.setThreadPolicy(policy);
		}
		
		byte[] bytes = null;
        File f = new File(path);
		try {
			 FileInputStream fis = new FileInputStream(f);
			ByteArrayOutputStream bos = new ByteArrayOutputStream();
			byte[] buf = new byte[1024];
			try {
				for (int readNum; (readNum = fis.read(buf)) != -1;) {
					bos.write(buf, 0, readNum); 
				}
			}catch(IOException ex) {
				Log.d("SDKerror","error TeechFile");
			}
			bytes = bos.toByteArray();
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		Teech t = new Teech();
		String apik = t.getAPIkey();
		String appk = t.APPid();
		
		URL url = new URL(urlTeech+"files/"+name);
		HttpURLConnection connection = (HttpURLConnection) url.openConnection();
		connection.setDoOutput(true);
		connection.setRequestProperty("Teech-Application-Id", appk);
		connection.setRequestProperty("Teech-REST-API-Key",apik);
		connection.setRequestProperty("Content-Type","application/octet-stream");
		connection.setRequestMethod("POST");
		
		DataOutputStream out = new DataOutputStream(new BufferedOutputStream(connection.getOutputStream()));
		out.write(bytes);
		out.flush();
		out.close();
		
		int respCode = ((HttpURLConnection)connection).getResponseCode();

		BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
		String inputLine;
		
		String contetx="";

		while((inputLine = in.readLine())!= null){
			contetx += inputLine;
			contetx += "\r\n";
		}
		
		String urlFile = null;
		String nameFile = null;
		JSONObject object;
		try {
			object = new JSONObject(contetx);
			urlFile = object.getString("url");
			nameFile = object.getString("name");
			fields.put("url", urlFile);
			fields.put("name", nameFile);
		} catch (JSONException e) {
			e.printStackTrace();
		}
		
		if(respCode==200){
			return true;
		}else{
			return false;
		}
		
    }
	
	/**
	 * Return a String value. The String contienes the file url.
	 */
	public String getUrl(){
		String url = fields.get("url").toString();
		return url;
	}
	
	/**
	 * Return a String value. The String contienes the file name.
	 */
	public String getName(){
		String url = fields.get("name").toString();
		return url;
	}
	
	/**
	 * Return a Boolean value. If the TecchFile is correctly deleted, this boolean is true, false otherwise. 
	 * <p>
	 * @param fileName a name of the file
	 * @return boolean
	 */
	public boolean delete(String fileName){
		Connect cn = new Connect("http://api.teech.io/files/"+fileName,"DELETE", "");
		int code = cn.getResponseCode();
		if(code==200){
			return true;
		}else{
			return false;
		}
	}
}
