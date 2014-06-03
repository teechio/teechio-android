package teech.sdk;

import org.json.JSONArray;

import teech.sdk.exceptions.APIConnectionException;
import teech.sdk.exceptions.InvalidRequestException;
import teech.sdk.exceptions.TeechAuthenticationException;
import teech.sdk.exceptions.TeechException;

/**
 * Teech.io REST API let you retrieve items in a very flexible way.
 * Sending a GET request to the class URL, simply lists all items.
 */
public class Query extends TeechModel{
	
	/**
	 * Return a JSONArray that contain a result of you query. If the query is unsuccessfully, this JSONArray is null. 
	 * <p>
	 * @param endpoint the name of the endpoint on which perform the research
	 * @param key the key of the object
	 * @param value the value of the object
	 * @return JSONArray
	 * @throws TeechException, Exception 
	 * @throws APIConnectionException 
	 * @throws TeechAuthenticationException 
	 * @throws InvalidRequestException 
	 */
	public JSONArray search(String endpoint ,String key , String value) throws InvalidRequestException, TeechAuthenticationException, APIConnectionException, TeechException, Exception{
		String result=null;
		JSONArray array = null;
		String url = urlTeech+endpoint+"?query={\""+key+"\":\""+value+"\"}";
		Connect cn = new Connect(url,"GET", "");
		result = cn.getResult();
		array = new JSONArray(result);		
		return array;
	}
	
	/**
	 * Return a JSONArray that contain a result of you query. If the query is unsuccessfully, this JSONArray is null. 
	 * <p>
	 * @param endpoint the name of the endpoint on which perform the research
	 * @param key the key of the object
	 * @param value the value of the object
	 * @param limit the max number of object
	 * @param shuffle mode on with true or mode off with false
	 * @return JSONArray
	 * @throws TeechException, Exception 
	 * @throws APIConnectionException 
	 * @throws TeechAuthenticationException 
	 * @throws InvalidRequestException 
	 */
	public JSONArray searchEdit(String endpoint ,String key , String value, int limit, boolean shuffle  ) throws InvalidRequestException, TeechAuthenticationException, APIConnectionException, TeechException, Exception{
		String result=null;
		JSONArray array = null;
		String url = urlTeech+endpoint+"?query={\""+key+"\":\""+value+"\"}&limit="+limit+"&shuffle="+shuffle;
		Connect cn = new Connect(url,"GET", "");
		result = cn.getResult();
		array = new JSONArray(result);		
		return array;
	}
	
	/**
	 * Return a JSONArray that contain a result of you query. If the query is unsuccessfully, this JSONArray is null. 
	 * <p>
	 * @param search the string json of you query
	 * @return JSONArray
	 * @throws TeechException, Exception 
	 * @throws APIConnectionException 
	 * @throws TeechAuthenticationException 
	 * @throws InvalidRequestException 
	 */
	public JSONArray searchAll(String search) throws InvalidRequestException, TeechAuthenticationException, APIConnectionException, TeechException, Exception{
		String result=null;
		JSONArray array = null;
		String url = urlTeech+search;
		Connect cn = new Connect(url,"GET", "");
		result = cn.getResult();
		array = new JSONArray(result);
		return array;
	}

}
