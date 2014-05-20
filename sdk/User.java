package teech.sdk;

import java.util.HashMap;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONObject;

/**
 * A user object, like any other object, has a flexible schema but a username and a password are required.
 */
public class User extends TeechModel {
	
	/**
	 * Creates a new User object
	 */
	public User(){
		fields = new HashMap<String, Object>();
	}
	
	/**
	 * Puts the data in the object
	 */
	public void put(String key, Object value) {
		fields.put(key, value);
	}
	
	/**
	 * Gets an object property by key
	 */
	public Object get(String key) {
		return this.fields.get(key);
	}

	/**
	 * Removes an object property by key
	 */
	public void remove(String key) {
		this.fields.remove(key);
	}
	
	/**
	 * Stores the object in the Teech.io backend
	 */
	public boolean save(){
		return super.save("users");
	}

	/**
	 * Returns a boolean value. If the User is created successfully, this boolean is true, false otherwise. 
	 * <p>
	 * @param  username the User's username
	 * @param  password the User's password
	 * @return boolean
	 */
	public boolean create(String username, String password){
		fields.put("username", username);
		fields.put("password", password);
		return this.save();
	}
	
	
	/**
	 * Returns a boolean value. If the User is correctly updated, this boolean is true, false otherwise. 
	 * <p>
	 * @param  user the id of the User
	 * @param  data a Map<String, Object> that updates the object with new data. Any keys not specified will remain unchanged.
	 * @return boolean
	 */
	public boolean update(String user, Map<String, Object> data){
		return super.update("users", user, data);
	}


	/**
	 * Returns a JSONObject that contain the user data. If the User Id is wrongs, return a null map. 
	 * <p>
	 * @param  user a userId of the User
	 * @return JSONObject
	 */
	public JSONObject fetch(String id){
		return super.fetch("users",id);
	}
	
	/**
	 * Returns a JSONArray that contains the users data. If the User Id is unsuccessfully, return a null JSONArray. 
	 * <p>
	 * @return JSONArray
	 */
	public JSONArray fetchAll(){
		return super.fetchAll("users");
	}
	
	/**
	 * Return a Boolean value. If the object is correctly deleted, this boolean is true, false otherwise. 
	 * <p>
	 * @param id the id of the object
	 * @return boolean
	 */
	public boolean delete(String id){
		return super.delete("users",id);
	}
	
	/**
	 * Return a Map<String, Object> value of data user description. If the user Id and password are unsuccessfully, return a null Map. 
	 * <p>
	 * @param  user the Id of the user
	 * @param  password the password of the user
	 * @return Map<String, Object>
	 */
	public JSONObject auth(String user, String password){
		int code=0;
		JSONObject object = null;
		try{
			String url = urlTeech+"users/signin?username="+user+"&password="+password;
			System.out.println(url);
			Connect cn = new Connect(url,"GET","");
			String result = cn.getResult();
			code = cn.getResponseCode();
			object = new JSONObject(result);
		}catch(Exception e) {
			code=500;
		}
		 if(code==200){
			 return object;
		 }else{
			 return object;
		 }
	}
	
	/**
	 * Return a boolean value. If the user Id and password are correctly, the boolean value is true, false otherwise. 
	 * <p>
	 * @param  user the Id of the user
	 * @param  password the password of the user
	 * @return boolean
	 */
	public boolean logIn(String user, String password){
		int code=0;
		try{
			String url = urlTeech+"users/signin?username="+user+"&password="+password;
			System.out.println(url);
			Connect cn = new Connect(url,"GET","");
			code = cn.getResponseCode();
		}catch(Exception e) {
			code=500;
		}
		 if(code==200){
			 return true;
		 }else{
			 return false;
		 }
	}
			
}
