package hello.core.common;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.UUID;

@Component
@Scope(value = "session", proxyMode = ScopedProxyMode.TARGET_CLASS) // proxyMode를 TARGET_CLASS로 하면
public class MyLogger {
    private String uuid;
    private String requestURL;

    public void setRequestURL(String requestURL) {
        this.requestURL = requestURL;
    }

    public void log(String message) {
        String format = String.format("[%s][%s]%s", uuid, requestURL, message);
        System.out.println(format);
    }

    @PostConstruct
    public void init() {
        uuid = UUID.randomUUID().toString();
        System.out.println(String.format("[%s]request scope bean 생성:", uuid) + this);
    }

    @PreDestroy
    public void destroy() {
        System.out.println(String.format("[%s]request scope bean 종료:", uuid) + this);
    }
}
