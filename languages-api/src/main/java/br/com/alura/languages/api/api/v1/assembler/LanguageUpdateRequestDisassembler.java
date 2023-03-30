package br.com.alura.languages.api.api.v1.assembler;

import br.com.alura.languages.api.api.v1.dto.LanguageUpdateRequest;
import br.com.alura.languages.api.domain.model.Language;

public class LanguageUpdateRequestDisassembler {

  public static Language toEntity (LanguageUpdateRequest request) {
    return new Language(request.title(), request.imageUrl(), request.ranking());
  }

}
