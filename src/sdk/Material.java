package teech.sdk;

import java.util.Map;
import teech.sdk.exceptions.APIConnectionException;
import teech.sdk.exceptions.InvalidRequestException;
import teech.sdk.exceptions.TeechAuthenticationException;
import teech.sdk.exceptions.TeechException;

/**
 * Materials are designed to shape didactic materials objects. 
 */
public class Material extends TeechModel{
	
	
	/**
	 * Create a Material object
	 */
	public Material() {
		endpoint="materials/";
	}
	
	/**
	 * Return a Boolean value. If the Media Material is correctly created, this boolean is true, false otherwise. 
	 * <p>
	 * @param title a media title of the material
	 * @param description a media description of the material
	 * @param source a url of the media
	 * @return boolean
	 * @throws Exception 
	 * @throws TeechException 
	 * @throws APIConnectionException 
	 * @throws TeechAuthenticationException 
	 * @throws InvalidRequestException 
	 */
	public boolean createMedia(String title, String description, String url) throws InvalidRequestException, TeechAuthenticationException, APIConnectionException, TeechException, Exception{
		fields.put("title", title);
		fields.put("description", description);
		fields.put("source", url);
		fields.put("type", "media");
		return this.save();
		
	}
	
	/**
	 * Return a Boolean value. If the MultipleChoice Material is correctly created, this boolean is true, false otherwise. 
	 * <p>
	 * @param title a material title
	 * @param description a description of material
	 * @param data a Map<String, Integer> what contain the Key - Value of the MultipleChoice
	 * @return boolean
	 * @throws Exception 
	 * @throws TeechException 
	 * @throws APIConnectionException 
	 * @throws TeechAuthenticationException 
	 * @throws InvalidRequestException 
	 */
	public boolean createMultipleChoice(String title, String description, Map<String, Integer> data ) throws InvalidRequestException, TeechAuthenticationException, APIConnectionException, TeechException, Exception{
		fields.put("title", title);
		fields.put("description", description);
		fields.put("type", "multiple-choice");
		fields.put("choices", data);
		return this.save();
		
	}
	
	/**
	 * Return a Boolean value. If the TrueFalse Material is correctly created, this boolean is true, false otherwise. 
	 * <p>
	 * @param title a material title
	 * @param description a description of material
	 * @param data a Map<String, Integer> what contain the Key - Value
	 * @return boolean
	 * @throws Exception 
	 * @throws TeechException 
	 * @throws APIConnectionException 
	 * @throws TeechAuthenticationException 
	 * @throws InvalidRequestException 
	 */
	public boolean createTrueFalse(String title, String description, Map<String, Integer> data ) throws InvalidRequestException, TeechAuthenticationException, APIConnectionException, TeechException, Exception{
		fields.put("title", title);
		fields.put("description", description);
		fields.put("type", "true-false");
		fields.put("choices", data);
		return this.save();
		
	}
	
}
