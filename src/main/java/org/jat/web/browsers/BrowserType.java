package org.jat.web.browsers;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.safari.SafariOptions;

import java.util.HashMap;
import java.util.Map;

@AllArgsConstructor
public enum BrowserType {

    FIREFOX("firefox", ffSpecificOptions()),
    CHROME("chrome", chromeSpecificOptions()),
    SAFARI("safari", safariSpecificOptions());

    @Getter
    final String name;

    @Getter
    final MutableCapabilities capabilities;

    private static MutableCapabilities chromeSpecificOptions() {
        ChromeOptions options = new ChromeOptions();
        Map<String, Object> prefs = new HashMap<>();
        prefs.put("profile.default_content_setting_values.notifications", 1); //1-Allow, 2-Block, 0-default
        prefs.put("profile.managed_default_content_settings.media_stream", 1);
        prefs.put("credentials_enable_service", false);
        prefs.put("profile.password_manager_enabled", false);
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("--disable-extensions");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("test-type");
        options.setExperimentalOption("prefs", prefs);
        options.setAcceptInsecureCerts(true);
        return options;
    }

    private static MutableCapabilities ffSpecificOptions() {
        FirefoxOptions options = new FirefoxOptions();
        options.setAcceptInsecureCerts(true);
        return options;
    }


    private static MutableCapabilities safariSpecificOptions() {
        SafariOptions options = new SafariOptions();
        return options;
    }


}
