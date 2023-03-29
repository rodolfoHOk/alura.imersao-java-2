package extractor;

import model.Content;

import java.util.List;

public interface ContentExtractor {

  List<Content> extract(String json);

}
