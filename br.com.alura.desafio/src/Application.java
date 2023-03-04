import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Application {
    public static void main(String[] args) throws URISyntaxException, IOException, InterruptedException {
        final var request = HttpRequest.newBuilder().uri(new URI("https://imdb-api.com/en/API/Top250Movies"))
                .GET().build();

        final var client = HttpClient.newHttpClient();

        final HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        System.out.println(response.body());
    }
}
