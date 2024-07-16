package com.forohub_challenge.api.topico;

import com.forohub_challenge.api.controller.DatosCreacionTopico;
import com.forohub_challenge.api.controller.DatosEdicionTopico;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;


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

    @CreationTimestamp
    @Column
    private LocalDateTime fechaCreacion;

    private Boolean activo;

    public Topico(DatosCreacionTopico datosCreacionTopico) {
        this.idUsuario = datosCreacionTopico.idUsuario();
        this.titulo = datosCreacionTopico.titulo();
        this.curso = datosCreacionTopico.curso();
        this.mensaje = datosCreacionTopico.mensaje();
        this.activo = true;
    }

    public void actualizarTopico(DatosEdicionTopico datosEdicionTopico){
        if (datosEdicionTopico.titulo() != null){
            this.titulo = datosEdicionTopico.titulo();
        }
        if (datosEdicionTopico.curso() != null){
            this.curso = datosEdicionTopico.curso();
        }
        if (datosEdicionTopico.mensaje() != null){
            this.mensaje = datosEdicionTopico.mensaje();
        }
    }

    public void desactivarTopico() {
        this.activo = false;
    }
}


