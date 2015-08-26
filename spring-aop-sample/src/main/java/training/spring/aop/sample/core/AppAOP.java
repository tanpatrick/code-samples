package training.spring.aop.sample.core;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import training.spring.aop.sample.aop.bean.Bean1AOP;
import training.spring.aop.sample.aop.bean.Bean2AOP;
import training.spring.aop.sample.bean.PersonBean;

/**
 *
 * @author Patrick Tan
 */
public class AppAOP {

    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("Spring-AOP.xml");
        PersonBean personBean = new PersonBean("Jose Rizal", "Male");

        applicationContext.getBean(Bean1AOP.class).method1();
        applicationContext.getBean(Bean1AOP.class).method2(personBean);

        Logger.getLogger(AppAOP.class).info(personBean.toString());

        applicationContext.getBean(Bean1AOP.class).getValueA();
        applicationContext.getBean(Bean2AOP.class).getValueB();

        applicationContext.getBean(Bean2AOP.class).method1();
        applicationContext.getBean(Bean2AOP.class).method2();

        applicationContext.getBean(Bean1AOP.class).throwMeSomeException();
    }
}
