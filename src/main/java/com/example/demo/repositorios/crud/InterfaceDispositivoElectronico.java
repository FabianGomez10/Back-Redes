
package com.example.demo.repositorios.crud;

import com.example.demo.entidades.ConexionDeRed;
import com.example.demo.entidades.DispositivoElectrónico;
import java.util.List;
import java.util.Optional;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author Oscar Gomez
 */
public interface InterfaceDispositivoElectronico extends CrudRepository<DispositivoElectrónico, String>{
    /**
     * Buscar por mac
     * @param mac
     * @return un registro
     */
    Optional<DispositivoElectrónico> findByMac(String mac);
    
}
