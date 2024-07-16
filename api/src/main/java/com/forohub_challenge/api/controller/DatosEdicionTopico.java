package com.forohub_challenge.api.controller;

import jakarta.validation.constraints.NotNull;

public record DatosEdicionTopico(@NotNull Long id,
                                 String titulo,
                                 String curso,
                                 String mensaje) {
}
