package org.nick.org.nick.dao;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.nick.app.HibernateConfiguration;
import org.nick.model.Authority;

import java.util.List;

public class AuthorityDaoImpl implements Dao<Authority> {

    @Override
    public Authority find(Integer id) {
        Session session = HibernateConfiguration.openSession();
        session.beginTransaction();
        Query query = session.createQuery("from Authority where id = :v", Authority.class);
        query.setParameter("v", id);
        Authority authority = (Authority) query.getSingleResult();
        session.getTransaction().commit();
        System.out.println(authority.toString());
        session.close();
        return authority;
    }

    @Override
    public void save(Authority model) {

    }

    @Override
    public void update(Authority model) {

    }

    @Override
    public void delete(Integer id) {

    }

    @Override
    public List<Authority> findAll() {
        Session session = HibernateConfiguration.openSession();
        session.beginTransaction();
        Query query = session.createQuery("from Authority", Authority.class);
        List<Authority> authorities = query.list();
        session.getTransaction().commit();
        System.out.println(authorities.toString());
        session.close();
        return authorities;
    }
}
