package gw;

import exceptions.EntityNotFound;
import utils.EntityManagerFactoryUtil;

import javax.persistence.EntityManager;
import java.lang.reflect.ParameterizedType;
import java.util.List;

public class SimpleGetWay<T> implements GetWay<T> {
    private EntityManager em = EntityManagerFactoryUtil.getEntityManager();
    private Class<T> persistentClass;

    @SuppressWarnings("unchecked")//?????????????
    public SimpleGetWay(){
        this.persistentClass = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    }

    @SuppressWarnings("unchecked")//?????????????
    public List<T> all() {
        return em.createQuery("Select t from " + persistentClass.getSimpleName() + " t ").getResultList();
    }

    public T find(int id) throws EntityNotFound {
        T entity = em.find(persistentClass, id);
        if(entity == null)
            throw new EntityNotFound(String.format("Entity with id=%d not found", id));
        return entity;
    }

    public void insert(T object) {
        em.getTransaction().begin();
        em.persist(object);
        em.getTransaction().commit();
    }

    public void update(T object) throws EntityNotFound {
        em.getTransaction().begin();
        em.merge(object);
        em.getTransaction().commit();
    }

    public void delete(T object) {
        em.getTransaction().begin();
        em.remove(object);
        em.getTransaction().commit();
    }
}