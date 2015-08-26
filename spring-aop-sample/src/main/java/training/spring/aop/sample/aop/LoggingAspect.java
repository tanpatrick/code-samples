package training.spring.aop.sample.aop;

import training.spring.aop.sample.bean.PersonBean;
import java.util.Arrays;
import java.util.Date;
import org.apache.log4j.Logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.stereotype.Component;

/**
 *
 * @author Patrick Tan
 */
@Component(value = "loggingAspect")
public class LoggingAspect {

    private static final Logger LOGGER = Logger.getLogger(LoggingAspect.class);

    public void logBefore(JoinPoint joinPoint) {
        LOGGER.info("----> Start Before Advice <---");
        LOGGER.info("Invoked   : " + joinPoint.getSignature().getName() + "() of class [" + joinPoint.getThis() + "]");

        if (joinPoint.getArgs() != null && joinPoint.getArgs().length > 0) {
            LOGGER.info("Populate created by and date field ...");

            PersonBean personBean = (PersonBean) joinPoint.getArgs()[0];
            personBean.setCreatedBy("Andress Bonifacio");
            personBean.setCreatedDate(new Date());
        }
        LOGGER.info("----> End Before Advice <---" + System.lineSeparator());
    }

    public void logAfter(JoinPoint joinPoint) {
        LOGGER.info("----> Start After Advice <---");
        LOGGER.info("Invoked   : " + joinPoint.getSignature().getName() + "() of class [" + joinPoint.getThis() + "]");
        LOGGER.info("----> End After Advice <---" + System.lineSeparator());
    }

    public void logAfterReturning(JoinPoint joinPoint, Object result) {
        LOGGER.info("----> Start After Return Advice <---");
        LOGGER.info("Invoked   : " + joinPoint.getSignature().getName() + "() of class [" + joinPoint.getThis() + "]");
        LOGGER.info("Result    : " + result);
        LOGGER.info("----> End After Advice <---" + System.lineSeparator());

    }

    public void logAfterThrowing(JoinPoint joinPoint, Throwable error) {
        LOGGER.info("----> Start Throw Advice <---");
        LOGGER.info("Invoked   : " + joinPoint.getSignature().getName() + "() of class [" + joinPoint.getThis() + "]");
        LOGGER.info("Exception : " + error);
        LOGGER.info("----> End Throw Advice <---" + System.lineSeparator());

    }

    public void logAround(ProceedingJoinPoint joinPoint) throws Throwable {
        LOGGER.info("----> Start Around Advice <---");
        LOGGER.info("Invoked   : " + joinPoint.getSignature().getName() + "() of class [" + joinPoint.getThis() + "]");
        LOGGER.info("Arguments : " + Arrays.toString(joinPoint.getArgs()));

        LOGGER.info("Around before is running!");
        joinPoint.proceed();
        LOGGER.info("Around after is running!");
        LOGGER.info("----> End Around Advice <---" + System.lineSeparator());

    }

}
