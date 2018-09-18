/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.dao;

import javax.ejb.Local;
import modelo.entidades.Persona;

/**
 *
 * @author davr
 */
@Local
public interface IPersonaDAO extends IDAO<Persona> {
}
