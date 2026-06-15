package com.copa.jornalcopa.dtos;

import java.time.LocalDate;

public record JornalResponse (
    long id, 
    String titulo, 
    String subtitulo, 
    String conteudo,
    String autor, 
    LocalDate data
) {
}