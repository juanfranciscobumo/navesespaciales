package co.com.sofka.navesespaciales.controller;

import co.com.sofka.navesespaciales.models.CopiaCrearNaveEspacial;
import co.com.sofka.navesespaciales.models.CrearNaveEspacial;
import co.com.sofka.navesespaciales.models.TipoDeNave;
import co.com.sofka.navesespaciales.repository.CrearNaveEspacialRepository;
import co.com.sofka.navesespaciales.repository.TipoDeNaveRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller // Esto significa que esta clase es un Controlador
@RequestMapping(path = "/nave") // Esto significa que la URL comienza con /nave (después de la ruta de la aplicación)
public class CrearNaveEspacialController {
    @Autowired // Esto significa obtener el bean llamado crearNaveEspacialRepository
    // Que es generado automáticamente por Spring, lo usaremos para manejar los datos
    private CrearNaveEspacialRepository crearNaveEspacialRepository;

    @Autowired
    private TipoDeNaveRepository tipoDeNaveRepository;
    private CopiaCrearNaveEspacial copiaCrearNaveEspacial;

    private Optional<TipoDeNave> tipoDeNaves;
    private CrearNaveEspacial crearNaveEspacial;
    public static String NAVES_NO_TRIPULADAS_O_ROBOTICAS="Naves no tripuladas o roboticas";
    public static String NAVES_TRIPULADAS="Naves tripuladas";
    public static String NAVES_LANZADERA="Naves lanzadera";

    @PostMapping(path = "/add") // servicio crear nave9
    public @ResponseBody String crearNave(@RequestParam String combustible, int empuje, int capacidadTransporte, String nombre) {

        crearNaveEspacial = new CrearNaveEspacial();
        // if para determinar el tipo de nave
        if (navesNoTripuladasORoboticas(combustible, capacidadTransporte)) {
            crearNaveEspacialRepository
                    .save(llenarObjetoCrearNaveEspacial(
                            buscarElIdSegunLaDescripcion(NAVES_NO_TRIPULADAS_O_ROBOTICAS),
                            "Sin combustible", empuje, capacidadTransporte, nombre));

            return "El tipo de nave es " + buscarLaDescripcionPorElId(buscarElIdSegunLaDescripcion(
                    NAVES_NO_TRIPULADAS_O_ROBOTICAS));

        } else if (navesTripuladas(capacidadTransporte)) {
            crearNaveEspacialRepository
                    .save(llenarObjetoCrearNaveEspacial(
                            buscarElIdSegunLaDescripcion(NAVES_TRIPULADAS),
                            combustible, empuje, capacidadTransporte, nombre));

            return "El tipo de nave es " + buscarLaDescripcionPorElId(buscarElIdSegunLaDescripcion(NAVES_TRIPULADAS));

        } else {
            crearNaveEspacialRepository
                    .save(llenarObjetoCrearNaveEspacial(
                            buscarElIdSegunLaDescripcion(NAVES_LANZADERA),
                            combustible, empuje, capacidadTransporte, nombre));

            return "El tipo de nave es " + buscarLaDescripcionPorElId(buscarElIdSegunLaDescripcion(NAVES_LANZADERA));
        }
    }

    @GetMapping(path = "/get") // servicio para mostrar las naves creadas
    public @ResponseBody List<CopiaCrearNaveEspacial> getCrearNave() {
        List<CopiaCrearNaveEspacial> copiaCrearNaveEspacialList = new ArrayList<>();

        crearNaveEspacialRepository.findAll().forEach(a -> {
            copiaCrearNaveEspacialList.add(crearCopiaNaveEspacial(a.getId(),buscarLaDescripcionPorElId(a.getTipoNave()),
                    a.getCombustible(), a.getEmpuje(), a.getCapacidadTransporte(), a.getNombre()));
        });
        return copiaCrearNaveEspacialList;
    }
    // Método buscar la descripción según el id
    public String buscarLaDescripcionPorElId(int id) {
        tipoDeNaves = tipoDeNaveRepository.findById(id);
        return tipoDeNaves.get().getDescripcion();
    }
    // Método buscar el id según la descripción
    public Integer buscarElIdSegunLaDescripcion(String descripcion) {
        List<TipoDeNave> tipoDeNaves = tipoDeNaveRepository.findByDescripcion(descripcion);
        return tipoDeNaves.get(0).getId();
    }
    // Método para determinar si el tipo de nave es de tipo naves no tripuladas o robóticas
    public boolean navesNoTripuladasORoboticas(String combustible, int capacidadTransporte) {
        return (combustible.equals("") && capacidadTransporte == 0) || (combustible.equals(""));
    }
    // Método para revisar si la capacidad de pasajeros es mayor a 0
    public boolean navesTripuladas(int capacidadTransporte) {
        return capacidadTransporte > 0;
    }
    // Método para llenar la tabla crear nave espacial
    public CrearNaveEspacial llenarObjetoCrearNaveEspacial(int tipo, String combustible, int empuje, int capacidadTransporte, String nombre) {
        crearNaveEspacial.setTipoNave(tipo);
        crearNaveEspacial.setCombustible(combustible);
        crearNaveEspacial.setEmpuje(empuje);
        crearNaveEspacial.setCapacidadTransporte(capacidadTransporte);
        crearNaveEspacial.setNombre(nombre);
        return crearNaveEspacial;
    }
    // Método para crear una copia de la tabla crear nave espacial
    public CopiaCrearNaveEspacial crearCopiaNaveEspacial(int id,String tipo, String combustible, int empuje, int capacidadTransporte, String nombre) {
        copiaCrearNaveEspacial = new CopiaCrearNaveEspacial();
        copiaCrearNaveEspacial.setTipoNave(tipo);
        copiaCrearNaveEspacial.setCombustible(combustible);
        copiaCrearNaveEspacial.setNombre(nombre);
        copiaCrearNaveEspacial.setId(id);
        copiaCrearNaveEspacial.setEmpuje(empuje);
        copiaCrearNaveEspacial.setCapacidadTransporte(capacidadTransporte);
        return copiaCrearNaveEspacial;
    }
}

