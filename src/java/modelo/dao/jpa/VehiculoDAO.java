/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.dao.jpa;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import modelo.entidades.Vehiculo;
import modelo.dao.IVehiculoDAO;
import modelo.entidades.Persona;

/**
 *
 * @author davr
 */
@Stateless
public class VehiculoDAO extends AbstractDAO<Vehiculo> implements IVehiculoDAO {

    public VehiculoDAO() {
        super(Vehiculo.class);
    }
    
}
