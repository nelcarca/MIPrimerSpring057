package cl.awakelab.miprimerspring.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AlumnoDto {
    private int id;
    private String nombres;
    private String apellido1;
    private String apellido2;
    private String nombreCurso;
}
