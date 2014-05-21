package teech.sdk;

public class Teech {
		
	/**
	 * Insert your Api Key
	 */
	private static String APIkey="";
	
	/**
	 * Insert your App id
	 */
	private static String APPid="";
	
	/**
	 * Initialize Teech.io 
	 * <p>
	 * @param  apiK - Api Key
	 * @param  appId - App id
	 * @return void
	 */
	public static void init(String apiK, String appId){
		 APIkey = apiK;
		 APPid= appId;
	}
	
	/**
	 * @exclude 
	 */
	protected String getAPIkey(){
		return APIkey;
	}
	
	/**
	 * @exclude 
	 */
	protected String APPid(){
		return APPid;
	}
	
}
