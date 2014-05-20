package teech.sdk;

import java.util.HashMap;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONObject;

/**
 * A module it’s a container with a certain number of didactic materials attached
 * to it as assignments. Modules can be very flexible and are designed to shape
 * educational entities like courses, lectures or sections or, if you are building
 * an edutainment app for example, you could use modules to shape game levels.
 * Furthermore, you can enroll users in a module. 
 */
public class Module extends TeechModel{
	
	/**
	 * Create a Module object
	 */
	public Module() {
		this.fields = new HashMap<String, Object>();
	}
	
	/**
	 * Create a Module object with taxonomy
	 */
	public Module(String taxonomy) {
		this.fields = new HashMap<String, Object>();
		fields.put("taxonomy", taxonomy);
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
		return super.save("modules");
	}
	
	/**
	 * Returns a boolean value. If the Module is created successfully, this boolean is true, false otherwise. 
	 * <p>
	 * @param  title the Module's title
	 * @param  description the Module's description
	 * @return boolean
	 */
	public boolean create(String title, String description){
		fields.put("title", title);
		fields.put("description", description);
		return this.save();
	}
	
	/**
	 * Returns a boolean value. If the User is correctly updated, this boolean is true, false otherwise. 
	 * <p>
	 * @param  id the id of the object
	 * @param  data a Map<String, Object> that updates the object with new data. Any keys not specified will remain unchanged.
	 * @return boolean
	 */
	public boolean update(String id, Map<String, Object> data){
		return super.update("modules", id, data);
	}

	/**
	 * Returns a JSONObject that contain the user data. If the User Id is wrongs, return a null map. 
	 * <p>
	 * @param  user a userId of the User
	 * @return JSONObject
	 */
	public JSONObject fetch(String id){
		return super.fetch("modules",id);
	}
	
	/**
	 * Returns a JSONArray that contains the users data. If the User Id is unsuccessfully, return a null JSONArray. 
	 * <p>
	 * @return JSONArray
	 */
	public JSONArray fetchAll(){
		return super.fetchAll("modules");
	}
	
	/**
	 * Return a Boolean value. If the object is correctly deleted, this boolean is true, false otherwise. 
	 * <p>
	 * @param id the id of the object
	 * @return boolean
	 */
	public boolean delete(String id){
		return super.delete("modules",id);
	}
}


