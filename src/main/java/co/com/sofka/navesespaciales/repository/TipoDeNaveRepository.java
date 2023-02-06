package co.com.sofka.navesespaciales.repository;

import co.com.sofka.navesespaciales.models.TipoDeNave;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TipoDeNaveRepository extends CrudRepository<TipoDeNave, Integer> {
    // metodo para filtrar por el campo de descripcion
    List<TipoDeNave> findByDescripcion(String descripcion);

}
