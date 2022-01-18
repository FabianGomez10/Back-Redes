
package com.example.demo.controladores;

import com.example.demo.entidades.ConexionDeRed;
import com.example.demo.servicios.ServicioConexionDeRed;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Oscar Gomez
 */
@RestController
@RequestMapping("/conexiondered")
@CrossOrigin(origins = "*")
public class ControladorConexionDeRed {
    /**
     * Instancia de ServicioConexionDeRed
     */
    @Autowired
    private ServicioConexionDeRed servicio;
    /**
     * Obtener todos los registros
     * @return Una lista con todos los registros
     */
    @GetMapping("/all")
    public List<ConexionDeRed> getAll(){
        return servicio.getAll();
    }
    /**
     * Obtener un registro por tipo
     * @param tipo
     * @return Un registro
     */
    @GetMapping("/{tipo}")
    public Optional<ConexionDeRed> getConexion(@PathVariable int tipo){
        return servicio.getConexion(tipo);
    }
    /**
     * Registrar una conexion
     * @param cdr
     * @return El registro guardado
     */
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public ConexionDeRed save(@RequestBody ConexionDeRed cdr){
        return servicio.save(cdr);
    }
    /**
     * Actualizar un registro
     * @param cdr
     * @return El registro
     */
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public ConexionDeRed update(@RequestBody ConexionDeRed cdr){
        return servicio.update(cdr);
    }
    /**
     * Eliminar un registro
     * @param tipo
     * @return Un booleano
     */
    @DeleteMapping("/{tipo}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable int tipo){
       return servicio.delete(tipo);
    }
}
