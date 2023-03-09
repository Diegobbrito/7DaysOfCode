package repository;

import com.google.gson.GsonBuilder;
import dto.FullResponse;
import dto.Movies;

import java.util.List;
import java.util.stream.Collectors;

public class ImdbMovieJsonParser {
    private String json;

    public ImdbMovieJsonParser(String json) {
        this.json = json;
    }

    public List<Movies> parse(){
        var response =  new GsonBuilder().create().fromJson(json, FullResponse.class);
        return response.getItems()
                .stream()
                .map(m ->
                        new Movies(m.getTitle(), m.getImage(), m.getImDbRating(), m.getYear()))
                .collect(Collectors.toList());
    }
}
