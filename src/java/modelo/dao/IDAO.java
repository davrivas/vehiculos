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
    public void create(T obj);

    public void edit(T obj);

    public void remove(T obj);

    public T find(Object id);

    public List<T> findAll();

    public List<T> findRange(int[] range);

    public int count();
}
