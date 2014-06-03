package teech.sdk;

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
		endpoint="classes/";
	}
	

}
