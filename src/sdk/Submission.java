package teech.sdk;


import teech.sdk.exceptions.APIConnectionException;
import teech.sdk.exceptions.InvalidRequestException;
import teech.sdk.exceptions.TeechAuthenticationException;
import teech.sdk.exceptions.TeechException;

/**
 *Submissions lets you to assess students based on assignments and evaluate their performance.
 */
public class Submission extends TeechModel{
	
	/**
	 * Create a Submission object
	 */
	public Submission() {
		endpoint="submissions";
	}

	/**
	 * Returns a boolean value. If the Grading is correctly created, this boolean is true, false otherwise. 
	 * <p>
	 * @param  submissionId the id of the submission
	 * @param  score the score of the submission
	 * @return JSONObject
	 * @throws TeechException 
	 * @throws APIConnectionException 
	 * @throws TeechAuthenticationException 
	 * @throws InvalidRequestException 
	 */
	public boolean grading(String submissionId, String score) throws InvalidRequestException, TeechAuthenticationException, APIConnectionException, TeechException{
		int code=0;
		String url = urlTeech+endpoint+"/"+submissionId+"/score";
		String s = "{\"score\":\""+score+"\"}";
		Connect cn = new Connect(url,"PUT", s );
		code = cn.getResponseCode();
		if(code==200){
			return true;
		}else{
			return false;
		}
	}
	
}
