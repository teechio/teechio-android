package teech.sdk;

import java.util.HashMap;

/**
 *Submissions lets you to assess students based on assignments and evaluate their performance.
 */
public class Submission extends TeechModel{
	
	/**
	 * Create a Submission object
	 */
	public Submission() {
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
		return super.save("submissions");
	}
	
	/**
	 * Return a Boolean value. If the Submission is correctly created, this boolean is true, false otherwise. 
	 * <p>
	 * @param  user the id of user
	 * @param  assignment the selected assignment id 
	 * @param  body the body response of the quiz 
	 * @return boolean
	 */
	public boolean create(String user, String assignment, String body){
		fields.put("user", user);
		fields.put("assignment", assignment);
		fields.put("body", body);
		return this.save();
	}
	
	/**
	 * Returns a boolean value. If the Grading is correctly created, this boolean is true, false otherwise. 
	 * <p>
	 * @param  submissionId the id of the submission
	 * @param  score the score of the submission
	 * @return JSONObject
	 */
	public boolean grading(String submissionId, String score){
		int code=0;
		String url = urlTeech+"submissions/"+submissionId+"/score";
		String s = "{\"score\":\""+score+"\"}";
		Connect cn = new Connect(url,"PUT", s );
		code = cn.getResponseCode();
		if(code==200){
			return true;
		}else{
			return false;
		}
	}
	
	/**
	 * Return a Boolean value. If the object is correctly deleted, this boolean is true, false otherwise. 
	 * <p>
	 * @param id the id of the object
	 * @return boolean
	 */
	public boolean delete(String id){
		return super.delete("submissions",id);
	}
	
}
