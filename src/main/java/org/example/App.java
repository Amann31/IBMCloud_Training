package org.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        try
        {
            Configuration configuration;
            SessionFactory sessionFactory = new Configuration().configure().addAnnotatedClass(Customer.class)
                    .buildSessionFactory();
            Session session = sessionFactory.openSession();;
            Customer customer = new Customer("John Doe");
            session.getTransaction().begin();
            session.save(customer);
            session.getTransaction().commit();
            System.out.println("Customer Saved");


        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
