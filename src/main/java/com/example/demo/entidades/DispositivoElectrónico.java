
package com.example.demo.entidades;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author Oscar Gomez
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "dispositivoelectrónico")
@Entity
public class DispositivoElectrónico implements Serializable{
    /**
     * Dirección MAC del dispositivo
     */
    @Id
    private String mac;
    /**
     * Tipo de dispositivo
     */
    private String tipo;
    /**
     * Conectado actualmente
     */
    private Boolean conectadoActualmente= true;
    /**
     * Ip Asignada
     */
    private String ipAsignada;
    
    /**
     * Llave foránea para saber a que conexion se encuentra conectado
     */
    @ManyToOne()
    @JoinColumn(name = "conexionmac")
    @JsonIgnoreProperties("dispositivoElectrónicos")
    private ConexionDeRed conexionActual; 
}

























































