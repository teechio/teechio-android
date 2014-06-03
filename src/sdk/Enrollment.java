package teech.sdk;


import org.json.JSONObject;

import teech.sdk.exceptions.APIConnectionException;
import teech.sdk.exceptions.InvalidRequestException;
import teech.sdk.exceptions.TeechAuthenticationException;
import teech.sdk.exceptions.TeechException;

/**
 * Enrollments allows you to enroll a user in a module and keep track of users enrollments.
 */
public class Enrollment extends TeechModel{
	
	
	public Enrollment() {
		
	}
	
	/**
	 * Return a Boolean value. If the Enroll media is correctly created, this boolean is true, false otherwise. 
	 * <p>
	 * @param idUser a userId of the user
	 * @param module a moduleId of the module
	 * @return boolean
	 * @throws TeechException 
	 * @throws APIConnectionException 
	 * @throws TeechAuthenticationException 
	 * @throws InvalidRequestException 
	 */
	public static boolean enroll(String idUser, String module) throws InvalidRequestException, TeechAuthenticationException, APIConnectionException, TeechException{
		int code=0;
			String url = urlTeech+"enrollments/"+idUser+"/in/"+module;
			Connect cn = new Connect(url,"PUT", "");
			code = cn.getResponseCode();
		if(code==200){
			return true;
		}else{
			return false;
		}
	}

	/**
	 * Returns a JSONObject that contain the user data. If the User Id is wrongs, return a null map. 
	 * <p>
	 * @param  userId the id of the User
	 * @return JSONObject
	 */
	public JSONObject fetch(String userId){
		return super.fetch("enrollments",userId);
	}
	
	/**
	 * Return a Boolean value. If the object is correctly deleted, this boolean is true, false otherwise. 
	 * <p>
	 * @param idUser the id of the user
	 * @param idModule the id of the module
	 * @return boolean
	 */
	public boolean delete(String idUser, String idModule){
		int code=0;
		try{
			String url = urlTeech+"enrollments/"+idUser+"/withdraw/"+idModule;
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
		
}
	
