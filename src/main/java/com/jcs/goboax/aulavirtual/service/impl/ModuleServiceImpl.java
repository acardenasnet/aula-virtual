package com.jcs.goboax.aulavirtual.service.impl;

import com.jcs.goboax.aulavirtual.dao.api.ModuloDao;
import com.jcs.goboax.aulavirtual.model.Modulo;
import com.jcs.goboax.aulavirtual.service.api.AuthenticationService;
import com.jcs.goboax.aulavirtual.service.api.ModuleService;
import com.jcs.goboax.aulavirtual.viewmodel.ModuleModelForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
public class ModuleServiceImpl
        implements ModuleService
{
    @Autowired
    private ModuloDao moduloDao;

    @Autowired
    private ConversionService conversionService;

    @Autowired
    private AuthenticationService authenticationService;

    @Transactional
    @Override
    public void createModule(ModuleModelForm aModuleModelForm)
    {
        Modulo myModulo = conversionService.convert(aModuleModelForm, Modulo.class);
        myModulo.setFechaCreacion(new Date());
        myModulo.setCreadoPor(authenticationService.getUsuario().getUsuarioId());

        moduloDao.persist(myModulo);
    }

    @Transactional(readOnly = true)
    @Override
    public List<Modulo> readModulesByCourse(Integer aCourseId)
    {
        return moduloDao.readByCourse(aCourseId);
    }

    @Transactional(readOnly = true)
    @Override
    public Modulo readModuleById(Integer aModuleId)
    {
        return moduloDao.findByKey(aModuleId);
    }

    @Transactional
    @Override
    public ModuleModelForm updateModule(ModuleModelForm aModuleModelForm)
    {
        Modulo myModulo = conversionService.convert(aModuleModelForm, Modulo.class);
        myModulo.setModificadoPor(authenticationService.getUsuario().getUsuarioId());
        myModulo.setFechaModificacion(new Date());

        moduloDao.update(myModulo);

        return conversionService.convert(myModulo, ModuleModelForm.class);
    }

    @Transactional
    @Override
    public void disableModule(Integer moduleId)
    {
        Modulo myModulo = moduloDao.findByKey(moduleId);
        if (myModulo.isHabilitado() == true)
        {
            myModulo.setHabilitado(false);
            myModulo.setModificadoPor(authenticationService.getUsuario().getUsuarioId());
            myModulo.setFechaModificacion(new Date());

            moduloDao.update(myModulo);
        }
    }
}
