package web.dao;

;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import web.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao{


    @PersistenceContext
    private EntityManager entityManager;



    @Override
    @Transactional
    public void add(User user) {
        entityManager.persist(user);
    }

    @Override
    @Transactional
    public List<User> listUser() {
        Query query = entityManager.createQuery("FROM User", User.class);
        return query.getResultList();
    }

    @Override
    @Transactional
    public void delete(Long id) {
        User user = entityManager.find(User.class, id);
        entityManager.remove(user);
    }

    @Override
    @Transactional
    public void update(User user) {
        entityManager.merge(user);
    }

    @Override
    @Transactional
    public User get(Long id) {
        return entityManager.find(User.class, id);
    }
}
