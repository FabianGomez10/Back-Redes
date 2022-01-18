
package com.example.demo.controladores;

import com.example.demo.entidades.DispositivoElectrónico;
import com.example.demo.servicios.ServicioDispositivoElectronico;
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
@RequestMapping("/dispositivoelectronico")
@CrossOrigin(origins = "*")
public class ControladorDispositivoElectronico {
    /**
     * Instancia de ServicioDispositivoElectronico
     */
    @Autowired
    private ServicioDispositivoElectronico servicio;
    /**
     * Obtener todos los registros
     * @return Una lista con todos los registros
     */
    @GetMapping("/all")
    public List<DispositivoElectrónico> getAll(){
        return servicio.getAll();
    }
    /**
     * Obtener un registro por mac
     * @param mac
     * @return Un registro 
     */
    @GetMapping("/{mac}")
    public Optional<DispositivoElectrónico> getDispositivo(@PathVariable String mac){
        return servicio.getDispositivo(mac);
    }
    /**
     * Registrar un dispositivo
     * @param electrónico
     * @return El registro guardado
     */
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Optional<DispositivoElectrónico> save(@RequestBody DispositivoElectrónico electrónico){
        return servicio.save(electrónico);
    }
    /**
     * Actualizar un registro
     * @param electrónico
     * @return El registro
     */
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Optional<DispositivoElectrónico> update(@RequestBody DispositivoElectrónico electrónico){
        return servicio.update(electrónico);
    }
    /**
     * Eliminar un registro
     * @param mac
     * @return Un booleano
     */
    @DeleteMapping("/{mac}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable String mac){
       return servicio.delete(mac);
    }
}
