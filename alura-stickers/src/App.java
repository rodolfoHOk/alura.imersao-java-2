import client.ClientHttp;
import extractor.ContentExtractor;
import extractor.ImdbContentExtractor;
import extractor.NasaContentExtractor;
import model.Content;
import utils.StickersGenerator;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.List;

public class App {

  public static void main(String[] args) throws IOException, InterruptedException {

    // IMDB
    String url = "https://raw.githubusercontent.com/alura-cursos/imersao-java-2-api/main/TopMovies.json";
    ContentExtractor extractor = new ImdbContentExtractor();

    // NASA
//    String url = "https://api.nasa.gov/planetary/apod?api_key=DEMO_KEY&start_date=2022-06-12&end_date=2022-06-14";
//    ContentExtractor extractor = new NasaContentExtractor();

    var http = new ClientHttp();
    String json = http.getData(url);

    List<Content> contents = extractor.extract(json);
    var stickersGenerator = new StickersGenerator();

    for(Content content : contents) {
      String urlImage = content.getImageUrl();
      String title = content.getTitle();

      System.out.println(title);
      System.out.println(urlImage);
      System.out.println();

      InputStream inputStream = new URL(urlImage).openStream();
      stickersGenerator.create(inputStream, title);
    }
  }

}
