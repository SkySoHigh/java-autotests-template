package org.jat.api.utils;

import io.qameta.allure.Allure;
import io.qameta.allure.AllureLifecycle;
import io.qameta.allure.model.Status;
import io.qameta.allure.model.StepResult;
import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.filter.FilterContext;
import io.restassured.response.Response;
import io.restassured.specification.FilterableRequestSpecification;
import io.restassured.specification.FilterableResponseSpecification;

import java.util.UUID;

/**
 * RestAssured extension, which beautifies http requests output in allure reports
 */
public class RestToAllureBeautifier extends AllureRestAssured {
    public RestToAllureBeautifier() {
    }

    public Response filter(FilterableRequestSpecification requestSpec, FilterableResponseSpecification responseSpec, FilterContext filterContext) {
        AllureLifecycle lifecycle = Allure.getLifecycle();
        lifecycle.startStep(UUID.randomUUID().toString(), (new StepResult()).setStatus(Status.PASSED).setName(String.format("%s: %s", requestSpec.getMethod(), requestSpec.getURI())));

        Response response;
        try {
            response = super.filter(requestSpec, responseSpec, filterContext);
        } finally {
            lifecycle.stopStep();
        }

        return response;
    }
}