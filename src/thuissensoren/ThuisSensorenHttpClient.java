package thuissensoren;

import org.json.JSONObject;
import org.json.JSONException;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

public class ThuisSensorenHttpClient {

	private final String endpointUrl;

    public ThuisSensorenHttpClient(String endpointUrl) {
        this.endpointUrl = endpointUrl;
    }
    
    public JSONObject getResource(String resourceIdentifier) throws RestClientException, JSONException, HttpServerErrorException {
	   	RestTemplate restTemplate = new RestTemplate();
    	ResponseEntity<String> response = restTemplate.exchange(endpointUrl + resourceIdentifier, HttpMethod.GET, null, String.class);
        return new JSONObject(response.getBody());
    }
	
}
