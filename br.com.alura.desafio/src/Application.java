import repository.HTMLGenerator;
import repository.ImdbApiClient;
import repository.ImdbMovieJsonParser;

import java.io.IOException;
import java.io.PrintWriter;

public class Application {
    public static void main(String[] args) throws IOException {

        final var api = new ImdbApiClient();
        final var json = api.getImdbTop250();
        final var movies = new ImdbMovieJsonParser(json).parse();
        new HTMLGenerator(new PrintWriter("content.html")).generate(movies);

    }

}
