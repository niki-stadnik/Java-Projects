/**
 * Add com.github.scribejava/scribejava-apis and org.json/json dependencies
 */

package no.adax.client.api;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.stream.Collectors;
import javax.net.ssl.HttpsURLConnection;
import org.json.JSONArray;
import org.json.JSONObject;
import com.github.scribejava.apis.openid.OpenIdJsonTokenExtractor;
import com.github.scribejava.core.builder.ServiceBuilder;
import com.github.scribejava.core.builder.api.DefaultApi20;
import com.github.scribejava.core.extractors.TokenExtractor;
import com.github.scribejava.core.model.OAuth2AccessToken;
import com.github.scribejava.core.oauth.OAuth20Service;

public class adax
{
    private String apiUrl = "https://api-1.adax.no/client-api";
    private String clientId = "67888"; // replace with your client ID (see Adax WiFi app, Account Section)
    private String clientSecret = "I4du82EaSakZFQX5"; // replace with your client secret (see Adax WiFi app, Account Section -> Third party integrations -> Remote user client API)

    public static void main(String[] args) throws Exception
    {
        ClientDemo client = new ClientDemo();

        String token = client.getToken();

        // Change the temperature to 24 C in the room with an Id of 196342
        // Replace the 196342 with the room id from the getHomesInfo output
        client.setRoomTargetTemperature(196342, 2400, token);
        client.getHomesInfo(token);
    }

    /**
     * Sets target temperature of the room
     *
     * @throws IOException
     */
    private void setRoomTargetTemperature(int roomId, int temperature, String token) throws Exception
    {
        String postData = "{ \"rooms\": [{ \"id\": " + roomId + ", \"targetTemperature\": " + temperature + " }] }";

        HttpsURLConnection connection = (HttpsURLConnection)(new URL(apiUrl + "/rest/v1/control/").openConnection());
        connection.setRequestProperty("Authorization", "Bearer " + token);
        connection.setDoOutput(true);
        connection.setRequestMethod("POST");
        connection.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
        connection.setRequestProperty("Accept", "application/json");

        byte[] input = postData.getBytes("utf-8");
        connection.setFixedLengthStreamingMode(input.length);

        connection.connect();
        connection.getOutputStream().write(input);
        connection.getOutputStream().close();

        String response = new BufferedReader(new InputStreamReader(connection.getInputStream(), StandardCharsets.UTF_8)).lines().collect(Collectors.joining("\n"));
        connection.getInputStream().close();
        System.out.println(response);
    }

    private void getHomesInfo(String token) throws Exception
    {
        HttpsURLConnection connection = (HttpsURLConnection)(new URL(apiUrl + "/rest/v1/content/").openConnection());

        connection.setRequestProperty("Authorization", "Bearer " + token);
        connection.setDoOutput(true);
        connection.setRequestMethod("GET");
        connection.connect();

        String response = new BufferedReader(new InputStreamReader(connection.getInputStream(), StandardCharsets.UTF_8)).lines().collect(Collectors.joining("\n"));
        connection.getInputStream().close();

        JSONObject jsonObject = new JSONObject(response);
        JSONArray jsonArray = jsonObject.getJSONArray("rooms");

        for (int i = 0; i < jsonArray.length(); i++)
        {
            JSONObject roomData = jsonArray.getJSONObject(i);

            String roomName = roomData.getString("name");
            int roomId = roomData.getInt("id");
            int targetTemperature = roomData.getInt("targetTemperature") / 100;
            int currentTemperature = 0;

            if (!roomData.isNull("temperature"))
            {
                currentTemperature = roomData.getInt("temperature") / 100;
            }

            System.out.println(String.format("Room: %15s, Target: %5d, Temperature: %5d, id: %5d", roomName, targetTemperature, currentTemperature, roomId));
        }
    }

    /**
     * Authenticate and obtain JWT token
     */
    private String getToken() throws Exception
    {
        DefaultApi20 api = new DefaultApi20()
        {
            public String getAccessTokenEndpoint()
            {
                return apiUrl + "/auth/token";
            }

            public TokenExtractor<OAuth2AccessToken> getAccessTokenExtractor()
            {
                return OpenIdJsonTokenExtractor.instance();
            }

            protected String getAuthorizationBaseUrl()
            {
                throw new UnsupportedOperationException();
            }

            public String getRevokeTokenEndpoint()
            {
                throw new UnsupportedOperationException();
            }
        };

        OAuth20Service service = new ServiceBuilder(this.clientId).apiSecret(this.clientSecret).build(api);

        return service.getAccessTokenPasswordGrant(this.clientId, this.clientSecret).getAccessToken();
    }
}