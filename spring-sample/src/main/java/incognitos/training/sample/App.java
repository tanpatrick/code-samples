package incognitos.training.sample;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author Patrick Tan
 */
public class App {

    public static void main(String[] args) {
        ApplicationContext appContext = new ClassPathXmlApplicationContext("SpringXMLConfig.xml");
        System.out.println(" ..." + (Person) appContext.getBean("personA"));
        System.out.println(" ..." + (Person) appContext.getBean("personB"));
    }
}
