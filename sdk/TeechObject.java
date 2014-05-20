package teech.sdk;

import java.util.HashMap;
import java.util.Map;

import org.json.JSONObject;

/**
 * Teech.io REST API is built around JSON encoding of data and a schemaless data structure.
 * Working with a schemaless data structure means that, besides some required keys,
 * you don’t need to define ahead of time what keys are on each object.
 * You will simply set the key-value pairs you need and the backend will store them
 * in the cloud within your object.
 */
public class TeechObject extends TeechModel {
	
	/**
	 * Creates a new TeechObject
	 */
	public TeechObject(){
		fields = new HashMap<String, Object>();
	}
	

	/**
	 * Returns a boolean value. If the TeechObject is created successfully, this boolean is true, false otherwise. 
	 * <p>
	 * @param  name the name Object
	 * @param  data a Map<String, Object> with TeechObject data
	 * @return boolean
	 */
	public boolean create(String name, Map<String, Object> data){
		data.put("classname", name);
		fields = data;
		return this.save("classes");
	}
	
	/**
	 * Returns a boolean value. If the TeechObject is correctly updated, this boolean is true, false otherwise. 
	 * <p>
	 * @param  id the id of the TeechObject
	 * @param  data a Map<String, Object> that updates the object with new data. Any keys not specified will remain unchanged.
	 * @return boolean
	 */
	public boolean update(String id, Map<String, Object> data){
		return super.update("classes", id, data);
	}
	
	
	/**
	 * Returns a JSONObject that contain the user data. If the TeechObject Id is wrongs, return a null map. 
	 * <p>
	 * @param  id a TeechObject id of the object
	 * @return JSONObject
	 */
	public JSONObject fetch(String id){
		return super.fetch("classes",id);
	}
	
	/**
	 * Return a Boolean value. If the TeechObject is correctly deleted, this boolean is true, false otherwise. 
	 * <p>
	 * @param id the id of the TeechObject
	 * @return boolean
	 */
	public boolean delete(String id){
		return super.delete("classes",id);
	}

}
