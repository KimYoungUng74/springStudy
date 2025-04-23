package hello.core.lifecyle;

import org.junit.jupiter.api.Test;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

public class BeanLifeCycleTest {
    @Test
    public void lifeCycleTest() {
        ConfigurableApplicationContext ac = new AnnotationConfigApplicationContext(LifeCycleConfig.class);
        NetworkClient client = ac.getBean(NetworkClient.class);
        ac.close(); //  @PreDestroy 이거 쓰기위해서로 추측됨
    }

    @Configuration
    static class LifeCycleConfig {

        // destoryMethod는 기본적으로 추론으로 정의 되어있어서 지정해주지 않으면 자동으로 close, shutdown 등을 호출한다.
        @Bean
        public NetworkClient networkClient() {
            NetworkClient networkClient = new NetworkClient();
            networkClient.setUrl("http://hero-study:8080");
            return networkClient;
        }
    }

}
