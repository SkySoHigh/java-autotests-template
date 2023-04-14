package org.jat.core;

public enum Endpoints {
    MAIN(""),
    API("api"),
    CHARACTER(concat(MAIN.getText(), API.getText(), "character"));

    private final String text;

    Endpoints(String text) {
        this.text = text;
    }

    public static String concat(String... s) {
        return String.join("/", s);
    }

    public String getText() {
        return this.text;
    }
}
