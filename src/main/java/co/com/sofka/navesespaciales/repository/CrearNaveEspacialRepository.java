package co.com.sofka.navesespaciales.repository;

import co.com.sofka.navesespaciales.models.CrearNaveEspacial;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CrearNaveEspacialRepository extends CrudRepository<CrearNaveEspacial, Integer> {
    // metodo para filtrar por el campo tipo de nave
    List<CrearNaveEspacial> findByTipoNave(Integer tipoNave);

}
