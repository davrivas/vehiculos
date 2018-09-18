/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.dao.jpa;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import modelo.dao.IDAO;

/**
 *
 * @author davr
 * @param <T>
 */
public abstract class AbstractDAO<T> implements IDAO<T> {

    @PersistenceContext(unitName = "vehiculosPU")
    private EntityManager entityManager;
    
    private Class<T> entityClass;

    public AbstractDAO(Class<T> entityClass) {
        this.entityClass = entityClass;
    }

    protected EntityManager getEntityManager() {
        return entityManager;
    }

    @Override
    public void insertar(T entity) {
        getEntityManager().persist(entity);
    }

    @Override
    public void editar(T entity) {
        getEntityManager().merge(entity);
    }

    @Override
    public void eliminar(T entity) {
        getEntityManager().remove(getEntityManager().merge(entity));
    }

    @Override
    public T buscarPorId(Object id) {
        return getEntityManager().find(entityClass, id);
    }

    @Override
    public List<T> mostrarTodos() {
        javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
        cq.select(cq.from(entityClass));
        return getEntityManager().createQuery(cq).getResultList();
    }

    @Override
    public int contar() {
        javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
        javax.persistence.criteria.Root<T> rt = cq.from(entityClass);
        cq.select(getEntityManager().getCriteriaBuilder().count(rt));
        javax.persistence.Query q = getEntityManager().createQuery(cq);
        return ((Long) q.getSingleResult()).intValue();
    }
    
}
