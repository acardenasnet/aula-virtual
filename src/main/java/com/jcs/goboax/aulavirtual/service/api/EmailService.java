package com.jcs.goboax.aulavirtual.service.api;

import com.jcs.goboax.aulavirtual.model.Usuario;

public interface EmailService
{
   void sendTemporaryPasswordEmail(Usuario aUsuario, String Password);
}
