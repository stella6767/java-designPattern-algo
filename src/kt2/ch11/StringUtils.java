package kt2.ch11;

/**
 * 자바에서 유틸성 코드를 만들 때,
 * abstract class(상속 금지) + private constuctor를 사용해 인스턴스화를 막는 예시
 *
 */

public abstract class StringUtils {
    private StringUtils() {
    }

    public static final boolean isDirectoryPath(String path) {
        return path.endsWith("/");
    }
}
