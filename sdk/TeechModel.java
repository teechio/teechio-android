package teech.sdk;

import java.util.Map;

import org.json.JSONArray;
import org.json.JSONObject;

/**
 * @exlude 
 */
public class TeechModel {
	protected Map<String, Object> fields;
	protected JSONObject innerJSON;
	
	public static String urlTeech="http://api.teech.io/";
	
	public boolean save(String endpoint){
		int code=0;
		JSONObject object = null;
		String result = null;
		try{
			innerJSON = new JSONObject(fields);
			String text = innerJSON.toString();
			Connect cn = new Connect(urlTeech+endpoint,"POST", text);
			code = cn.getResponseCode();
			result = cn.getResult();
			object = new JSONObject(result);
			String id = object.getString("_id");
			fields.put("id", id);
		}catch(Exception e) {
			code=500;
		}
		if(code==200){
			return true;
		}else{
			return false;
		}
	}
	
	/**
	 * @exlude 
	 */
	public JSONObject fetch(String endpoint, String id){
		int code=0;
		JSONObject object = null;
		try{
			String url = urlTeech+endpoint+"/"+id;
			Connect cn = new Connect(url,"GET", "");
			String result = cn.getResult();
			code = cn.getResponseCode();
			object = new JSONObject(result);
		}catch(Exception e) {
			code=500;
		}
		 if(code==200){
			 try{
				 return object;
			 }catch(Exception e) {
				 return object;
			}
		 }else{
			 return object;
		 }
	}
	
	/**
	 * @exlude 
	 */
	public String getId(){
		return fields.get("id").toString();
	}
	

	/**
	 * @exlude 
	 */
	public boolean delete(String endpoint, String id){
		int code=0;
		try{
			String url = urlTeech+endpoint+"/"+id;
			Connect cn = new Connect(url,"DELETE", "");
			code = cn.getResponseCode();
		}catch(Exception e){
			code=500;
		}
		 if(code==200){
			 return true;
		 }else{
			 return false;
		 }
	}
	
	/**
	 * @exlude 
	 */
	public JSONArray fetchAll(String endpoint){
		int code=0;
		JSONArray array = null;
		try{
			String url = urlTeech+endpoint;
			Connect cn = new Connect(url,"GET", "");
			String result = cn.getResult();
			code = cn.getResponseCode();
			array = new JSONArray(result);
		}catch(Exception e) {
			code=500;
		}
		 if(code==200){
			 try{
				 return array;
			 }catch(Exception e) {
				 return array;
			}
		 }else{
			 return array;
		 }
	}
	
	/**
	 * @exlude 
	 */
	public boolean update(String endpoint, String user, Map<String, Object> data){
		int code=0;
		String text= "";
		JSONObject objectjson = new JSONObject(data);
		text = objectjson.toString();
		try{
			String url = urlTeech+endpoint+"/"+user;
			Connect cn = new Connect(url,"PUT", text);
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