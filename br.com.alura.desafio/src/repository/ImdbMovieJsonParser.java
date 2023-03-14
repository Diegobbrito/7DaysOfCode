package repository;

import com.google.gson.GsonBuilder;
import dto.ImdbFullResponse;
import dto.JsonParser;
import dto.Movie;

import java.util.List;
import java.util.stream.Collectors;

public class ImdbMovieJsonParser implements JsonParser {
    private String json;

    public ImdbMovieJsonParser(String json) {
        this.json = json;
    }

    public List<Movie> parse(){
        var response =  new GsonBuilder().create().fromJson(json, ImdbFullResponse.class);
        return response.getItems()
                .stream()
                .map(m ->
                        new Movie(m.getTitle(), m.getImage(), m.getImDbRating(), m.getYear()))
                .collect(Collectors.toList());
    }
}
