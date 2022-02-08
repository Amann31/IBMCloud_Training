package org.example;

import org.example.model.Coach;
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
            ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
            Coach theCoach = applicationContext.getBean("coach",Coach.class);
            System.out.println(theCoach.getDailyWorkout());
        }catch (Exception e)
        {
            e.printStackTrace();;
        }
    }
}
