package features

import com.chaoscorp.chaosServer.common.GoogleTokenVerifier
import com.chaoscorp.chaosServer.exception.ForbiddenException
import org.aspectj.lang.ProceedingJoinPoint
import org.aspectj.lang.annotation.Around
import org.aspectj.lang.annotation.Aspect
import org.springframework.context.annotation.Profile
import org.springframework.stereotype.Component
import org.springframework.web.context.request.RequestContextHolder
import org.springframework.web.context.request.ServletRequestAttributes

@Aspect
@Component
@Profile("unittesting")
class AuthorizeAspect(val tokenVerifier : GoogleTokenVerifier) {

    @Throws(Throwable ::class)
    @Around("@annotation(Authorize)")
    fun authorize(joinPoint : ProceedingJoinPoint) : Any?  {
        return joinPoint.proceed();
    }

}