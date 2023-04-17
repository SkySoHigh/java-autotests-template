package org.jat.web.browsers;

import com.codeborne.selenide.Configuration;
import io.restassured.RestAssured;
import org.jat.configs.providers.TestConfigProvider;

import java.util.HashMap;
import java.util.Map;

public class BrowserConfigProvider {

    /**
     * Sets default selenide options based on project configuration (.env)
     */
    private static void setSelenideConfigs() {
        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
        Configuration.browserSize = TestConfigProvider.BrowserProperties.getWindowSize();
        Configuration.reportsFolder = TestConfigProvider.BrowserProperties.getReportsFolder();
        Configuration.downloadsFolder = TestConfigProvider.BrowserProperties.getDownloadsFolder();
    }

    /**
     * Sets selenoid options to selenide config based on project configuration (.env)
     */
    private static void setSelenoidConfigs() {
        Configuration.remote = TestConfigProvider.SelenoidProperties.getSelenoidUrl() + "/wd/hub";
        Map<String, Object> options = new HashMap<>();
        options.put("enableVNC", TestConfigProvider.SelenoidProperties.isRecordEnabled());
        options.put("enableVideo", TestConfigProvider.SelenoidProperties.isRecordEnabled());
        options.put("enableLog", TestConfigProvider.SelenoidProperties.isLoggingEnabled());
        options.put("name", TestConfigProvider.AppProperties.getName());
        Configuration.browserCapabilities.setCapability("selenoid:options", options);
    }


    /**
     * Creates selenide configs and adds selenoid options if enabled.
     *
     * @param browserEnum
     */
    public static void prepareBrowserConfig(BrowserEnum browserEnum) {
        setSelenideConfigs();

        Configuration.browser = browserEnum.getType().getName();
        Configuration.browserCapabilities = browserEnum.getType().getCapabilities();

        if (TestConfigProvider.SelenoidProperties.isSelenoidEnabled()) {
            if (browserEnum.getVersion() == null) {
                throw new IllegalArgumentException("Browser configuration error. " +
                        "Unable to use browser without version on selenoid. " +
                        "Please, look at the configuration of the .env file and make sure, that browser.name " +
                        "is one of the specified in the web.browsers.BrowserEnum beside those with 'LOCAL_' prefix");
            }
            setSelenoidConfigs();
            Configuration.browserVersion = browserEnum.getVersion();
        }

    }


}
