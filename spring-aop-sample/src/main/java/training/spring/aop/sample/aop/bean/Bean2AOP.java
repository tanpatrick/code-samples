package training.spring.aop.sample.aop.bean;

import org.springframework.stereotype.Component;

/**
 *
 * @author Patrick Tan
 */
@Component
public class Bean2AOP {

    public void method1() {
        //Do something here ...
    }

    public void method2() {
        //Do something here ...
    }

    public String getValueB() {
        //Do something here ...
        return "getValue [ClassBAOP]";
    }
}
