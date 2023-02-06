package co.com.sofka.navesespaciales.models;
// modelo para crear una copia de la tabla crear nave espacial
public class CopiaCrearNaveEspacial {
    private Integer id;
    private String combustible;
    private double empuje;
    private Integer capacidadTransporte;
    private String nombre;

    private String tipoNave;

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

    public double getEmpuje() {
        return empuje;
    }

    public void setEmpuje(double empuje) {
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

    public String getTipoNave() {
        return tipoNave;
    }

    public void setTipoNave(String tipoNave) {
        this.tipoNave = tipoNave;
    }
}
