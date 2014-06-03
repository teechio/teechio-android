package teech.sdk;

import teech.sdk.exceptions.APIConnectionException;
import teech.sdk.exceptions.InvalidRequestException;
import teech.sdk.exceptions.TeechAuthenticationException;
import teech.sdk.exceptions.TeechException;

/**
 * Enrollments allows you to enroll a user in a module and keep track of users enrollments.
 */
public class Enrollment extends TeechModel{
	
	public Enrollment() {
		endpoint="enrollments";
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
		String url = urlTeech+"enrollments/"+idUser+"/in/"+module;
		new Connect(url,"PUT", "");
		return true;
	}

	
	/**
	 * Return a Boolean value. If the object is correctly deleted, this boolean is true, false otherwise. 
	 * <p>
	 * @param idUser the id of the user
	 * @param idModule the id of the module
	 * @return boolean
	 * @throws TeechException 
	 * @throws APIConnectionException 
	 * @throws TeechAuthenticationException 
	 * @throws InvalidRequestException 
	 */
	public boolean delete(String idUser, String idModule) throws InvalidRequestException, TeechAuthenticationException, APIConnectionException, TeechException{
		String url = urlTeech+"enrollments/"+idUser+"/withdraw/"+idModule;
		new Connect(url,"DELETE", "");
		return true;
	}
		
}
	
