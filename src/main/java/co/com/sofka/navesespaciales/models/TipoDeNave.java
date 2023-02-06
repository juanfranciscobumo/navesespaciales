package co.com.sofka.navesespaciales.models;

import javax.persistence.*;

@Entity // Esto le dice a Hibernate que haga una tabla con esta clase
@Table(name = "tipodenave")
public class TipoDeNave {
    @Id // crea este campo como el id de la tabla
    @GeneratedValue(strategy= GenerationType.AUTO) // crea un elemento auntoincremental
    private Integer id;
    private String descripcion;
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
