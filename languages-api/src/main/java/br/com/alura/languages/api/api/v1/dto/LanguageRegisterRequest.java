package br.com.alura.languages.api.api.v1.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record LanguageRegisterRequest (
  @NotBlank String title,
  @NotBlank String imageUrl,
  @NotNull @Positive int ranking
) {
}
