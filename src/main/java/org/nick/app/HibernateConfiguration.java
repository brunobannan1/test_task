package org.nick.app;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.nick.model.*;

import java.io.IOException;
import java.util.Properties;

public class HibernateConfiguration {

    public static SessionFactory factory;

    private HibernateConfiguration() {
    }

    public static synchronized SessionFactory getSessionFactory() {
        Properties properties = new Properties();
        try {
            properties.load(HibernateConfiguration.class.getClassLoader().getResourceAsStream("db.properties"));
            String dbUrl = properties.getProperty("db.url");
            String dbUsername = properties.getProperty("db.username");
            String dbPassword = properties.getProperty("db.password");
            String driverClassName = properties.getProperty("db.driverClassName");
            Class.forName(properties.getProperty("db.driverClassName"));
            String driverDialect = properties.getProperty("db.dialect");
            if (factory == null) {
                factory = new Configuration()
                        .setProperty("hibernate.connection.url", dbUrl)
                        .setProperty("hibernate.connection.username", dbUsername)
                        .setProperty("hibernate.connection.password", dbPassword)
                        .setProperty("hibernate.connection.driver_class", driverClassName)
                        .setProperty("hibernate.dialect", driverDialect)
                        .setProperty("hibernate.hbm2ddl.auto", "update")
                        .setProperty("show_sql", "true")
                        .setProperty("format_sql", "true")
                        .setProperty("hibernate.enable_lazy_load_no_trans", "true")
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
        } catch (Exception e) {
            e.printStackTrace();
        }
        return factory;
    }

    public static synchronized Session openSession() {
        return getSessionFactory().openSession();
    }
}
