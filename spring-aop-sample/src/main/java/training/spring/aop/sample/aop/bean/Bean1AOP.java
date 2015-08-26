package training.spring.aop.sample.aop.bean;

import training.spring.aop.sample.bean.PersonBean;
import org.springframework.stereotype.Component;

/**
 *
 * @author Patrick Tan
 */
@Component
public class Bean1AOP {

    public void method1() {
        //Do something here ...
        getValueA();

    }

    public void method2(PersonBean personBean) {
        //Do something here ...        
    }

    public String getValueA() {
        return "getValue [ClassAAOP]";
    }

    public void throwMeSomeException() {
        Integer.parseInt("2.1");
    }
}
