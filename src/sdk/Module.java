package teech.sdk;

/**
 * A module it’s a container with a certain number of didactic materials attached
 * to it as assignments. Modules can be very flexible and are designed to shape
 * educational entities like courses, lectures or sections or, if you are building
 * an edutainment app for example, you could use modules to shape game levels.
 * Furthermore, you can enroll users in a module. 
 */
public class Module extends TeechModel{
	
	/**
	 * Create a Module object
	 */
	public Module() {
		endpoint="modules";
	}
	
	
}


