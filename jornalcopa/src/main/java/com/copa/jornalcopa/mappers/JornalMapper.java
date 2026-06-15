package com.copa.jornalcopa.mappers;

import com.copa.jornalcopa.dtos.JornalResponse;
import com.copa.jornalcopa.entities.Jornal;

public class JornalMapper {
    public static JornalResponse toDTO(Jornal jornal) {
        return new JornalResponse(
            jornal.getId(),
            jornal.getTitulo(),
            jornal.getSubtitulo(),
            jornal.getTexto(),
            jornal.getAutor(),
            jornal.getData()
        );
    }
}
