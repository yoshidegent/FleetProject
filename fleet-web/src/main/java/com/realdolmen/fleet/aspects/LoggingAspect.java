package com.realdolmen.fleet.aspects;

import com.realdolmen.fleet.viewmodels.admin.car.CarEditForm;
import com.realdolmen.fleet.viewmodels.admin.carModel.CarModelEditForm;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {
    private static Logger logger = LoggerFactory.getLogger(LoggingAspect.class);

    @Pointcut("execution(* com.realdolmen.fleet.controllers.admin.CarController.modelPost(..))")
    public void carEdit() {}

    @Pointcut("execution(* com.realdolmen.fleet.controllers.admin.CarModelController.modelPost(..))")
    public void carModelEdit() {}

    @Around("carEdit()")
    public Object aroundCarEdit(ProceedingJoinPoint pjp) throws Throwable {
        Object[] args = pjp.getArgs();
        CarEditForm editForm = (CarEditForm) args[0];
        logger.info("Car {} edited", editForm.getId());

        return pjp.proceed();
    }

    @Around("carModelEdit()")
    public Object aroundCarModelEdit(ProceedingJoinPoint pjp) throws Throwable {
        Object[] args = pjp.getArgs();
        CarModelEditForm editForm = (CarModelEditForm) args[0];
        logger.info("Car Model {} edited", editForm.getId());

        return pjp.proceed();
    }
}
