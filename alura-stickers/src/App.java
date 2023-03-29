import client.ClientHttp;
import extractor.ContentExtractor;
import extractor.ImdbContentExtractor;
import extractor.NasaContentExtractor;
import model.Content;
import utils.StickersGenerator;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.List;

public class App {

  public static void main(String[] args) throws IOException, InterruptedException {

    // IMDB
    // no terminal: export IMDB_KEY=k_????????
//    String imdbAPIKey = System.getenv("IMDB_KEY");
//    String url = "https://imdb-api.com/en/API/Top250Movies/" + imdbAPIKey;
//    String url = "https://imdb-api.com/en/API/MostPopularMovies/" + imdbAPIKey;
//    String url = "https://raw.githubusercontent.com/alura-cursos/imersao-java-2-api/main/TopMovies.json";
//    ContentExtractor extractor = new ImdbContentExtractor();

    // NASA
    String url = "https://api.nasa.gov/planetary/apod?api_key=DEMO_KEY&start_date=2022-06-12&end_date=2022-06-14";
    ContentExtractor extractor = new NasaContentExtractor();

    var http = new ClientHttp();
    String json = http.getData(url);

    List<Content> contents = extractor.extract(json);
    var stickersGenerator = new StickersGenerator();

    var diretorio = new File("images/out/");
    diretorio.mkdir();

    for(Content content : contents) {
      String urlImage = content.getImageUrl();
      String title = content.getTitle();

      System.out.println("\u001b[102;1m \u001b[31;1m" + title + " \u001b[m");
      System.out.println("\u001b[34;3m" + urlImage + "\u001b[m");
      if (content.getImDbRating() != null && content.getImDbRating().length() > 0) {
        for(int i = 0; i < Math.round(Float.parseFloat(content.getImDbRating())); i ++) {
          System.out.print("\u2B50");
        }
        System.out.println("    " + content.getImDbRating());
      }
      System.out.println();

      InputStream inputStream = new URL(urlImage).openStream();
      String stickerText = "Imersão Java";

      if (content.getImDbRating() != null) {
        InputStream overlapIS;
        if (Double.parseDouble(content.getImDbRating()) >= 9.0){
          stickerText = "TOPZERA";
          overlapIS = new FileInputStream(new File("images/in/empolgado.jpg"));
        } else {
          stickerText = "HUMMM...";
          overlapIS = new FileInputStream(new File("images/in/desconfiado.png"));
        }
        stickersGenerator.create(inputStream, title, stickerText, overlapIS);

      } else {
        stickersGenerator.create(inputStream, title, stickerText);
      }
    }
  }

}
