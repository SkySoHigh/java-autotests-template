package org.jat.configs.providers;

import io.github.cdimascio.dotenv.Dotenv;
import lombok.Getter;

public class TestConfigProvider {
    public static final Dotenv dotenv = Dotenv.load();

    public static class AppProperties {
        @Getter
        private static final String name = dotenv.get("app.name", "");
        @Getter
        private static final String url = dotenv.get("app.url", "");
        @Getter
        private static final String authUsername = dotenv.get("app.auth.username", "");
        @Getter
        private static final String authPassword = dotenv.get("app.auth.password", "");
    }

    public static class SelenoidProperties {

        private static final boolean selenoidEnabled = Boolean.parseBoolean(dotenv.get("selenoid.enabled", "false"));
        @Getter
        private static final boolean recordEnabled = Boolean.parseBoolean(dotenv.get("selenoid.recordEnabled", "false"));
        @Getter
        private static final boolean loggingEnabled = Boolean.parseBoolean(dotenv.get("selenoid.loggingEnabled", "false"));
        @Getter
        private static final String selenoidUrl = dotenv.get("selenoid.url", "http://192.168.111.3:4444");
    }

    public static class BrowserProperties {
        @Getter
        private static final String windowSize = dotenv.get("browser.windowSize", "1920x1070");
        @Getter
        private static final String reportsFolder = dotenv.get("browser.reportsFolder", "build/reports");
        @Getter
        private static final String downloadsFolder = dotenv.get("browser.downloadsFolder", "build/downloads");
        @Getter
        private static final String name = dotenv.get("browser.name", "CHROME106");
    }

    public static class YoutrackProperties {
        @Getter
        private static final String youtrackUrl = dotenv.get("youtrack.url", "");
        @Getter
        private static final String youtrackToken = dotenv.get("youtrack.token", "");
    }

    public static class TestrailProperties {
        @Getter
        private static final String testrailEmail = dotenv.get("testrail.email", "");
        @Getter
        private static final String testrailKey = dotenv.get("testrail.key", "");
        @Getter
        private static final String testrailPlanId = dotenv.get("testrail.planId", "");
    }

}
