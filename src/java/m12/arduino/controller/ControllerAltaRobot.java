/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package m12.arduino.controller;

import m12.arduino.domain.Robot;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author Couto
 */
@Controller
public class ControllerAltaRobot {
    @RequestMapping(value="formNewRobot",method = RequestMethod.GET)
    public void initForm(ModelMap model){
        Robot robot = new Robot();
        model.addAttribute("robotForm",robot);
              
    }
    
    @RequestMapping(value="formNewRobot",method = RequestMethod.POST)
    public String addRobot(@ModelAttribute("robotForm")Robot robot,ModelMap model){
        return "welcomeRobot";
    }
}
