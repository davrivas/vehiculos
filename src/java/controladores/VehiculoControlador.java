/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import modelo.dao.IVehiculoDAO;
import modelo.entidades.Vehiculo;

/**
 *
 * @author davr
 */
@Named(value = "vehiculoControlador")
@ViewScoped
public class VehiculoControlador implements Serializable {

    @EJB
    private IVehiculoDAO vDAO;
    private List<Vehiculo> todosLosVehiculos;
    private Vehiculo nuevoVehiculo;
    private Vehiculo vehiculoSeleccionado;
    
    public VehiculoControlador() {
    }
    
    @PostConstruct
    public void init() {
        todosLosVehiculos = vDAO.mostrarTodos();
        nuevoVehiculo = new Vehiculo();
        vehiculoSeleccionado = new Vehiculo();
    }

    public List<Vehiculo> getTodosLosVehiculos() {
        return todosLosVehiculos;
    }

    public Vehiculo getNuevoVehiculo() {
        return nuevoVehiculo;
    }

    public void setNuevoVehiculo(Vehiculo nuevoVehiculo) {
        this.nuevoVehiculo = nuevoVehiculo;
    }

    public Vehiculo getVehiculoSeleccionado() {
        return vehiculoSeleccionado;
    }

    public void setVehiculoSeleccionado(Vehiculo vehiculoSeleccionado) {
        this.vehiculoSeleccionado = vehiculoSeleccionado;
    }
    
    public void seleccionarVehiculo(Vehiculo v) {
        vehiculoSeleccionado = v;
    }
    
    public void agregarVehiculo() {
        vDAO.insertar(nuevoVehiculo);
    }
    
    public void modificarVehiculo() {
        vDAO.editar(vehiculoSeleccionado);
    }
    
    public void eliminarVehiculo() {
        vDAO.eliminar(vehiculoSeleccionado);
    }
    
}
