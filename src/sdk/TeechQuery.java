package teech.sdk;


import java.net.URLEncoder;
import java.util.Iterator;

import org.json.JSONArray;
import org.json.JSONObject;

import teech.sdk.exceptions.APIConnectionException;
import teech.sdk.exceptions.InvalidRequestException;
import teech.sdk.exceptions.TeechAuthenticationException;
import teech.sdk.exceptions.TeechException;

/**
 * Teech.io REST API let you retrieve items in a very flexible way.
 * Sending a GET request to the class URL, simply lists all items.
 */
public class TeechQuery extends TeechModel{
	
	private String endpoint;
	private String path = "?";
	
	public TeechQuery(final String endpoint){
		this.endpoint= endpoint;
	}
	
	public TeechQuery search(JSONObject constraints) {
		Iterator<?> keys = constraints.keys();

		while( keys.hasNext() ){
		  try{
		    String key = URLEncoder.encode(keys.next().toString(),"UTF-8");
		    String value =  URLEncoder.encode(constraints.get(key).toString(),"UTF-8");
		    constraints.put(key, value);
		  } catch (Exception e) { e.printStackTrace(); }    
		}
		
		this.path += "query=" + constraints.toString() + "&";
		return this;
	}
	
	
	public TeechQuery sort(JSONObject constraints) {
		this.path += "sort=" + constraints.toString() + "&";
		return this;
	}
	
	public TeechQuery sort(String s) {
		this.path += "sort=" + s + "&";
		return this;
	}
	
	public TeechQuery limit(int n) {
		this.path += "limit="+n + "&";
		return this;
	}
	
	public TeechQuery skip(int n) {
		this.path += "skip="+n + "&";
		return this;
	}
	
	
	/**
	 * Return a JSONArray that contain a result of you query. If the query is unsuccessfully, this JSONArray is null. 
	 * <p>
	 * @return JSONArray
	 * @throws TeechException, Exception 
	 * @throws APIConnectionException 
	 * @throws TeechAuthenticationException 
	 * @throws InvalidRequestException 
	 */
	public JSONArray get() throws InvalidRequestException, TeechAuthenticationException, APIConnectionException, TeechException, Exception{
		String result=null;
		JSONArray array = null;
		String p =this.path.substring(0, this.path.length()-1);
		String url = urlTeech+endpoint+p;
		System.out.println("URL"+url);
		Connect cn = new Connect(url,"GET", "");
		result = cn.getResult();
		System.out.println("RESULT:"+result);
		array = new JSONArray(result);		
		return array;
	}

	
	
}
