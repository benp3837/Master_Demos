package org.fnma.hellospring;

import org.fnma.models.Owner;
import org.fnma.models.Shoe;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SpringBootApplication
public class HelloSpringApplication {

    public static void main(String[] args) {
        SpringApplication.run(HelloSpringApplication.class, args);

        //Create an ApplicationContext object based on our applicationContext.xml file
        //This is our SPRING IOC CONTAINER - it manages our beans and dependency injection
        //ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");

        ApplicationContext ac = new ClassPathXmlApplicationContext(
                "annotationDrivenApplicationContext.xml");

        //***Now, we can use the ApplicationContext to do Spring Bean stuff!***

        //First, lets just view all the beans that are currently in the app
        String[] beanNames = ac.getBeanDefinitionNames();

        //owner, shoe. The two beans we defined.
        for(String bean : beanNames){
            System.out.println(bean);
        }

        //Ask for an Owner bean and print it out
        Owner owner = ac.getBean(Owner.class);
        System.out.println(owner);
        //Nothing super interesting^ But we do see the default value :)

        //Ask for a Shoe bean and print it out
        Shoe shoe = ac.getBean(Shoe.class);
        System.out.println(shoe);

        //FASCINATING!!! The Shoe class ALREADY HAS an instantiated Owner object

        //Give some values to the Shoe bean
        shoe.setShoeId(1);
        shoe.setShoeName("Sambas");

        System.out.println("=========================(Bean Scopes)");

        Shoe shoe2 = ac.getBean(Shoe.class);
        shoe2.setShoeId(2);
        shoe2.setShoeName("onCloud");

        //Both the same instance! Beans are Singleton scoped by default!
        System.out.println(shoe);
        System.out.println(shoe2);

        //If you're reading this, we set the scope to "Prototype" to allow multiple instances

        //NOTE: We never changed the scope of the Owner bean. So it stays Singleton

    }

}
