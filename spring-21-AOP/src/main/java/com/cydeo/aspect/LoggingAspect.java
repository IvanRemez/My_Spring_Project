package com.cydeo.aspect;

import com.cydeo.dto.CourseDTO;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.List;

@Aspect
@Component
public class LoggingAspect {

// l4j = Logging For Java
// slf4j = Simple Logging Facet For Java

    Logger logger = LoggerFactory.getLogger(LoggingAspect.class);

//    @Pointcut("execution(* com.cydeo.controller.CourseController.*(..))")
//    public void courseControllerMethodsPointcut() {}
//
//    @Before("courseControllerMethodsPointcut()")
//    public void log() {
//        logger.info("Info log.............");
//    }

//    @Before("execution(* com.cydeo.controller.CourseController.*(..))")
//    public void log() {
//        logger.info("Info log.............");
//    }

//    @Pointcut("execution(* com.cydeo.repository.CourseRepository.findById(*))")
//    public void courseRepositoryFindByIdPC() {}
//
//    @Before("courseRepositoryFindByIdPC()")
//    public void beforeCourseRepositoryFindById(JoinPoint joinPoint) {
//
//        logger.info("Before -> Method: {}, Arguments: {}, Target: {}",
//                joinPoint.getSignature(), joinPoint.getArgs(), joinPoint.getTarget());
//        // ^^ these 3 methods will replace the 3 {} braces inside the logger.info String
//    }

//    @Pointcut("within(com.cydeo.controller..*)")
//    public void anyControllerOperation() {}
//
//    @Pointcut("@within(org.springframework.stereotype.Service)")
//    public void anyServiceOperation() {}
//
//    @Before("anyControllerOperation() || anyServiceOperation()")
//    public void beforeControllerOrServiceAdvice(JoinPoint joinPoint) {
//
//        logger.info("Before -> Method: {}, Arguments: {}, Target: {}",
//                joinPoint.getSignature(), joinPoint.getArgs(), joinPoint.getTarget());
//    }

//    @Pointcut("@annotation(org.springframework.web.bind.annotation.DeleteMapping)")
//    public void anyDeleteControllerOperation() {}
//
//    @Before("anyDeleteControllerOperation()")
//    public void beforeDeleteMappingAnnotation(JoinPoint joinPoint) {
//
//        logger.info("Before -> Method: {}, Arguments: {}, Target: {}",
//                joinPoint.getSignature(), joinPoint.getArgs(), joinPoint.getTarget());
//    }

    // Custom Annotation:
//    @Pointcut("@annotation(com.cydeo.annotation.LoggingAnnotation)")
//    public void loggingAnnotationPC() {}
//
//    @Before("loggingAnnotationPC()")
//    public void beforeLoggingAnnotation(JoinPoint joinPoint) {
//
//        logger.info("Before -> Method: {}, Arguments: {}, Target: {}",
//                joinPoint.getSignature(), joinPoint.getArgs(), joinPoint.getTarget());
//    }

    @Pointcut("@annotation(org.springframework.web.bind.annotation.GetMapping)")
    public void afterReturningGetMappingAnnotation() {}

//    @AfterReturning(pointcut = "afterReturningGetMappingAnnotation()", returning = "result")
//    public void afterReturningGetMappingOperation(JoinPoint joinPoint, Object result) {
//
//        logger.info("After Returning -> Method: {}, Result: {}",
//                joinPoint.getSignature(), result.toString());
//    }

//    @AfterReturning(pointcut = "afterReturningGetMappingAnnotation()", returning = "results")
//    public void afterReturningGetMappingOperation(JoinPoint joinPoint, List<CourseDTO> results) {
//
//        logger.info("After Returning -> Method: {}, Results: {}",
//                joinPoint.getSignature(), results.toString());
//    }
    // CourseDTO -> Object = casting works
    // List<CourseDTO> -> List<Object> = casting does NOT work due to Generics rules

    @AfterThrowing(pointcut = "afterReturningGetMappingAnnotation()", throwing = "exception")
    public void afterThrowingGetMappingOperation(JoinPoint joinPoint, RuntimeException exception) {

        logger.error("After Throwing -> Method: {}, Exception: {}",
                joinPoint.getSignature().toShortString(), exception.getMessage());
    }
}
