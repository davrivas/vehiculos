/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.dao.jpa;

import javax.ejb.Stateless;
import modelo.entidades.Persona;
import modelo.dao.IPersonaDAO;

/**
 *
 * @author davr
 */
@Stateless
public class PersonaDAO extends AbstractDAO<Persona> implements IPersonaDAO {

    public PersonaDAO() {
        super(Persona.class);
    }
    
}
