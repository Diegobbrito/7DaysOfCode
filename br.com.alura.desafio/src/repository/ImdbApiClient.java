package repository;

import dto.APIClient;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ImdbApiClient implements APIClient {

    private final HttpClient client;

    public ImdbApiClient() {
        this.client = HttpClient.newHttpClient();
    }

    @Override
    public String getBody() {
        try{
            HttpRequest request = HttpRequest.newBuilder().uri(new URI("https://imdb-api.com/en/API/Top250Movies/"))
                    .GET().build();
            return client.send(request, HttpResponse.BodyHandlers.ofString()).body();
        } catch (Exception e){
            return null;
        }
    }

    @Override
    public Class type() {
        return null;
    }
}
