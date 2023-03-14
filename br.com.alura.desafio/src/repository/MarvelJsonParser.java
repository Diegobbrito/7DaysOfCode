package repository;

import com.google.gson.GsonBuilder;
import dto.Content;
import dto.JsonParser;
import dto.Movie;
import dto.marvel.Date;
import dto.marvel.Image;
import dto.marvel.MarvelFullResponse;

import java.util.List;
import java.util.stream.Collectors;

public class MarvelJsonParser implements JsonParser {

    private String json;
    public MarvelJsonParser(String json) {
        this.json = json;
    }

    @Override
    public List<? extends Content> parse() {
        var response =  new GsonBuilder().create().fromJson(json, MarvelFullResponse.class);
        return response.getData().getResults()
                .stream()
                .map(m ->{
                    var title = m.getTitle();
                    var image = m.getImages().stream().findFirst().orElseGet(()->new Image("", "")).getPath();
                    var id = m.getId().toString();
                    var date = m.getDates().stream().findFirst().orElseGet(()->new Date("", "")).getDate();
                    return new Movie(title, image, id, date);
                })
                .collect(Collectors.toList());
    }
}
