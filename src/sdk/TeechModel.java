package teech.sdk;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import teech.sdk.exceptions.APIConnectionException;
import teech.sdk.exceptions.InvalidRequestException;
import teech.sdk.exceptions.TeechAuthenticationException;
import teech.sdk.exceptions.TeechException;

/**
 * @exlude 
 */
public class TeechModel {
	
	protected JSONObject fields = new JSONObject();
	protected String endpoint;
	public static String urlTeech="http://api.teech.io/";
	

	/**
	 * @throws TeechException, Exception 
	 * @throws APIConnectionException 
	 * @throws TeechAuthenticationException 
	 * @throws InvalidRequestException 
	 * @exlude 
	 */
	public boolean save() throws InvalidRequestException, TeechAuthenticationException, APIConnectionException, TeechException, Exception {
		System.out.println("U"+urlTeech+endpoint);
		System.out.println("POST"+this.fields.toString());
		Connect cn = new Connect(urlTeech+endpoint,"POST", this.fields.toString());
		String result = cn.getResult();
		this.fields = new JSONObject(result);
		return true;
	}
	
	/**
	 * @throws TeechException, Exception 
	 * @throws APIConnectionException 
	 * @throws TeechAuthenticationException 
	 * @throws InvalidRequestException 
	 * @exlude 
	 */
	public JSONObject fetch(String id) throws InvalidRequestException, TeechAuthenticationException, APIConnectionException, TeechException, Exception{
		String url = urlTeech+endpoint+"/"+id;
		Connect cn = new Connect(url,"GET", "");
		String result = cn.getResult();
		this.fields = new JSONObject(result);
		return fields;
	}
	
	
	/**
	 * @throws TeechException 
	 * @throws APIConnectionException 
	 * @throws TeechAuthenticationException 
	 * @throws InvalidRequestException 
	 * @exlude 
	 */
	public boolean delete(String id) throws InvalidRequestException, TeechAuthenticationException, APIConnectionException, TeechException{
		String url = urlTeech+endpoint+"/"+id;
		new Connect(url,"DELETE", "");
		return true;
	}
	
	/**
	 * @throws TeechException, Exception 
	 * @throws APIConnectionException 
	 * @throws TeechAuthenticationException 
	 * @throws InvalidRequestException 
	 * @exlude 
	 */
	public JSONArray fetchAll() throws InvalidRequestException, TeechAuthenticationException, APIConnectionException, TeechException, Exception{
		String url = urlTeech+endpoint;
		Connect cn = new Connect(url,"GET", "");
		String result = cn.getResult();
		return new JSONArray(result);
	}
	
	/**
	 * @throws TeechException 
	 * @throws APIConnectionException 
	 * @throws TeechAuthenticationException 
	 * @throws InvalidRequestException 
	 * @exlude 
	 */
	public boolean update(String id) throws InvalidRequestException, TeechAuthenticationException, APIConnectionException, TeechException, Exception{
		Connect cn = new Connect(urlTeech+endpoint+"/"+id,"PUT", this.fields.toString());
		String result = cn.getResult();
		this.fields = new JSONObject(result);
		return true;
	}
	
	
	/**
	 * Puts the data in the object
	 */
	public void put(String key, Object value) {
		try {
			this.fields.put(key, value);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * Gets an object property by key
	 * @return 
	 */
	public Object get(String key) {
		try {
			return this.fields.get(key);
		} catch (JSONException e) {
			return null;
		}
	}

	/**
	 * Removes an object property by key
	 */
	public void remove(String key) {
		this.fields.remove(key);
	}

}