package org.jat.api;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import lombok.Getter;
import org.jat.api.utils.RestToAllureBeautifier;
import org.jat.configs.providers.TestConfigProvider;

/**
 * Contains all api settings required by ApiClient
 */
public class ApiSettings {

    @Getter
    public static final RequestSpecification requestSpecification = buildRequestSpecification();

    private static RequestSpecification buildRequestSpecification() {
        RequestSpecBuilder tmp = new RequestSpecBuilder()
                .setBaseUri(TestConfigProvider.AppProperties.getUrl())
                .setContentType(ContentType.JSON)
                .setAccept(ContentType.JSON)
                .log(LogDetail.ALL)
                .addFilter(new RestToAllureBeautifier());

        return tmp.build();
    }
}
