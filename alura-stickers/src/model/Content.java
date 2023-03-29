package model;

public class Content {

  private final String title;
  private final String imageUrl;
  private String imDbRating;

  public Content (String title, String imageUrl) {
    this.title = title;
    this.imageUrl = imageUrl;
  }

  public Content(String title, String imageUrl, String imDbRating) {
    this.title = title;
    this.imageUrl = imageUrl;
    this.imDbRating = imDbRating;
  }

  public String getTitle() {
    return title;
  }

  public String getImageUrl() {
    return imageUrl;
  }

  public String getImDbRating() {
    return imDbRating;
  }

}
