package aspects;

import annotations.LogInvocation;
import org.apache.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.omg.SendingContext.RunTime;


/**
 * Created by fjiang on 1/25/17.
 */
@Aspect
public class LoggingAspect {
    private static final Logger LOG = Logger.getLogger(LoggingAspect.class);

    @Around("execution(@annotations.LogInvocation * *.*(..))")
    public Object loggingMethod(ProceedingJoinPoint joinPoint) throws Throwable {
        Signature signature = joinPoint.getSignature();

        if (signature instanceof MethodSignature) {
            LogInvocation.LogLevel logLevel = ((MethodSignature) signature).getMethod().getAnnotation(LogInvocation.class).value();
            Logger methodLogger = getLogger(joinPoint);
            if (isLogLevelEnabled(methodLogger, logLevel)) {
                logEnteringMethod(methodLogger, logLevel, joinPoint);

            } else {
                LOG.error("The logLevel in the annotation is lower than in the log4j.properties!");
            }

            return joinPoint.proceed();
        }
        else{
            LOG.error("The annotation is wrongly located!");
            throw new RuntimeException("Error");
        }
    }

    private boolean isLogLevelEnabled(Logger methodLogger, LogInvocation.LogLevel logLevel) {
        switch (logLevel) {
            case TRACE:
               return methodLogger.isTraceEnabled();
            case DEBUG:
                return methodLogger.isDebugEnabled();
            case INFO:
                return methodLogger.isInfoEnabled();
            case WARNING:
            case ERROR:
            case FATAL:
                return true;
            default:
                return false;
        }
    }

    private void logEnteringMethod(Logger methodLogger, LogInvocation.LogLevel logLevel, ProceedingJoinPoint joinPoint) {
        methodLogger.debug("Entering the method" + ((MethodSignature)joinPoint.getSignature()).getMethod().getName());
    }

    private Logger getLogger(ProceedingJoinPoint joinPoint) {
        return Logger.getLogger(joinPoint.getSignature().getDeclaringType());
    }

}
