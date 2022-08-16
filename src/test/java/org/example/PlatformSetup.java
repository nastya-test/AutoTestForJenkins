package org.example;

public class PlatformSetup {

    private static ThreadLocal<String> platform = new ThreadLocal<>();

    public static void setPlatform(String value) {
        platform.set(value);
    }

    public static String isPlatform() {
        return platform.get();
    }
}
