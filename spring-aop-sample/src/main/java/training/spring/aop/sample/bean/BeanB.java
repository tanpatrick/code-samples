package training.spring.aop.sample.bean;

import training.spring.aop.sample.util.LoggerUtil;
import org.springframework.stereotype.Component;

/**
 *
 * @author Patrick Tan
 */
@Component
public class BeanB {

    public void method1() {
        LoggerUtil.logMessage("invoked method1 ...");
    }

    public void method2() {
        LoggerUtil.logMessage("invoked method2 ...");
    }

    public void method3() {
        LoggerUtil.logMessage("invoked method3 ...");
    }
}
