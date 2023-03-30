package br.com.alura.languages.api.api.v1.assembler;

import br.com.alura.languages.api.api.v1.dto.LanguageResponse;
import br.com.alura.languages.api.domain.model.Language;

import java.util.List;

public class LanguageResponseAssembler {

  public static LanguageResponse toModel (Language language) {
    return new LanguageResponse(language.getId(), language.getName(), language.getImageUrl(),
      String.valueOf(language.getRanking()));
  }

  public static List<LanguageResponse> toCollectionModel (List<Language> languages) {
    return languages.stream().map(LanguageResponseAssembler::toModel).toList();
  }

}
