package teech.sdk;

import org.json.JSONObject;
import teech.sdk.exceptions.APIConnectionException;
import teech.sdk.exceptions.InvalidRequestException;
import teech.sdk.exceptions.TeechAuthenticationException;
import teech.sdk.exceptions.TeechException;

/**
 * A user object, like any other object, has a flexible schema but a username and a password are required.
 */
public class User extends TeechModel {
	
	/**
	 * Creates a new User object
	 */
	public User(){
		endpoint = "users";
	}
	
	/**
	 * Returns a boolean value. If the User is created successfully, this boolean is true, false otherwise. 
	 * <p>
	 * @param  username the User's username
	 * @param  password the User's password
	 * @return boolean
	 * @throws Exception 
	 * @throws TeechException 
	 * @throws APIConnectionException 
	 * @throws TeechAuthenticationException 
	 * @throws InvalidRequestException 
	 */
	public boolean create(String username, String password) throws InvalidRequestException, TeechAuthenticationException, APIConnectionException, TeechException, Exception{
		fields.put("username", username);
		fields.put("password", password);
		return this.save();
	}
	
	
	/**
	 * Return a JSONObject value. If the user Id and password are correctly, the boolean value is true, false otherwise. 
	 * <p>
	 * @param  user the Id of the user
	 * @param  password the password of the user
	 * @return boolean
	 */
	public JSONObject auth(String user, String password) throws InvalidRequestException, TeechAuthenticationException, APIConnectionException, TeechException, Exception{
		JSONObject object = null;
		String url = urlTeech+endpoint+"/signin?username="+user+"&password="+password;
		Connect cn = new Connect(url,"GET","");
		String result = cn.getResult();
		object = new JSONObject(result);
		return object;
	}
	
	/**
	 * Return a boolean value. If the user Id and password are correctly, the boolean value is true, false otherwise. 
	 * <p>
	 * @param  user the Id of the user
	 * @param  password the password of the user
	 * @return boolean
	 * @throws TeechException 
	 * @throws APIConnectionException 
	 * @throws TeechAuthenticationException 
	 * @throws InvalidRequestException 
	 */
	public boolean logIn(String user, String password) throws InvalidRequestException, TeechAuthenticationException, APIConnectionException, TeechException{
		String url = urlTeech+endpoint+"/signin?username="+user+"&password="+password;
		Connect cn = new Connect(url,"GET","");
		int code = cn.getResponseCode();
		 if(code==200){
			 return true;
		 }else{
			 return false;
		 }
	}
			
}
