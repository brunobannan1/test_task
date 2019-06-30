package org.nick.app;

import org.hibernate.Session;
import org.nick.model.Forms;
import org.nick.dao.FormsDaoImpl;

public class Main {
    static Forms forms = null;

    public static void main(String[] args) {
        String filePath = "example.xml";
        Session session = HibernateConfiguration.openSession();

        FormsDaoImpl formsDao = new FormsDaoImpl();
        Forms filledForms = formsDao.fillForms(forms);
        formsDao.save(forms);
        int i = 0;
        session.close();
    }
}