package org.jat.web.browsers;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public enum BrowserEnum {
    // Local browsers (version is not required if there is only one version of each installed)
    LOCAL_CHROME(BrowserType.CHROME, null),
    LOCAL_FIREFOX(BrowserType.FIREFOX, null),
    LOCAL_SAFARI(BrowserType.SAFARI, null),

    // Selenoid browsers
    CHROME112(BrowserType.CHROME, "112.0");

    @Getter
    final BrowserType type;
    @Getter
    final String version;

    /**
     * Creates BrowserEnum from browserName passed as string
     * @param browserName Browser name (one of the specified in enum)
     * @return BrowserEnum
     */
    public static BrowserEnum parse(String browserName) {
        try {
            return BrowserEnum.valueOf(browserName);
        } catch (IllegalArgumentException exception) {
            throw new IllegalArgumentException("Unknown value of browser.name in .env. " +
                    "Please use one of the specified in web.browsers.BrowserEnum.");
        }
    }
}
