package repository;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import dto.FullResponse;
import dto.MoviesResponse;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ImdbApiClient {

    private HttpClient client;
    private HttpRequest request;
    private HttpResponse response;

    public FullResponse getImdbTop250(){
        client = HttpClient.newHttpClient();
        try{
            request = HttpRequest.newBuilder().uri(new URI("https://imdb-api.com/en/API/Top250Movies/"))
                .GET().build();
            response = client.send(request, HttpResponse.BodyHandlers.ofString());

            Gson gson = new GsonBuilder().create();
            return gson.fromJson(response.toString(), FullResponse.class);
        }catch (Exception e){

        }
        return null;
    }

}
