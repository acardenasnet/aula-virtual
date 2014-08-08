package com.jcs.goboax.aulavirtual.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * The persistent class for the Examen database table.
 * 
 */
@Entity
@NamedQuery(name = "Examen.findAll", query = "SELECT e FROM Examen e")
public class Examen
        implements Serializable
{
    private static final long serialVersionUID = 1L;

    @Id
    private int examenId;

    private int creadoPor;

    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaCreacion;

    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaModificacion;

    private int modificadoPor;

    private short numPreguntas;

    private short numRespuestasPregunta;

    // bi-directional many-to-one association to Curso
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cursoId")
    private Curso curso;

    // bi-directional many-to-one association to Pregunta
    @OneToMany(mappedBy = "examen")
    private List<Pregunta> preguntas;

    public Examen()
    {
    }

    public int getExamenId()
    {
        return this.examenId;
    }

    public void setExamenId(int examenId)
    {
        this.examenId = examenId;
    }

    public int getCreadoPor()
    {
        return this.creadoPor;
    }

    public void setCreadoPor(int creadoPor)
    {
        this.creadoPor = creadoPor;
    }

    public Date getFechaCreacion()
    {
        return this.fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion)
    {
        this.fechaCreacion = fechaCreacion;
    }

    public Date getFechaModificacion()
    {
        return this.fechaModificacion;
    }

    public void setFechaModificacion(Date fechaModificacion)
    {
        this.fechaModificacion = fechaModificacion;
    }

    public int getModificadoPor()
    {
        return this.modificadoPor;
    }

    public void setModificadoPor(int modificadoPor)
    {
        this.modificadoPor = modificadoPor;
    }

    public short getNumPreguntas()
    {
        return this.numPreguntas;
    }

    public void setNumPreguntas(short numPreguntas)
    {
        this.numPreguntas = numPreguntas;
    }

    public short getNumRespuestasPregunta()
    {
        return this.numRespuestasPregunta;
    }

    public void setNumRespuestasPregunta(short numRespuestasPregunta)
    {
        this.numRespuestasPregunta = numRespuestasPregunta;
    }

    public Curso getCurso()
    {
        return this.curso;
    }

    public void setCurso(Curso curso)
    {
        this.curso = curso;
    }

    public List<Pregunta> getPreguntas()
    {
        return this.preguntas;
    }

    public void setPreguntas(List<Pregunta> preguntas)
    {
        this.preguntas = preguntas;
    }

    public Pregunta addPregunta(Pregunta pregunta)
    {
        getPreguntas().add(pregunta);
        pregunta.setExamen(this);

        return pregunta;
    }

    public Pregunta removePregunta(Pregunta pregunta)
    {
        getPreguntas().remove(pregunta);
        pregunta.setExamen(null);

        return pregunta;
    }

}