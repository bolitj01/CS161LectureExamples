package exercises.TranslatorThesaurus;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Translation {

	@JsonProperty("translated_text")
	private String trans;
	
	public Translation() {}
	
	public Translation(String trans) {
        this.trans = trans;
	}

	public void setTrans(String trans) {
		this.trans = trans;
	}

	public String getTranslation() {
        return trans;
	}
}
