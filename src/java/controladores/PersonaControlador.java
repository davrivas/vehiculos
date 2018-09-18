/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
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

    public PersonaControlador() {
    }
    
    @PostConstruct
    public void init() {
        todasLasPersonas = new ArrayList<>();
    }

    public List<Persona> getTodasLasPersonas() {
        if (todasLasPersonas == null || todasLasPersonas.isEmpty()) {
            todasLasPersonas = pDAO.mostrarTodos();
        }
        return todasLasPersonas;
    }
    
}
