package com.company.model;

import java.util.Comparator;

public class SalaryComparator implements Comparator {

    private Object o1;
    Employee employee1 = (Employee) o1;
    private Object o2;
    Employee employee2 = (Employee) o2;


    @Override
    public int compare(Object o1, Object o2) {
        Employee employee1 = (Employee) o1;
        Employee employee2 = (Employee) o2;
        if(employee1.getFirstName().charAt(0)>employee2.getFirstName().charAt(0))
            return -1;
        else if(employee1.getFirstName().charAt(0)<employee2.getFirstName().charAt(0))
            return 1;
        else
            return 0;

    }
}
