package com.chaoscorp.chaosServer.aop

import com.chaoscorp.chaosServer.common.GoogleTokenVerifier
import com.chaoscorp.chaosServer.exception.ForbiddenException
import org.aspectj.lang.ProceedingJoinPoint
import org.aspectj.lang.annotation.Around
import org.aspectj.lang.annotation.Aspect
import org.springframework.stereotype.Component
import org.springframework.web.context.request.RequestContextHolder
import org.springframework.web.context.request.ServletRequestAttributes

@Aspect
@Component
class AuthorizeAspect(val tokenVerifier : GoogleTokenVerifier) {

    @Throws(Throwable ::class)
    @Around("@annotation(Authorize)")
    fun authorize(joinPoint : ProceedingJoinPoint) : Any  {

        val googleToken =
            (RequestContextHolder.getRequestAttributes() as ServletRequestAttributes)
                .request.getHeader("idGoogleToken")

        if (googleToken!=null && tokenVerifier.verify(googleToken)) {
            return joinPoint.proceed();
        } else {
            throw ForbiddenException("Invalid Google Token")
        }

    }

}