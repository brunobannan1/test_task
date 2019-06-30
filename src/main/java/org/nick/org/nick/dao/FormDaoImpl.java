package org.nick.org.nick.dao;

import org.hibernate.Session;
import org.nick.app.HibernateConfiguration;
import org.nick.model.Form;

import java.util.List;

public class FormDaoImpl implements Dao<Form> {
    @Override
    public Form find(Integer id) {
        return null;
    }

    @Override
    public void save(Form model) {
        Session session = HibernateConfiguration.openSession();
        session.beginTransaction();
        session.save(model);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void update(Form model) {

    }

    @Override
    public void delete(Integer id) {

    }

    @Override
    public List<Form> findAll() {
        return null;
    }
}
