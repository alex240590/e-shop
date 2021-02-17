package ru.gb.eshop.aop;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.gb.eshop.services.CartService;

@Aspect
@Component
public class AopLogging {
    private static final Logger logger = LoggerFactory.getLogger(AopLogging.class);
    private CartService cartService;

    @Autowired
    public void setCartService(CartService cartService) {
        this.cartService = cartService;
    }

    @Before("execution(public void ru.gb.eshop.services.CartService.addById(..))")
    public void beforeAddByIdInCartServiceClass() {
        logger.info("В корзину будет добавлен новый продукт");
    }

    @After("execution(public void ru.gb.eshop.services.CartService.addById(..))")
    public void afterAddByIdInCartServiceClass() {
        logger.info("В корзину добавлен новый продукт");
        // пересчитывается стоимость корзины
        cartService.recalculate();
    }


    /*    @Around("execution(public * ru.gb.eshop.services.CartService.*(..))")
    public void methodProfiling(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        System.out.println("start profiling");
        long begin = System.currentTimeMillis();
        proceedingJoinPoint.proceed();
        long end = System.currentTimeMillis();
        long duration = end - begin;
        System.out.println((MethodSignature) proceedingJoinPoint.getSignature() + " duration: " + duration);
        System.out.println("end profiling");
    }*/
}



