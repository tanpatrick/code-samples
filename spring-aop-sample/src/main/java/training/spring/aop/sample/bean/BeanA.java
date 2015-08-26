package training.spring.aop.sample.bean;

import java.util.Date;

import org.springframework.stereotype.Component;

import training.spring.aop.sample.util.LoggerUtil;

/**
 *
 * @author Patrick Tan
 */
@Component
public class BeanA {

    public void method1() {
        LoggerUtil.logMessage("invoked method1 ...");
    }

    public void method2(PersonBean personBean) {
        LoggerUtil.logMessage("invoked method2 ...");

        personBean.setCreatedBy("createdBy manual");
        personBean.setCreatedDate(new Date());
    }
}
