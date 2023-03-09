package repository;

import dto.Movies;

import java.io.IOException;
import java.io.Writer;
import java.util.List;

public class HTMLGenerator {
    private final Writer writer;

    public HTMLGenerator(Writer writer) {
        this.writer = writer;
    }

    public void generate(List<Movies> movies) throws IOException {

        writer.write("<head><meta charset=uft-8></head>");
        writer.write("<body>");

        movies.forEach(m -> {
            try {
                String image =  m.getUrl();
                int ano = m.getAno();
                String nota = m.getNota();
                writer.write("<h2>"+m.getTitulo()+"</h2>");
                writer.write("<br><img src=" +image + " width=\"450\" height=\"600\"><br>");
                writer.write("Ano : " + ano+" Nota : "+nota + "<br><br>");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });

        writer.write("</body>");
        writer.close();
    }
}
