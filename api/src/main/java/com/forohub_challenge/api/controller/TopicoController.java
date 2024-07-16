package com.forohub_challenge.api.controller;

import com.forohub_challenge.api.topico.Topico;
import com.forohub_challenge.api.topico.TopicoRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
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

    @GetMapping
    public Page<DatosListadoTopicos> listarTopicos(@PageableDefault(size=5) Pageable paginacion){
        return topicoRepository.findByActivoTrue(paginacion).map(DatosListadoTopicos::new);
    }

    @PutMapping
    @Transactional
    public void editarTopico(@RequestBody @Valid DatosEdicionTopico datosEdicionTopico){
        Topico topico = topicoRepository.getReferenceById(datosEdicionTopico.id());
        topico.actualizarTopico(datosEdicionTopico);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public void eliminarTopico(@PathVariable Long id){
        Topico topico = topicoRepository.getReferenceById(id);
        topico.desactivarTopico();
    }
}
