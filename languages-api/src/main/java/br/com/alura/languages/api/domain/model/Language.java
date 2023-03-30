package br.com.alura.languages.api.domain.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "principaisLinguagens")
public class Language {

  @Id
  private String id;
  private String name;
  private String imageUrl;
  private int ranking;

  public Language() {
  }

  public Language(String title, String imageUrl, int ranking) {
    this.name = title;
    this.imageUrl = imageUrl;
    this.ranking = ranking;
  }

  public String getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public String getImageUrl() {
    return imageUrl;
  }

  public int getRanking() {
    return ranking;
  }

  public void setId(String id) {
    this.id = id;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setImageUrl(String imageUrl) {
    this.imageUrl = imageUrl;
  }

  public void setRanking(int ranking) {
    this.ranking = ranking;
  }

}
