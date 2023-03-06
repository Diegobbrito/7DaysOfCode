import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) throws URISyntaxException, IOException, InterruptedException {
        final var request = HttpRequest.newBuilder().uri(new URI("https://imdb-api.com/en/API/Top250Movies/"))
                .GET().build();

        final var client = HttpClient.newHttpClient();

        final HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

       final var json = response.body().substring(response.body().indexOf("[")+1, response.body().indexOf("]"));

       final var jsonFilmes = json.replace("},", "}\n").split("\n");
       List<String> titulos = retornaListaDeFilmes(jsonFilmes);

       titulos.forEach(System.out::println);

    }

    private static List<String> retornaListaDeFilmes(String[] jsonFilmes) {
        List<String> titulos = new ArrayList<>();
        for (String filme: jsonFilmes) {
            final var infos = filme.split(",");
            titulos.add(infos[2].substring(9, infos[2].length() -1));
        }
        return titulos;
    }
}
