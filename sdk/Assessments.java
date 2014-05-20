package teech.sdk;

import java.util.HashMap;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONObject;

/**
 * Assessments let you manage the assessment process by creating rules
 * that can be used later to evaluate students submissions to assignments.
 * In Teech.io an assessment is a standalone object so you are not forced
 * to attach it to an assignment when you create it. You can create how many 
 * assessment objects you need and later decide with wich assessment rule you
 * want evaluate each assignment.
 */
public class Assessments extends TeechModel {
	
	/**
	 * Create a Assessment object
	 */
	public Assessments(){
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
		return super.save("assessments");
	}
	
	/**
	 * Return a Boolean value. If the Assessment is correctly created, this boolean is true, false otherwise. 
	 * <p>
	 * @param title a assessment title
	 * @param subject a subject of the assessment
	 * @param type a type of assessment (You can choose from 4 different types: pass_fail, letters, points and percentile)
	 * @return boolean
	 */
	public boolean create(String title, String subject, String type){
		fields.put("title",title);
		fields.put("subject", subject);
		fields.put("type", type);
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
		return super.update("assessments", id, data);
	}

	/**
	 * Returns a JSONObject that contain the user data. If the User Id is wrongs, return a null map. 
	 * <p>
	 * @param  user a userId of the User
	 * @return JSONObject
	 */
	public JSONObject fetch(String id){
		return super.fetch("assessments",id);
	}
	
	/**
	 * Returns a JSONArray that contains the users data. If the User Id is unsuccessfully, return a null JSONArray. 
	 * <p>
	 * @return JSONArray
	 */
	public JSONArray fetchAll(){
		return super.fetchAll("assessments");
	}
	
	/**
	 * Return a Boolean value. If the object is correctly deleted, this boolean is true, false otherwise. 
	 * <p>
	 * @param id the id of the object
	 * @return boolean
	 */
	public boolean delete(String id){
		return super.delete("assessments",id);
	}
}
