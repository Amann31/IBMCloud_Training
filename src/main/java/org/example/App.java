package org.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaQuery;
import java.util.Iterator;
import java.util.List;

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
            Session session = sessionFactory.openSession();

          /*  //add a new customer
            Customer customer = new Customer("Aman Sharma", "aman@email.com");
           session.getTransaction().begin();
            session.save(customer);
            session.getTransaction().commit();
            System.out.println("Customer Saved");*/

          /*  // retrieve customer by name from table
            session.getTransaction().begin();
            TypedQuery query = session.createQuery("FROM Customer C WHERE C.customerName=:cName");
            query.setParameter("cName","Aman Sharma");
            List<Customer> list = query.getResultList();
            session.getTransaction().commit();
            Iterator<Customer> iterator = list.iterator();
            while(iterator.hasNext())
            {
                System.out.println(iterator.next());
            }*/

            /*//retrieve customer by using ID
            session.getTransaction().begin();
            Customer customer1 = session.find(Customer.class,2);
            session.getTransaction().commit();
            System.out.println(customer1);*/

              // retrieve customer by email from table
            /*session.getTransaction().begin();
            TypedQuery query = session.createQuery("FROM Customer C WHERE C.email=:cEmail");
            query.setParameter("cEmail","aman@email.com");
            List<Customer> list = query.getResultList();
            session.getTransaction().commit();
            Iterator<Customer> iterator = list.iterator();
            while(iterator.hasNext())
            {
                System.out.println(iterator.next());
            }*/

            //delete customer from table
            /*session.getTransaction().begin();
            Customer customer1 = session.find(Customer.class,4);
            session.remove(customer1);
            session.getTransaction().commit();
            System.out.println("Deleted successfully.");*/


            //update customer details
            session.getTransaction().begin();
            Customer customer1 = session.find(Customer.class,5);
            //customer1.setCustomerName("AMAN");
            customer1.setEmail("man@email.com");
            session.merge(customer1);
            session.getTransaction().commit();
            System.out.println("Updated successfully.");


        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
