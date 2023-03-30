import client.API;
import client.ClientHttp;
import extractor.ContentExtractor;
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

    API api = API.LANGUAGES;
//    API api = API.NASA;

    var http = new ClientHttp();
    String json = http.getData(api.getUrl());

    ContentExtractor extractor = api.getExtractor();
    List<Content> contents = extractor.extract(json);
    var stickersGenerator = new StickersGenerator();

    var directory = new File("images/out/");
    directory.mkdir();

    for(Content content : contents) {
      String urlImage = content.imageUrl();
      String title = content.title();

      InputStream inputStream = new URL(urlImage).openStream();
      String stickerText = "Imersão Java";

      System.out.println("\u001b[102;1m \u001b[31;1m" + title + " \u001b[m");
      System.out.println("\u001b[34;3m" + urlImage + "\u001b[m");

      if (content.imDbRating() != null) {
        if (content.imDbRating().length() > 0) {
          for (int i = 0; i < Math.round(Float.parseFloat(content.imDbRating())); i++) {
            System.out.print("\u2B50");
          }
          System.out.println("    " + content.imDbRating());
        }

        InputStream overlapIS;
        if (Double.parseDouble(content.imDbRating()) >= 9.0){
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

      System.out.println();
    }
  }

}
