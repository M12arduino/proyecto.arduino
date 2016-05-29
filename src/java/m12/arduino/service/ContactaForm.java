/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package m12.arduino.service;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.Email;

/**
 * Clase ContactaForm
 *
 * @author Enric, Pablo, Jordi y Oscar
 */
public class ContactaForm {

    /**
     * Nombre
     */
    @NotNull(message = "El campo nombre es obligatorio")
    private String nombre;

    /**
     * Email
     */
    @Email
    private String email;

    /**
     * Motivo
     */
    @Size(min = 1, max = 144, message = "Maximo 144 caracteres en el motivo")
    private String motivo;

    /**
     * Mensaje
     */
    @Size(min = 1, max = 144, message = "Maximo 144 caracteres en el cuerpo de mensaje")
    private String mensaje;

    /**
     * Constructor vacio
     */
    public ContactaForm() {
    }

    /**
     * Getter del nombre
     *
     * @return nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Setter del nombre
     *
     * @param nombre nombre
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Getter del email
     *
     * @return email
     */
    public String getEmail() {
        return email;
    }

    /**
     * Setter del email
     *
     * @param email email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Getter del motivo
     *
     * @return motivo
     */
    public String getMotivo() {
        return motivo;
    }

    /**
     * Setter del motivo
     *
     * @param motivo motivo
     */
    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    /**
     * Getter del mensaje
     *
     * @return mensaje
     */
    public String getMensaje() {
        return mensaje;
    }

    /**
     * Setter del mensaje
     *
     * @param mensaje mensaje
     */
    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    /**
     * Metodo toString para devolver informacion del objeto ContactaForm
     *
     * @return información del objeto ContactaForm
     */
    @Override
    public String toString() {
        return "ContactaForm{" + "nombre=" + nombre + ", email=" + email + ", motivo=" + motivo + ", mensaje=" + mensaje + '}';
    }
}
