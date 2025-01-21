package com.axisbank.limit.ratelimit;

import com.axisbank.limit.exception.RateLimitException;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

@Slf4j
@Aspect
@Component
public class RateLimitAspect {
    public static final String ERROR_MESSAGE = "To many request at endpoint %s from IP %s! Please try again after %d milliseconds!";
    private static final ConcurrentHashMap<String, AtomicInteger> requestCounts = new ConcurrentHashMap<>();

    @Value("${app.rate.limit}")
    private int rateLimit;

    @Value("${app.rate.durationinms}")
    private long rateDuration;

    /**

     * @throws RateLimitException iff rate limit for a given remote address has been exceeded
     */
    @Before("@annotation(com.axisbank.limit.ratelimit.WithRateLimitProtection)")
    public void rateLimit() {
        String clientId = getClientId();
        AtomicInteger count = requestCounts.computeIfAbsent(clientId, k -> new AtomicInteger(0));
        if (count.incrementAndGet() > rateLimit) {
            throw new RateLimitException(String.format(ERROR_MESSAGE, getURI(), clientId, rateDuration));
        }
        if (requestCounts.size() == 1) {
            resetRequestCounts();
        }

    }
    private void resetRequestCounts() {
        new Thread(() -> {
            try {
                Thread.sleep(rateDuration);
                requestCounts.clear();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }

    private String getClientId() {
        final ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
        return requestAttributes.getRequest().getRemoteAddr();
    }
    private String getURI() {
        final ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
        return requestAttributes.getRequest().getRequestURI();
    }
}
