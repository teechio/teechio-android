package teech.sdk;


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
		String url = urlTeech+endpoint+path;
		Connect cn = new Connect(url,"GET", "");
		result = cn.getResult();
		array = new JSONArray(result);		
		return array;
	}

	
	
}
