package repository;

import dto.APIClient;

import java.math.BigInteger;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.security.MessageDigest;
import java.time.Instant;

public class MarvelApiClient implements APIClient {

    private final HttpClient client;

    public MarvelApiClient() {
        this.client = HttpClient.newHttpClient();
    }

    @Override
    public String getBody() {

        String privateKey = "";
        String publicKey = "";
        var ts = Instant.now().getEpochSecond();
        var hashKeys = ts + privateKey + publicKey;
        try{
            MessageDigest md = MessageDigest.getInstance("MD5");
            var hash = new BigInteger(1, md.digest(hashKeys.getBytes())).toString(16);

            HttpRequest request = HttpRequest.newBuilder().uri(new URI("https://gateway.marvel.com:443/v1/public/comics?ts=" + ts+ "&apikey="+ publicKey + "&hash=" + hash  ))
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
