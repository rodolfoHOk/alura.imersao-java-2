import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;
import java.util.Map;

public class App {

  public static void main(String[] args) throws IOException, InterruptedException {

    // fazer uma conexão com HTTP e buscar os top filmes
    String url = "https://raw.githubusercontent.com/alura-cursos/imersao-java-2-api/main/TopMovies.json";
    var uri = URI.create(url);
    var client = HttpClient.newHttpClient();
    var request = HttpRequest.newBuilder(uri).GET().build();
    HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
    String body = response.body();

    // extrair só os dados que interessam (titulo, poster, classificação)
    var parser = new JsonParser();
    List<Map<String, String>> filmList = parser.parse(body);

    // exibir e manipular os dados
    var stickersGenerator = new StickersGenerator();

    for(Map<String, String> film : filmList) {
      String urlImage = film.get("image");
      String title = film.get("title");

      System.out.println(title);
      System.out.println(urlImage);
      System.out.println(film.get("imDbRating"));
      System.out.println();

      InputStream inputStream = new URL(urlImage).openStream();
      stickersGenerator.create(inputStream, title);
    }
  }

}
