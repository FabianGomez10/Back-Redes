package com.example.demo.servicios;

import com.example.demo.entidades.ConexionDeRed;
import com.example.demo.repositorios.RepositorioConexionDeRed;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Oscar Gomez
 */
@Service
public class ServicioConexionDeRed {
    /**
     * Instancia de RepositorioConexionDeRed
     */
    @Autowired
    private RepositorioConexionDeRed repositorio;
    /**
     * Obtener todos los registros
     * @return Una lista con todos los registros
     */
    public List<ConexionDeRed> getAll() {
        return repositorio.getAll();
    }
    /**
     * Obtener un registro por id
     * @param tipo
     * @return Un registro
     */
    public Optional<ConexionDeRed> getConexion(int tipo) {
        return repositorio.getConexion(tipo);
    }
    /**
     * Registrar una conexion
     * @param cdr
     * @return El registro guardado
     */
    public ConexionDeRed save(ConexionDeRed cdr) {
        if (cdr.getTipo() == null) {
            if (cdr.getNombre() == null || cdr.getTipoDeCifrado() == null || cdr.getUsuarioConexión() == null || cdr.getContraseñaDeConexión() == null) {
                return cdr;
            } else {
                return repositorio.save(cdr);
            }
        } else {
            Optional<ConexionDeRed> buscarC = repositorio.getConexion(cdr.getTipo());
            if (buscarC.isEmpty()) {
                if (cdr.getNombre() == null || cdr.getTipoDeCifrado() == null || cdr.getUsuarioConexión() == null || cdr.getContraseñaDeConexión() == null) {
                    return cdr;
                } else {
                    return repositorio.save(cdr);
                }
            } else {
                return cdr;
            }
        }

    }
    /**
     * Actualizar un registro
     * @param cdr
     * @return El registro
     */
    public ConexionDeRed update(ConexionDeRed cdr) {
        if (cdr.getTipo()!= null) {
            Optional<ConexionDeRed> obtener = repositorio.getConexion(cdr.getTipo());
            if (obtener.isPresent()) {
                if (cdr.getNombre()!= null) {
                    obtener.get().setNombre(cdr.getNombre());
                }
                if (cdr.getTipoDeCifrado()!= null) {
                    obtener.get().setTipoDeCifrado(cdr.getTipoDeCifrado());
                }
                if (cdr.getUsuarioConexión()!= null) {
                    obtener.get().setUsuarioConexión(cdr.getUsuarioConexión());
                }
                if (cdr.getContraseñaDeConexión()!= null) {
                    obtener.get().setContraseñaDeConexión(cdr.getContraseñaDeConexión());
                }
                return repositorio.save(obtener.get());
            } else {
                return cdr;
            }
        } else {
            return cdr;
        }
    }
    /**
     * Eliminar un registro
     * @param tipo
     */
    public boolean delete(int tipo) {
        Optional<ConexionDeRed> obtener = getConexion(tipo);
        if (obtener.isPresent()) {
            repositorio.delete(obtener.get());
            return true;
        }
        return false;
    }
}
