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
    @PostMapping(path = "/add") // servicio crear nave
    public @ResponseBody String crearNave(@RequestParam String combustible, double empuje, int capacidadTransporte, String nombre) {

        CrearNaveEspacial crearNaveEspacial = new CrearNaveEspacial();
        crearNaveEspacialRepository.save(crearNaveEspacial);
        // if para determinar el tipo de nave
        if ((combustible.equals("") && capacidadTransporte == 0) || (combustible.equals(""))) {
            List<TipoDeNave> tipoDeNaves = tipoDeNaveRepository.findByDescripcion("Naves no tripuladas o roboticas");
            crearNaveEspacial.setTipoNave(tipoDeNaves.get(0).getId());
            crearNaveEspacial.setCombustible("Sin combustible");
            crearNaveEspacial.setEmpuje(empuje);
            crearNaveEspacial.setCapacidadTransporte(capacidadTransporte);
            crearNaveEspacial.setNombre(nombre);
            crearNaveEspacialRepository.save(crearNaveEspacial);
            return "El tipo de nave es "+tipoDeNaves.get(0).getDescripcion();
        } else if (capacidadTransporte > 0) {
            List<TipoDeNave> tipoDeNaves = tipoDeNaveRepository.findByDescripcion("Naves tripuladas");
            crearNaveEspacial.setTipoNave(tipoDeNaves.get(0).getId());
            crearNaveEspacial.setCombustible(combustible);
            crearNaveEspacial.setEmpuje(empuje);
            crearNaveEspacial.setCapacidadTransporte(capacidadTransporte);
            crearNaveEspacial.setNombre(nombre);
            crearNaveEspacialRepository.save(crearNaveEspacial);
            return "El tipo de nave es "+tipoDeNaves.get(0).getDescripcion();
        } else {
            List<TipoDeNave> tipoDeNaves = tipoDeNaveRepository.findByDescripcion("Naves lanzadera");
            crearNaveEspacial.setTipoNave(tipoDeNaves.get(0).getId());
            crearNaveEspacial.setCombustible(combustible);
            crearNaveEspacial.setEmpuje(empuje);
            crearNaveEspacial.setCapacidadTransporte(capacidadTransporte);
            crearNaveEspacial.setNombre(nombre);
            crearNaveEspacialRepository.save(crearNaveEspacial);
            return "El tipo de nave es "+tipoDeNaves.get(0).getDescripcion();
        }
    }

    @GetMapping(path = "/get") // servicio para mostrar las naves creadas
    public @ResponseBody List<CopiaCrearNaveEspacial> getCrearNave() {
         List<CopiaCrearNaveEspacial> copiaCrearNaveEspacialList = new ArrayList<>();

        crearNaveEspacialRepository.findAll().forEach(a-> {
            copiaCrearNaveEspacial = new CopiaCrearNaveEspacial();
            tipoDeNaves = tipoDeNaveRepository.findById(a.getTipoNave());
            copiaCrearNaveEspacial.setTipoNave(tipoDeNaves.get().getDescripcion());
            copiaCrearNaveEspacial.setCombustible(a.getCombustible());
            copiaCrearNaveEspacial.setNombre(a.getNombre());
            copiaCrearNaveEspacial.setId(a.getId());
            copiaCrearNaveEspacial.setCapacidadTransporte(a.getCapacidadTransporte());
            copiaCrearNaveEspacialList.add(copiaCrearNaveEspacial);
        } );
        return copiaCrearNaveEspacialList;
    }
}
