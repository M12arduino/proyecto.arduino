/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package m12.arduino.controller;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.activation.DataHandler;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import m12.arduino.service.ContactaForm;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Controlador para los envios de mails
 * @author Enric, Pablo, Jordi y Oscar
 */
@Controller
@RequestMapping("/contacta")
public class ControllerContacta {

    /**
     * Metodo que visulaiza el formulario de contacto.
     * @return Devuelve un objeto ModelAndView (formulario) llamado contactaForm con 
     * un objeto ContactaForm vacio y un desplegable de motivos.
     */
    @RequestMapping(value = "/formulario")
    public ModelAndView mostrarFormulario() {
        ModelAndView mV = new ModelAndView("contactaForm", "command", new ContactaForm());
        ArrayList<String> motivos = new ArrayList<String>();
        motivos.add("Cuenta desabilitada");
        motivos.add("Error de funcionalidad");
        motivos.add("Duda general sobre la aplicación");
        motivos.add("Me interesa su producto");
        motivos.add("Otro motivo");
        mV.addObject("motivos", motivos);
        return mV;
    }

    /**
     * Metodo que visulaiza el formulario de contacto para usuarios anónimos.
     * @return Devuelve un objeto ModelAndView (formulario) llamado contactaForm con 
     * un objeto ContactaForm vacio y un desplegable de motivos.
     */
    @RequestMapping(value = "/formularioAnonimo")
    public ModelAndView mostrarFormularioAnonimo() {
        ModelAndView mV = new ModelAndView("contactaFormAnonimo", "command", new ContactaForm());
        ArrayList<String> motivos = new ArrayList<String>();
        motivos.add("Credenciales invalidas");
        motivos.add("Pedir registro");
        motivos.add("Pedir informacion");
        motivos.add("Otro motivo");
        mV.addObject("motivos", motivos);
        return mV;
    }
    
    /**
     * Metodo que envia el correo de contacto.
     * @param contacta objeto ContactaForm con los datos a introducir en el correo
     * de contacto.
     * @return Devuelve un objeto ModelAndView (vista) después de enviar el correo,
     * redirecciona a la home.
     * @throws UnsupportedEncodingException en caso de fallo al crear o enviar
     * el correo de contacto.
     */
    @RequestMapping(value = "/enviarCorreo")
    public ModelAndView enviarEmail(ContactaForm contacta) throws UnsupportedEncodingException {
        ModelAndView mV = new ModelAndView("main");

        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.port", "587");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.transport.protocol", "smtp");
        props.put("mail.smtp.ssl.trust", "smtp.gmail.com");

        Session mailSession = Session.getInstance(props, null);
        Message msg = new MimeMessage(mailSession);

        try {
            msg.setSubject("El usuario " + contacta.getNombre() + " se ha puesto en contacto por: " + contacta.getMotivo());
            msg.addRecipients(Message.RecipientType.TO, new InternetAddress[]{new InternetAddress("m12.proyecto.arduino@gmail.com")});
            DataHandler dh = new DataHandler("El usuario " + contacta.getNombre() + " se ha puesto en contacto con usted desde el correo " + contacta.getEmail() + ".\n\n"
                    + "Motivo del contacto: " + contacta.getMotivo() + ".\n\n" + "Cuerpo del mensaje: " + contacta.getMensaje() + ".", "text/plain");
            msg.setDataHandler(dh);
            Transport.send(msg, "m12.proyecto.arduino@gmail.com", "root1234");
        } catch (MessagingException ex) {
            Logger.getLogger(ControllerContacta.class.getName()).log(Level.SEVERE, null, ex);
        }

        return mV;
    }

    /**
     * Metodo que envia el correo de contacto para usuarios anónimos.
     * @param contacta objeto ContactaForm con los datos a introducir en el correo
     * de contacto.
     * @return Devuelve un objeto ModelAndView (vista) después de enviar el correo,
     * redirecciona a la pagina "invalidCredentials". (sin permisos)
     * @throws UnsupportedEncodingException en caso de fallo al crear o enviar
     * el correo de contacto.
     */
    @RequestMapping(value = "/enviarCorreoAnonimo")
    public ModelAndView enviarEmailAnonimo(ContactaForm contacta) throws UnsupportedEncodingException {
        ModelAndView mV = new ModelAndView("invalidCredentials");
        
        if (contacta == null) {
            return mV;
        }

        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.port", "587");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.transport.protocol", "smtp");
        props.put("mail.smtp.ssl.trust", "smtp.gmail.com");

        Session mailSession = Session.getInstance(props, null);

        Message msg = new MimeMessage(mailSession);

        try {
            msg.setSubject("El usuario " + contacta.getNombre() + " se ha puesto en contacto por: " + contacta.getMotivo());
            msg.addRecipients(Message.RecipientType.TO, new InternetAddress[]{new InternetAddress("m12.proyecto.arduino@gmail.com")});
            DataHandler dh = new DataHandler("El usuario " + contacta.getNombre() + " se ha puesto en contacto con usted desde el correo " + contacta.getEmail() + ".\n\n"
                    + "Motivo del contacto: " + contacta.getMotivo() + ".\n\n" + "Cuerpo del mensaje: " + contacta.getMensaje() + ".", "text/plain");
            msg.setDataHandler(dh);
            Transport.send(msg, "m12.proyecto.arduino@gmail.com", "root1234");
        } catch (MessagingException ex) {
            Logger.getLogger(ControllerContacta.class.getName()).log(Level.SEVERE, null, ex);
        }

        return mV;
    }
}
