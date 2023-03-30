package br.com.alura.languages.api.domain.service;

import br.com.alura.languages.api.domain.exception.ResourceNotFoundException;
import br.com.alura.languages.api.domain.exception.ValidationException;
import br.com.alura.languages.api.domain.model.Language;
import br.com.alura.languages.api.domain.repository.LanguageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class LanguageService {

  private LanguageRepository languageRepository;

  public LanguageService(@Autowired LanguageRepository languageRepository) {
    this.languageRepository = languageRepository;
  }

  public Language getById(String id) {
    return languageRepository.findById(id)
      .orElseThrow(() -> new ResourceNotFoundException("Language not found with informed ID"));
  }

  @Transactional
  public Language register(Language newLanguage) {
    return languageRepository.save(newLanguage);
  }

  @Transactional
  public Language update(String id, Language languageToUpdate) {
    try {
      Language existsLanguage = getById(id);
      existsLanguage.setName(languageToUpdate.getName());
      existsLanguage.setImageUrl(languageToUpdate.getImageUrl());
      existsLanguage.setRanking(languageToUpdate.getRanking());
      return languageRepository.save(existsLanguage);

    } catch (ResourceNotFoundException ex) {
      throw new ValidationException(ex.getMessage());
    }
  }

  @Transactional
  public void deleteById(String id) {
    try {
      Language existsLanguage = getById(id);
      languageRepository.delete(existsLanguage);

    } catch (ResourceNotFoundException | DataIntegrityViolationException ex) {
      throw new ValidationException(ex.getMessage());
    }
  }

}
