package org.example;

import org.example.model.Employee;
import org.example.service.EmployeeService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Random;

public class tester {
    private static EmployeeService employeeService;
    private static EmployeeService getEmployeeService()
    {
        try
        {
            ApplicationContext applicationContext = new ClassPathXmlApplicationContext("ApplicationContext.xml");
            employeeService=applicationContext.getBean("employeeService",EmployeeService.class);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return employeeService;
    }


    public static void main(String[] args) {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int choice=0;
        do {
            System.out.println("1. Create Employee. \t");
            System.out.println("2. Update Employee. \t");
            System.out.println("3. Delete Employee. \t");
            System.out.println("4. Find by Employee ID. \t");
            System.out.println("Enter your choice: ");
            try
            {
                choice = Integer.parseInt(bufferedReader.readLine());
                switch (choice)
                {
                    case 1:
                        System.out.println("Enter First name: ");
                        String firstName = bufferedReader.readLine();
                        System.out.println("Enter Last name: ");
                        String lastName = bufferedReader.readLine();
                        System.out.println("Enter email: ");
                        String email = bufferedReader.readLine();
                        Employee employee = getEmployeeService().createEmployee(new Employee(new Random().nextInt(1000),firstName,lastName,email));
                        System.out.println("Employee created: "+employee);
                        break;
                    case 2:
                        System.out.println("Enter ID in which update is to be made: ");
                        int id2 = Integer.parseInt(bufferedReader.readLine());
                        employee=employeeService.updateEmployee(id2);
                        System.out.println("Details Updated successfully."+ employee);
                        break;
                    case 4:
                        System.out.println("Enter ID: ");
                        int id= Integer.parseInt(bufferedReader.readLine());
                        employee=employeeService.findEmployeeById(id);
                        System.out.println("Employee found with details: "+employee);
                        break;
                }
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
        }while(choice!=0);

    }
}
