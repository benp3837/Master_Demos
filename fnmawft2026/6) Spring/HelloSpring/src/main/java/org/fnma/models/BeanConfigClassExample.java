package org.fnma.models;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//If we wanted to use a Java Class for bean config, we need the @Configuration annotation
@Configuration
public class BeanConfigClassExample {

    //NOTE: THIS CLASS ACCOMPLISHES THE SAME THING AS OUR applicationContext.xml
    //(It registers and wires beans)
    //This is just the class-based way to do it!

//    @Bean
//    public Owner owner(){
//        return new Owner(0, "NO_NAME");
//    }
//
//    @Bean
//    public Dog dog(){
//        return new Dog(0, "Max", owner());
//    }

    //Then we'd make an ApplicationContext in main() like this:

    //ApplicationContext ac = new AnnotationConfigApplicationContext(Classname.class);

}