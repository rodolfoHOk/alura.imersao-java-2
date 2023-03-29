package extractor;

import model.Content;
import utils.JsonParser;

import java.util.List;
import java.util.Map;

public class NasaContentExtractor implements ContentExtractor {

  public List<Content> extract(String json) {
    var parser = new JsonParser();
    List<Map<String, String>> attributesList = parser.parse(json);

    return attributesList.stream()
      .map(attribute -> new Content(attribute.get("title"), attribute.get("url")))
      .toList();
  }

}
