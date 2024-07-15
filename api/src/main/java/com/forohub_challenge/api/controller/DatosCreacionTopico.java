package com.forohub_challenge.api.controller;

import jakarta.validation.constraints.NotBlank;


public record DatosCreacionTopico(
        @NotBlank
        String idUsuario,

        @NotBlank
        String titulo,

        @NotBlank
        String curso,

        @NotBlank
        String mensaje) {
}
