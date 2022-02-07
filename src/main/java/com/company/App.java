package com.company;


import com.company.model.Employee;
import com.company.model.SalaryComparator;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class App{
    private int a;


    public static void main(String[] args )
    {
        /*Set<Employee> employees= new HashSet<Employee>();
        employees.add(new Employee(1,"John","Doe","john@email.com"));
        employees.add(new Employee(2,"Marry","Public","marry@email.com"));
        employees.add(new Employee(3,"Sachin","Tendulkar","sachin@email.com"));
        employees.add(new Employee(4,"Rahul","Dravid","rahul@email.com"));
        employees.add(new Employee(5,"John","Pareera","john1@email.com"));
        System.out.println(employees);

        Iterator<Employee> iterator= employees.iterator();
        while(iterator.hasNext())
        {
            System.out.println(iterator.next());
        }

        //printing using enhanced for loop
        for(Employee s:employees)
        {
            System.out.println(s);
        }*/
        /*Comparator salaryComparator=new SalaryComparator();
        Set<Employee> employees=new TreeSet<>(salaryComparator);

        employees.add(new Employee(new Random().nextInt(1000),"John","Doe","john@email.com",9000));
        employees.add(new Employee(new Random().nextInt(1000),"Marry","Public","marry@email.com",10000));
        employees.add(new Employee(new Random().nextInt(1000),"Sachin","Tendulkar","sachin@email.com",11000));
        employees.add(new Employee(new Random().nextInt(1000),"Rahul","Dravid","rahul@email.com",8000));
        employees.add(new Employee(new Random().nextInt(1000),"John","Pareera","john1@email.com",6000));

        System.out.println(employees);
        Iterator<Employee> iterator=employees.iterator();
        while(iterator.hasNext())
        {
            System.out.println(iterator.next());
        }*/
        int a;
        Set<Integer> a1= new HashSet<>();
        Scanner s1 = new Scanner(System.in);

        System.out.println("Enter a no.");
        a = s1.nextInt();
        a1.add(a);
        a1.add(20);
        a1.add(30);

        if(true){
        System.out.println(a1.contains(10));
        }
        else
        {
            throw new NoSuchElementException();
        }



    }


}
