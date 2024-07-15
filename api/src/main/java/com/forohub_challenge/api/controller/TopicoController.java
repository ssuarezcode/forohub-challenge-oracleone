package com.forohub_challenge.api.controller;

import com.forohub_challenge.api.topico.Topico;
import com.forohub_challenge.api.topico.TopicoRepository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/topicos")

public class TopicoController {

    @Autowired
    private TopicoRepository topicoRepository;

    @PostMapping
    public void crearTopicos(@RequestBody @Valid DatosCreacionTopico datosCrecionTopico){
        topicoRepository.save(new Topico(datosCrecionTopico));
    }
}
