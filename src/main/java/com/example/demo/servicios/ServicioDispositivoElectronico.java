package com.example.demo.servicios;

import com.example.demo.entidades.DispositivoElectrónico;
import com.example.demo.repositorios.RepositorioDispositivoElectronico;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Oscar Gomez
 */
@Service
public class ServicioDispositivoElectronico {

    /**
     * Instancia de RepositorioDispositivoElectronico
     */
    @Autowired
    private RepositorioDispositivoElectronico repositorio;

    /**
     * Obtener todos los registros
     * @return Una lista con todos los registros
     */
    public List<DispositivoElectrónico> getAll() {
        return repositorio.getAll();
    }

    /**
     * Obtener un registro por mac
     * @param mac
     * @return Un registro
     */
    public Optional<DispositivoElectrónico> getDispositivo(String mac) {
        return repositorio.getDispositivo(mac);
    }

    /**
     * Registrar un dispositivo
     * @param electrónico
     * @return El registro guardado
     */
    public Optional<DispositivoElectrónico> save(DispositivoElectrónico electrónico) {

        if (electrónico.getMac() == null || electrónico.getTipo() == null || electrónico.getIpAsignada() == null || electrónico.getConexionActual() == null) {
            // Se retorna null para saber que no se registro
            return Optional.empty();
        } else {
            Optional<DispositivoElectrónico> buscarD = repositorio.getDispositivo(electrónico.getMac());
            if (buscarD.isEmpty()) {
                int maximoDeRegistros = 0;
                List<DispositivoElectrónico> buscarIdConexion = repositorio.filtroConexion(electrónico.getConexionActual().getTipo());
                //System.out.println(buscarIdConexion.toString());
                for (DispositivoElectrónico deo : buscarIdConexion) {
                    if (deo.getConexionActual().getTipo().equals(electrónico.getConexionActual().getTipo())) {
                            maximoDeRegistros++;
                    }
                }
                if (maximoDeRegistros < 3) {
                    // Se retorna el objeto para saber que se registro
                    return Optional.of(repositorio.save(electrónico));
                } else {
                    // Se retorna null para saber que no se registro
                    return Optional.empty();
                }  
            }
            else {
                // Se retorna null para saber que no se registro
                return Optional.empty();
            }
        }
    }

    /**
     * Actualizar un registro
     * @param electrónico
     * @return El registro
     */
    public Optional<DispositivoElectrónico> update(DispositivoElectrónico electrónico) {
        if (electrónico.getMac() != null) {
            Optional<DispositivoElectrónico> obtener = repositorio.getDispositivo(electrónico.getMac());
            //System.out.println(obtener.toString());
            if (obtener.isPresent()) {
                if (electrónico.getTipo() != null) {
                    obtener.get().setTipo(electrónico.getTipo());
                }
                if (electrónico.getConectadoActualmente() != null) {
                    obtener.get().setConectadoActualmente(electrónico.getConectadoActualmente());
                }
                if (electrónico.getConexionActual() != null) {
                    int maximoDeRegistros = 0;
                    List<DispositivoElectrónico> buscarIdConexion = repositorio.filtroConexion(electrónico.getConexionActual().getTipo());
                    for (DispositivoElectrónico deo : buscarIdConexion) {
                        if (deo.getConexionActual().getTipo().equals(electrónico.getConexionActual().getTipo())) {
                            maximoDeRegistros++;
                        }
                    }
                    if (maximoDeRegistros < 3) {
                        obtener.get().setConexionActual(electrónico.getConexionActual());
                    }
                    
                }
                if (electrónico.getIpAsignada() != null) {
                    obtener.get().setIpAsignada(electrónico.getIpAsignada());
                }
                repositorio.save(obtener.get());
                // Se retorna el objeto para saber que se actualizo
                return Optional.of(electrónico);
            } else {
                return Optional.empty();
            }
        } else {
            // Se retorna null para saber que no se actualizo
            return Optional.empty();
        }
    }

    /**
     * Eliminar un registro
     * @param mac
     * @return Un booleano
     */
    public boolean delete(String mac) {
        Optional<DispositivoElectrónico> obtener = getDispositivo(mac);
        if (obtener.isPresent()) {
            repositorio.delete(mac);
            return true;
        }
        return false;
    }
}
