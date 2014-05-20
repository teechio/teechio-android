package teech.sdk;

import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 * Using assignments you can attach materials to modules and register students
 * submissions in order to analyze and track their performance.
 *  
 */
public class Assignments extends TeechModel {
	
	/**
	 * Create a Assignment object
	 */
	public Assignments(){
		this.fields = new HashMap<String, Object>();
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
		return super.save("assignments");
	}
	
	/**
	 * Return a Boolean value. If the Assignment is correctly created, this boolean is true, false otherwise. 
	 * <p>
	 * @param title a title of the material
	 * @param material a materialId of the material
	 * @param module moduleId of the module
	 * @return boolean
	 */
	public boolean create(String title, String material, String module){
		fields.put("title", title);
		fields.put("material", material);
		fields.put("module", module);
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
		return super.update("assignments", id, data);
	}

	/**
	 * Returns a JSONObject that contain the user data. If the User Id is wrongs, return a null map. 
	 * <p>
	 * @param  user a userId of the User
	 * @return JSONObject
	 */
	public JSONObject fetch(String id){
		return super.fetch("assignments",id);
	}
	
	/**
	 * Returns a JSONArray that contains the users data. If the User Id is unsuccessfully, return a null JSONArray. 
	 * <p>
	 * @return JSONArray
	 */
	public JSONArray fetchAll(){
		return super.fetchAll("assignments");
	}
	
	/**
	 * Return a Boolean value. If the object is correctly deleted, this boolean is true, false otherwise. 
	 * <p>
	 * @param id the id of the object
	 * @return boolean
	 */
	public boolean delete(String id){
		return super.delete("assignments",id);
	}
	
	
}
