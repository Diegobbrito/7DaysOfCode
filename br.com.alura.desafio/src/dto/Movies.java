package dto;

public class Movies {
    private String titulo;
    private String url;
    private String nota;
    private int ano;
    public Movies(String titulo, String url, String nota, int ano) {
        this.titulo = titulo;
        this.url = url;
        this.nota = nota;
        this.ano = ano;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getUrl() {
        return url;
    }

    public String getNota() {
        return nota;
    }

    public int getAno() {
        return ano;
    }
}