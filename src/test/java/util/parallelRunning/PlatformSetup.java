package util.parallelRunning;

public class PlatformSetup {
    private static ThreadLocal<String> platform = new ThreadLocal<>();

    public static void setPlatform(String value) {
        platform.set(value);
    }

    public static String getPlatform() {
        return platform.get();
    }
}
