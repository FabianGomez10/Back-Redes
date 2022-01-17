
package com.example.demo.entidades;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author Oscar Gomez
 */
@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "conexiondered")
public class ConexionDeRed implements Serializable{
    /**
     * Tipo de la conexion
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer tipo;
    /**
     * Nombre dado a la conexión
     */
    private String nombre;
    /**
     * En caso de ser Wifi, WEP, WPA y WPA2
     */
    private String tipoDeCifrado;
    /**
     * Usuario conexion
     */
    private String usuarioConexión;
    /**
     * Contraseña de conexion
     */
    private String contraseñaDeConexión;
    
    @OneToMany(cascade = {CascadeType.PERSIST}, mappedBy = "conexionActual")
    @JsonIgnoreProperties("conexionActual")
    List<DispositivoElectrónico> dispositivoElectrónicos;
}
