package org.nick.dao;

import org.hibernate.Session;
import org.nick.app.HibernateConfiguration;
import org.nick.model.*;

import java.util.List;

public class FormsDaoImpl implements Dao<Forms> {

    public Forms fillForms(Forms forms) {
        List<Form> form = forms.getForms();
        for (Form f : form) {
            f.setForms(forms);

            Data data = f.getData();
            data.setForm(f);

            User user = data.getUser();
            user.getData().add(data);

            Service service = data.getService();
            service.getData().add(data);

            Authority authority = data.getAuthority();
            authority.getData().add(data);

            Rates rates = f.getRates();
            rates.setForm(f);
            List<Rate> rateList = rates.getRates();
            for (Rate r : rateList) {
                r.getRates().add(rates);
            }
        }
        return forms;
    }

    @Override
    public Forms find(Integer id) {
        Session session = HibernateConfiguration.openSession();
        session.beginTransaction();
        Forms forms = session.createQuery("from Forms forms where forms.id = :id", Forms.class)
                .setParameter("id", id)
                .getSingleResult();
        session.getTransaction().commit();
        session.close();
        return forms;
    }

    @Override
    public void save(Forms model) {
        fillForms(model);
        FormDaoImpl formDao = new FormDaoImpl();
        List<Form> list = model.getForms();
        for (Form f : list) {
            formDao.save(f);
        }
    }

    @Override
    public void update(Forms model) {

    }

    @Override
    public void delete(Integer id) {

    }

    @Override
    public List<Forms> findAll() {
        Session session = HibernateConfiguration.openSession();
        session.beginTransaction();
        List<Forms> list = session.createQuery("from Forms forms", Forms.class).getResultList();
        session.getTransaction().commit();
        session.close();
        return list;
    }
}
