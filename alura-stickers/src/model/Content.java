package model;

public record Content(String title, String imageUrl, String imDbRating) {

  public Content(String title, String imageUrl) {
    this(title, imageUrl, null);
  }

}
