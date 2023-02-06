package co.com.sofka.navesespaciales.controller;

import co.com.sofka.navesespaciales.models.TipoDeNave;
import co.com.sofka.navesespaciales.repository.TipoDeNaveRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller // Esto significa que esta clase es un Controlador
@RequestMapping(path = "/tipos") // Esto significa que la URL comienza con /tipos (después de la ruta de la aplicación)
public class TipoDeNaveController {
    @Autowired //Esto significa obtener el bean llamado TipoDeNaveRepository
    // Que es generado automáticamente por Spring, lo usaremos para manejar los datos
    private TipoDeNaveRepository tipoDeNaveRepository;

    @GetMapping(path = "/get") // servicio para retornar los tipos de nave
    public @ResponseBody Iterable<TipoDeNave> getTipoDeNave() {

        return tipoDeNaveRepository.findAll();
    }
}
