package br.com.alura.languages.api.domain.repository;

import br.com.alura.languages.api.domain.model.Language;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface LanguageRepository extends MongoRepository<Language, String> {

  List<Language> findAllByOrderByRankingAsc();

}
