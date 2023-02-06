package co.com.sofka.navesespaciales.models;



import javax.persistence.*;

@Entity // Esto le dice a Hibernate que haga una tabla con esta clase
public class CrearNaveEspacial {
    @Id // crea este campo como el id de la tabla

    @GeneratedValue(strategy= GenerationType.AUTO) // crea un elemento auntoincremental
    private Integer id;
    private String combustible;
    private Integer empuje;
    private Integer capacidadTransporte;
    private String nombre;
    private Integer tipoNave;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCombustible() {
        return combustible;
    }

    public void setCombustible(String combustible) {
        this.combustible = combustible;
    }

    public Integer getEmpuje() {
        return empuje;
    }

    public void setEmpuje(Integer empuje) {
        this.empuje = empuje;
    }

    public Integer getCapacidadTransporte() {
        return capacidadTransporte;
    }

    public void setCapacidadTransporte(Integer capacidadTransporte) {
        this.capacidadTransporte = capacidadTransporte;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getTipoNave() {
        return tipoNave;
    }

    public void setTipoNave(Integer tipoNave) {
        this.tipoNave = tipoNave;
    }
}
