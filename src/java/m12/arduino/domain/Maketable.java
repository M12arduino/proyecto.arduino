/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package m12.arduino.domain;

import java.util.List;

/**
 * Clase Maketable Implementable
 *
 * @author Enric, Pablo, Jordi y Oscar
 */
public interface Maketable {

    List<String> getFields();

    List<String> getInfo();

    long getPK();

    String getFullName();
}
