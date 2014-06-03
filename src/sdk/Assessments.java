package teech.sdk;

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
		endpoint="Assessment/";
	}
	
}
