package com.jcs.goboax.aulavirtual.converter;

import com.jcs.goboax.aulavirtual.util.Helper;
import org.springframework.core.convert.converter.Converter;

import com.jcs.goboax.aulavirtual.model.Usuario;
import com.jcs.goboax.aulavirtual.viewmodel.Registration;

import java.util.Date;

public class RegistrationToUsuarioConverter 
    implements Converter<Registration, Usuario> {

    @Override
    public Usuario convert(Registration aRegistration) {
        Usuario myUsuario = new Usuario();
        myUsuario.setFechaCreacion(new Date());
        myUsuario.setHabilitado(true);
        myUsuario.setUsername(aRegistration.getEmail());
        myUsuario.setPassword(Helper.encodePassword(aRegistration.getPassword()));
        return myUsuario;
    }

}
