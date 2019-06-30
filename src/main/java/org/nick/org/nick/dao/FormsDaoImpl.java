package org.nick.org.nick.dao;

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
        return null;
    }

    @Override
    public void save(Forms model) {
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
        return null;
    }
}
