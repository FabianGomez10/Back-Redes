
package com.example.demo.repositorios;

import com.example.demo.entidades.DispositivoElectrónico;
import com.example.demo.repositorios.crud.InterfaceDispositivoElectronico;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Oscar Gomez
 */
@Repository
public class RepositorioDispositivoElectronico {
    /**
     * Instancia de InterfaceDispositivoElectronico
     */
    @Autowired
    private InterfaceDispositivoElectronico crud;
    /**
     * Obtener todos los registros
     * @return Una lista con todos los registros
     */
    public List<DispositivoElectrónico> getAll() {
        return (List<DispositivoElectrónico>) crud.findAll();
    }
    /**
     * Obtener un registro por mac
     * @param mac
     * @return Un registro
     */
    public Optional<DispositivoElectrónico> getDispositivo(String mac) {
        return crud.findByMac(mac);
    }
    /**
     * Registrar un dispositivo
     * @param electrónico
     * @return El registro guardado
     */
    public DispositivoElectrónico save(DispositivoElectrónico electrónico) {
        return crud.save(electrónico);
    }
    /**
     * Eliminar un registro
     * @param mac
     */
    public void delete(String mac) {
        crud.deleteById(mac);
    }
    /**
     * Buscar por llave foranea
     * @param id
     * @return 
     */
    public List<DispositivoElectrónico> filtroConexion(Integer id){
        return crud.findByConexionActual_Tipo(id);
    }
}
