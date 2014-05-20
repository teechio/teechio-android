package teech.sdk;

import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 * Materials are designed to shape didactic materials objects. 
 */
public class Material extends TeechModel{
	
	/**
	 * Create a Material object with taxonomy
	 */
	public Material(String taxonomy) {
		this.fields = new HashMap<String, Object>();
		fields.put("taxonomy", taxonomy);
	}
	
	/**
	 * Create a Material object
	 */
	public Material() {
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
		return super.save("materials");
	}
	
	/**
	 * Return a Boolean value. If the Material is correctly created, this boolean is true, false otherwise. 
	 * <p>
	 * @param title a material title
	 * @param description a description of material
	 * @param  type a type of material (You can choose from 5 different types: multiple-choice, open-ended, true-false, media and the generic type other)
	 * @return boolean
	 */
	public boolean create(String title, String description, String type){
		fields.put("title", title);
		fields.put("description", description);
		fields.put("type",type);
		return this.save();
		
	}
	
	/**
	 * Return a Boolean value. If the Media Material is correctly created, this boolean is true, false otherwise. 
	 * <p>
	 * @param title a media title of the material
	 * @param description a media description of the material
	 * @param source a url of the media
	 * @return boolean
	 */
	public boolean createMedia(String title, String description, String url){
		
		fields.put("title", title);
		fields.put("description", description);
		fields.put("source", url);
		fields.put("type", "media");
		return this.save();
		
	}
	
	/**
	 * Return a Boolean value. If the MultipleChoice Material is correctly created, this boolean is true, false otherwise. 
	 * <p>
	 * @param title a material title
	 * @param description a description of material
	 * @param data a Map<String, Integer> what contain the Key - Value of the MultipleChoice
	 * @return boolean
	 */
	public boolean createMultipleChoice(String title, String description, Map<String, Integer> data ){
		fields.put("title", title);
		fields.put("description", description);
		fields.put("type", "multiple-choice");
		fields.put("choices", data);
		return this.save();
		
	}
	
	/**
	 * Return a Boolean value. If the TrueFalse Material is correctly created, this boolean is true, false otherwise. 
	 * <p>
	 * @param title a material title
	 * @param description a description of material
	 * @param data a Map<String, Integer> what contain the Key - Value
	 * @return boolean
	 */
	public boolean createTrueFalse(String title, String description, Map<String, Integer> data ){
		fields.put("title", title);
		fields.put("description", description);
		fields.put("type", "true-false");
		fields.put("choices", data);
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
		return super.update("materials", id, data);
	}

	/**
	 * Returns a JSONObject that contain the user data. If the User Id is wrongs, return a null map. 
	 * <p>
	 * @param  id a id of the Material
	 * @return JSONObject
	 */
	public JSONObject fetch(String id){
		return super.fetch("materials",id);
	}
	
	/**
	 * Returns a JSONArray that contains the users data. If the User Id is unsuccessfully, return a null JSONArray. 
	 * <p>
	 * @return JSONArray
	 */
	public JSONArray fetchAll(){
		return super.fetchAll("materials");
	}
	
	/**
	 * Return a Boolean value. If the object is correctly deleted, this boolean is true, false otherwise. 
	 * <p>
	 * @param id the id of the object
	 * @return boolean
	 */
	public boolean delete(String id){
		return super.delete("materials",id);
	}
	
}
