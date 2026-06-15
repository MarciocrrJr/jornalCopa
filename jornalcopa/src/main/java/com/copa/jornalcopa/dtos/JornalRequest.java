package com.copa.jornalcopa.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.time.LocalDate;

public record JornalRequest(
    
    @NotBlank(message = "O título é obrigatório")
    @Size(max = 255, message = "O título deve ter no máximo 255 caracteres")
    String titulo,

    @NotBlank(message = "O conteúdo é obrigatório")
    @Size(max = 1000, message = "O conteúdo deve ter no máximo 1000 caracteres")
    String conteudo,

    @NotBlank(message = "O autor é obrigatório")
    @Size(max = 255, message = "O autor deve ter no máximo 255 caracteres")
    String autor,

    @NotNull(message = "A data é obrigatória")
    LocalDate data,

    @Size(max = 255, message = "O subtítulo deve ter no máximo 255 caracteres")
    String subtitulo
) {
}