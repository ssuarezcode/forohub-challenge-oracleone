package com.forohub_challenge.api.controller;

import com.forohub_challenge.api.topico.Topico;

import java.time.LocalDateTime;

public record DatosListadoTopicos(Long id,
                                  String titulo,
                                  LocalDateTime fechaCreacion) {

    public DatosListadoTopicos (Topico topico){
        this(topico.getId(), topico.getTitulo(), topico.getFechaCreacion());
    }
}
