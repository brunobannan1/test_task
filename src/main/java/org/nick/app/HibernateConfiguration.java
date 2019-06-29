package org.nick.app;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.nick.model.*;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class HibernateConfiguration {

    public static SessionFactory factory;

    private HibernateConfiguration() {
    }

    public static synchronized SessionFactory getSessionFactory() {
        Properties properties = new Properties();
        try {
            properties.load(new FileInputStream("db.properties"));
            String dbUrl = properties.getProperty("db.url");
            String dbUsername = properties.getProperty("db.username");
            String dbPassword = properties.getProperty("db.password");
            String driverClassName = properties.getProperty("db.driverClassName");
            String driverDialect = properties.getProperty("db.dialect");
            if (factory == null) {
                factory = new Configuration()
                        .setProperty("hibernate.connection.url", dbUrl)
                        .setProperty("hibernate.connection.username", dbUsername)
                        .setProperty("hibernate.connection.password", dbPassword)
                        .setProperty("hibernate.connection.driver_class", driverClassName)
                        .setProperty("hibernate.dialect", driverDialect)
                        .setProperty("hibernate.hbm2ddl.auto", "create")
                        .setProperty("show_sql", "true")
                        .addAnnotatedClass(Authority.class)
                        .addAnnotatedClass(Data.class)
                        .addAnnotatedClass(Form.class)
                        .addAnnotatedClass(Forms.class)
                        .addAnnotatedClass(Rate.class)
                        .addAnnotatedClass(Rates.class)
                        .addAnnotatedClass(Service.class)
                        .addAnnotatedClass(User.class)
                        .buildSessionFactory();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return factory;
    }

    public static synchronized Session getSession() {
        return getSessionFactory().openSession();
    }
}
