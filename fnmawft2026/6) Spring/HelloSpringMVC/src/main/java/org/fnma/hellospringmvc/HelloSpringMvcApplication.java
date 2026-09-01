package org.fnma.hellospringmvc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("org.fnma") // Need to point this to where the beans live
public class HelloSpringMvcApplication {

    public static void main(String[] args) {

        //NOTE: You'll never have to do this,
        //I just wanted to access the built in ApplicationContext (spring container)
        //to print the beans and such

        ConfigurableApplicationContext context =
                SpringApplication.run(HelloSpringMvcApplication.class, args);

        for (String beanName : context.getBeanDefinitionNames()) {
            System.out.println(beanName);
        }


    }

}
