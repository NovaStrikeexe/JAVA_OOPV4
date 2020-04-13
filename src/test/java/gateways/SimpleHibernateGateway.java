package gateways;
import Utils.EntityManagerFactoryUtil;
import exceptions.EntityNotFound;
import gateways.EntityClass;
import gateways.Gateway;

import javax.persistence.*;
import javax.persistence.EntityManagerFactory;
import java.lang.reflect.ParameterizedType;
import java.util.List;

public class SimpleHibernateGateway<T extends EntityClass>  implements Gateway<T> {
    private final EntityManager em = EntityManagerFactoryUtil.geteEntityManager();
    private final Class<T> persistentClass;


    @SuppressWarnings("unchecked")
    public SimpleHibernateGateway(){
        this.persistentClass = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<T> all() {
        return em.createQuery("Select t from " + persistentClass.getSimpleName() + " t").getResultList();
    }

    @Override
    public T find(int id) throws EntityNotFound {
        T person = em.find(persistentClass, id);
        if (person == null)
            throw new EntityNotFound(String.format("Entity with id=%d not found", id ));
        return person;
    }

    @Override
    public void insert(T object) {
        em.getTransaction().begin();
        em.persist(object);
        em.getTransaction().commit();
    }

    @Override
    public void update(T object) throws EntityNotFound {
        em.getTransaction().begin();
        em.merge(object);
        em.getTransaction().commit();
    }

    @Override
    public void delete(int index) {
        em.getTransaction().begin();
        try {
            T ob = find(index);
            em.remove(ob);
        }
       catch (EntityNotFound e)
       {

       }
        em.getTransaction().commit();
    }
}
