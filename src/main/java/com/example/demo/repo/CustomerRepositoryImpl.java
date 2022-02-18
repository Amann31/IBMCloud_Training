package com.example.demo.repo;

import com.example.demo.model.Customer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.TypedQuery;
import java.util.List;
import java.util.Random;

@Repository
@EnableTransactionManagement
public class CustomerRepositoryImpl implements CustomerRepository {
    private final SessionFactory sessionFactory;
    @Autowired
    public CustomerRepositoryImpl(SessionFactory sessionFactory) {
        super();
        this.sessionFactory = sessionFactory;
    }

    @Override
    @Transactional
    public List<Customer> getAllCustomer() {
        // TODO Auto-generated method stub
        Session session=sessionFactory.openSession();
        TypedQuery<Customer> query=session.createQuery(" FROM Customer C",Customer.class);
        return query.getResultList();
    }

    @Override
    @Transactional
    public Customer createCustomer(Customer customer) {
        customer.setId(new Random().nextInt(1000));
        Session session=sessionFactory.openSession();
        session.getTransaction().begin();
        session.persist(customer);
        session.getTransaction().commit();
        return customer;
    }
    }

