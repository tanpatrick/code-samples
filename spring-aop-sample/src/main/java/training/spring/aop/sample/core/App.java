package training.spring.aop.sample.core;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import training.spring.aop.sample.bean.BeanA;
import training.spring.aop.sample.bean.BeanB;
import training.spring.aop.sample.bean.PersonBean;

/**
 *
 * @author Patrick Tan
 */
public class App {

    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("Spring-AOP.xml");
        PersonBean personBean = new PersonBean("Jose Rizal", "Male");

        applicationContext.getBean(BeanA.class).method1();
        applicationContext.getBean(BeanA.class).method2(personBean);

        Logger.getLogger(App.class).info(personBean);

        applicationContext.getBean(BeanB.class).method1();
        applicationContext.getBean(BeanB.class).method2();
        applicationContext.getBean(BeanB.class).method3();

    }
}
