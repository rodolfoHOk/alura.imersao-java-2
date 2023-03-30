package br.com.alura.languages.api.api.v1.assembler;

import br.com.alura.languages.api.api.v1.dto.LanguageRegisterRequest;
import br.com.alura.languages.api.domain.model.Language;

public class LanguageRegisterRequestDisassembler {

  public static Language toEntity (LanguageRegisterRequest request) {
    return new Language(request.title(), request.imageUrl(), request.ranking());
  }

}
