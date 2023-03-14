package dto;

public class Movie implements Content {
    private String titulo;
    private String url;
    private String nota;
    private String ano;
    public Movie(String titulo, String url, String nota, String ano) {
        this.titulo = titulo;
        this.url = url;
        this.nota = nota;
        this.ano = ano;
    }

    @Override
    public String title() {
        return titulo;
    }

    @Override
    public String urlImage() {
        return url;
    }

    @Override
    public String rating() {
        return nota;
    }

    @Override
    public String year() {
        return ano;
    }
}