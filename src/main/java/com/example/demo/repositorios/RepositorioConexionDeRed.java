
package com.example.demo.repositorios;

import com.example.demo.entidades.ConexionDeRed;
import com.example.demo.repositorios.crud.InterfaceConexionDeRed;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Oscar Gomez
 */
@Repository
public class RepositorioConexionDeRed {
    /**
     * Instancia de InterfaceConexionDeRed
     */
    @Autowired
    private InterfaceConexionDeRed crud;
    /**
     * Obtener todos los registros
     * @return Una lista con todos los registros
     */
    public List<ConexionDeRed> getAll() {
        return (List<ConexionDeRed>) crud.findAll();
    }
    /**
     * Obtener un registro por id
     * @param tipo
     * @return Un registro
     */
    public Optional<ConexionDeRed> getConexion(int tipo) {
        return crud.findById(tipo);
    }
    /**
     * Registrar una conexion
     * @param cdr
     * @return El registro guardado
     */
    public ConexionDeRed save(ConexionDeRed cdr) {
        return crud.save(cdr);
    }
    /**
     * Eliminar un registro
     * @param cdr 
     */
    public void delete(ConexionDeRed cdr) {
        crud.delete(cdr);
    }
}
