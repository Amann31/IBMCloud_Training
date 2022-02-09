package org.example;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

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
        Object object;
        ApplicationContext applicationContext =new ClassPathXmlApplicationContext("ApplicationContext.xml");
        Coach myCoach = applicationContext.getBean("theCoach",Coach.class);
        System.out.println(myCoach.getDailyFortune());
        System.out.println(myCoach.getDailyWorkout());

        }catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
