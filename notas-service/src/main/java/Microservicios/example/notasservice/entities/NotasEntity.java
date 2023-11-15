package Microservicios.example.notasservice.entities;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "notas")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class NotasEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id;

    private String rut;
    private String fecha_examen;
    private String puntaje;
}