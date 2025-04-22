package hello.core.singleton;

public class SingletonService {
    private static final SingletonService instance = new SingletonService();

    // 임의로 new SingletonService()로 생성되는걸 막기위해 정의
    private SingletonService() {
    }

    public static SingletonService getInstance() {
        return instance;
    }

    public void logic() {
        System.out.println("싱글톤 객체 로직 호출");
    }
}
