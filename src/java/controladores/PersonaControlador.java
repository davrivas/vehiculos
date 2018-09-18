/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import modelo.dao.IPersonaDAO;
import modelo.entidades.Persona;

/**
 *
 * @author davr
 */
@Named(value = "personaControlador")
@ViewScoped
public class PersonaControlador implements Serializable {
    
    @EJB
    private IPersonaDAO pDAO;
    private List<Persona> todasLasPersonas;
    private Persona nuevaPersona = new Persona();
    private Persona personaSeleccionada = new Persona();

    public PersonaControlador() {
    }

    public List<Persona> getTodasLasPersonas() {
        return pDAO.mostrarTodos();
    }

    public Persona getNuevaPersona() {
        return nuevaPersona;
    }

    public void setNuevaPersona(Persona nuevaPersona) {
        this.nuevaPersona = nuevaPersona;
    }

    public Persona getPersonaSeleccionada() {
        return personaSeleccionada;
    }

    public void setPersonaSeleccionada(Persona personaSeleccionada) {
        this.personaSeleccionada = personaSeleccionada;
    }
    
    public void seleccionarPersona(Persona p) {
        personaSeleccionada = p;
    }
    
    public void agregarPersona() {
        pDAO.insertar(nuevaPersona);
    }
    
    public void modificarPersona() {
        pDAO.editar(personaSeleccionada);
    }
    
    public void eliminarPersona() {
        pDAO.eliminar(personaSeleccionada);
    }
    
}
