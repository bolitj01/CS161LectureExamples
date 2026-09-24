package exercises.TranslatorThesaurus;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;


//Main class for the JSON response, without including antonyms
public class Thesaurus {

	// Method to collect all context items into an ArrayList and return it
    public ArrayList<String> getSynonyms() {
        ArrayList<String> synonyms = new ArrayList<>(this.synonyms);
        return synonyms;
    }
    
    //Below is processing of the JSON response
	private String word;
	private List<String> synonyms;
	private List<String> antonyms;
	
	// Constructors, getters, and setters
	public Thesaurus() {}
	
	public Thesaurus(String word, List<String> synonyms, List<String> antonyms) {
		this.word = word;
		this.synonyms = synonyms;
		this.antonyms = antonyms;
	}

	public String getWord() {
		return word;
	}

	public void setWord(String word) {
		this.word = word;
	}

	public List<String> getAntonyms() {
		return antonyms;
	}

	public void setAntonyms(List<String> antonyms) {
		this.antonyms = antonyms;
	}

	public void setSynonyms(List<String> synonyms) {
		this.synonyms = synonyms;
	}
	
	public static ArrayList<String> lookupSynonyms(String word) {
		HttpRequest request = HttpRequest.newBuilder()
				.uri(URI.create("https://thesaurus-by-api-ninjas.p.rapidapi.com/v1/thesaurus?word=" + word))
				.header("X-RapidAPI-Key", "52af9ce6b1msh6b20c18c3439862p11a651jsn51cbed85b1d5")
				.header("X-RapidAPI-Host", "thesaurus-by-api-ninjas.p.rapidapi.com")
				.method("GET", HttpRequest.BodyPublishers.noBody())
				.build();
		
		HttpResponse<String> response = null;
		try {
			response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
		} catch (IOException | InterruptedException e) {
			e.printStackTrace();
		}
		
		//Convert response.body from JSON
		//to an ArrayList of synonyms		
		ObjectMapper objectMapper = new ObjectMapper();
		Thesaurus thesaurus = null;
		try {
			thesaurus = objectMapper.readValue(response.body(), Thesaurus.class);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		
		return thesaurus.getSynonyms();
	}
	
}

