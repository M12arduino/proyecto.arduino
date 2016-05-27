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
 *
 * @author couto
 */
@Controller
@RequestMapping("/contacta")
public class ControllerContacta {

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

    @RequestMapping(value = "/enviarCorreo")
    public ModelAndView enviarEmail(ContactaForm contacta) throws UnsupportedEncodingException {

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
            DataHandler dh = new DataHandler("El usuario " + contacta.getNombre() + " se ha puesto en contacto con usted desde el correo " + contacta.getEmail()+ ".\n\n" +
                "Motivo del contacto: " + contacta.getMotivo() + ".\n\n" + "Cuerpo del mensaje: " + contacta.getMensaje() + "." , "text/plain");
            msg.setDataHandler(dh);
            Transport.send(msg, "m12.proyecto.arduino@gmail.com", "root1234");
        } catch (MessagingException ex) {
            Logger.getLogger(ControllerContacta.class.getName()).log(Level.SEVERE, null, ex);
        }

        ModelAndView mV = new ModelAndView("main");
        return mV;
    }

}