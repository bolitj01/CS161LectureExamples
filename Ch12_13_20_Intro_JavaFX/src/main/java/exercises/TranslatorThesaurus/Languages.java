package exercises.TranslatorThesaurus;

import java.io.IOException;
import java.util.ArrayList;

import org.asynchttpclient.AsyncHttpClient;
import org.asynchttpclient.DefaultAsyncHttpClient;
import org.asynchttpclient.Response;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Languages {

	private ArrayList<String> languages;
	private ArrayList<String> codes;
	
	public Languages() {
		languages = new ArrayList<>();
        codes = new ArrayList<>();
	}
	
	public void addLanguage(String lang, String code) {
		languages.add(lang);
		codes.add(code);
	}
	
	public String getLanguageCode(String lang) {
		int index = languages.indexOf(lang);
		return codes.get(index);
	}
	
	public ArrayList<String> getLanguages() {
		return languages;
	}
	
	public static String translateTo(String original, String langCode) {
		AsyncHttpClient client = new DefaultAsyncHttpClient();

		String jsonBody = String.format(
				"{\"input_text\":\"%s\",\"origin_language\":\"en\",\"target_language\":\"%s\"}",
				original.replace("\"", "\\\""), langCode);

		Response response = client.prepare("POST", "https://translateai.p.rapidapi.com/google/translate/text")
				.setHeader("x-rapidapi-key", "52af9ce6b1msh6b20c18c3439862p11a651jsn51cbed85b1d5")
				.setHeader("x-rapidapi-host", "translateai.p.rapidapi.com")
				.setHeader("Content-Type", "application/json")
				.setBody(jsonBody)
				.execute()
				.toCompletableFuture()
				.join();

		try {
			client.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

		ObjectMapper objectMapper = new ObjectMapper();

		Translation translation = null;
		try {
			String translatedText = objectMapper.readTree(response.getResponseBody()).get("translation").asText();
			translation = new Translation(translatedText);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}

		return translation == null ? null : translation.getTranslation();
	}
	
}
