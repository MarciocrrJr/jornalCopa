package com.copa.jornalcopa.mappers;

import com.copa.jornalcopa.dtos.JornalRequest;
import com.copa.jornalcopa.dtos.JornalResponse;
import com.copa.jornalcopa.entities.Jornal;

public class JornalMapper {

    public static JornalResponse toDTO(Jornal jornal) {
        return new JornalResponse(
            jornal.getId(),
            jornal.getTitulo(),
            jornal.getSubtitulo(),
            jornal.getConteudo(),
            jornal.getAutor(),
            jornal.getData()
        );
    }

    public static Jornal toEntity(JornalRequest request) {
        Jornal jornal = new Jornal();
        jornal.setTitulo(request.titulo());
        jornal.setSubtitulo(request.subtitulo());
        jornal.setConteudo(request.conteudo());
        jornal.setAutor(request.autor());
        jornal.setData(request.data());
        return jornal;
    }
}