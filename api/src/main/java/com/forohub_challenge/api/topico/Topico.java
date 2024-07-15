package com.forohub_challenge.api.topico;

import com.forohub_challenge.api.controller.DatosCreacionTopico;
import jakarta.persistence.*;
import lombok.*;


@Table(name = "topicos")
@Entity(name = "Topico")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")

public class Topico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String idUsuario;
    private String titulo;
    private String curso;
    private String mensaje;

    public Topico(DatosCreacionTopico datosCreacionTopico) {
        this.idUsuario = datosCreacionTopico.idUsuario();
        this.titulo = datosCreacionTopico.titulo();
        this.curso = datosCreacionTopico.curso();
        this.mensaje = datosCreacionTopico.mensaje();
    }
}


