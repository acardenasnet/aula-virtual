/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jcs.goboax.aulavirtual.controller;

import com.jcs.goboax.aulavirtual.bll.Authenticate;
import com.jcs.goboax.aulavirtual.model.RegistroAcceso;
import com.jcs.goboax.aulavirtual.model.Usuario;
import java.util.Date;
import javax.servlet.http.HttpSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {

    private final static Logger LOG = LoggerFactory.getLogger(LoginController.class);
    
    @Autowired
    private Authenticate loginService;
    
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView login() 
    {            
        return new ModelAndView("login", "command", new Usuario());
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ModelAndView processForm(HttpSession session, Usuario usr, BindingResult result) 
    {
        LOG.debug("doLogin {}");
        Usuario usrLogin;
        
        usrLogin = tryLogin(session, usr);
        
        if(usrLogin != null) {
            return new ModelAndView("home");
        } else {
            return new ModelAndView("login", "command", usr);
        }
    }
    
    /* Private Methods */
    private Usuario tryLogin(HttpSession session, Usuario usr) 
    {        
        LOG.debug("private tryLogin {}", usr.getUsername());
        Usuario usuario;
        RegistroAcceso acceso = new RegistroAcceso();

        acceso.setInicioAcceso(new Date());
        acceso.setSessionId(session.getId());
        
        usuario = loginService.Login(usr, acceso);
            
        return usuario;
    }
}
