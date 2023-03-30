package br.com.alura.languages.api.api.v1.controller;

import br.com.alura.languages.api.api.v1.assembler.LanguageRegisterRequestDisassembler;
import br.com.alura.languages.api.api.v1.assembler.LanguageResponseAssembler;
import br.com.alura.languages.api.api.v1.assembler.LanguageUpdateRequestDisassembler;
import br.com.alura.languages.api.api.v1.dto.LanguageRegisterRequest;
import br.com.alura.languages.api.api.v1.dto.LanguageResponse;
import br.com.alura.languages.api.api.v1.dto.LanguageUpdateRequest;
import br.com.alura.languages.api.domain.model.Language;
import br.com.alura.languages.api.domain.repository.LanguageRepository;
import br.com.alura.languages.api.domain.service.LanguageService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class LanguagesController {

  private LanguageRepository languageRepository;
  private LanguageService languageService;

  public LanguagesController(
    @Autowired LanguageRepository languageRepository,
    @Autowired LanguageService languageService
  ) {
    this.languageRepository = languageRepository;
    this.languageService = languageService;
  }

  @GetMapping("/preferred-languages")
  public String getPreferredLanguage() {
    return "Java";
  }

  @GetMapping("/languages")
  public List<LanguageResponse> listLanguages() {
    List<Language> languages = languageRepository.findAllByOrderByRankingAsc();
    return LanguageResponseAssembler.toCollectionModel(languages);
  }

  @PostMapping("/languages")
  @ResponseStatus(HttpStatus.CREATED)
  public LanguageResponse registerLanguage(@RequestBody @Valid LanguageRegisterRequest languageRegisterRequest) {
    Language newLanguage = LanguageRegisterRequestDisassembler.toEntity(languageRegisterRequest);
    Language registeredLanguage = languageService.register(newLanguage);

    return LanguageResponseAssembler.toModel(registeredLanguage);
  }

  @GetMapping("/languages/{id}")
  public LanguageResponse getLanguageById(@PathVariable String id) {
    Language language = languageService.getById(id);

    return LanguageResponseAssembler.toModel(language);
  }

  @PutMapping("/languages/{id}")
  public LanguageResponse updateLanguage(
    @PathVariable String id,
    @RequestBody @Valid LanguageUpdateRequest languageUpdateRequest
  ){
    Language languageToUpdate = LanguageUpdateRequestDisassembler.toEntity(languageUpdateRequest);
    Language updatedLanguage = languageService.update(id, languageToUpdate);

    return LanguageResponseAssembler.toModel(updatedLanguage);
  }

  @DeleteMapping("/languages/{id}")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public void deleteLanguage(@PathVariable String id) {
    languageService.deleteById(id);
  }

}
