/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.dao;

import java.util.List;
import modelo.entidades.Persona;

/**
 *
 * @author davr
 * @param <T>
 */
public interface IDAO<T> {
    public void insertar(T obj);

    public void editar(T obj);

    public void eliminar(T obj);

    public T buscarPorId(Object id);

    public List<T> mostrarTodos();

    public int contar();
}
