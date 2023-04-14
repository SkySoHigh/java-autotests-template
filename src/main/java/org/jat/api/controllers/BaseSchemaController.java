package org.jat.api.controllers;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.jat.api.schemas.BaseSchema;

import java.util.List;


/**
 * Controller, which contains default methods for http requests returning a Schema obhect
 */
public class BaseSchemaController {

    private final RequestSpecification requestSpecification;

    public BaseSchemaController(RequestSpecification requestSpecification) {
        this.requestSpecification = requestSpecification;
    }

    public <T extends BaseSchema> BaseSchema post(T model) {
        return RestAssured.given()
                .spec(this.requestSpecification)
                .when()
                .body(model)
                .post(model.getEndpoint())
                .as(model.getClass());
    }


    public <T extends BaseSchema> BaseSchema put(T model) {
        return RestAssured.given()
                .spec(this.requestSpecification)
                .when()
                .body(model)
                .put(model.getEndpoint() + "/" + model.getId())
                .as(model.getClass());
    }

    public <T extends BaseSchema> BaseSchema getById(T model) {
        return RestAssured.given()
                .spec(this.requestSpecification)
                .when()
                .get(model.getEndpoint() + "/" + model.getId())
                .as(model.getClass());
    }

    public <T extends BaseSchema> Response delete(T model) {
        return RestAssured.given()
                .spec(this.requestSpecification)
                .when()
                .delete(model.getEndpoint() + "/" + model.getId());
    }

    public <T extends BaseSchema> List<T> getAll(Class<T> aClass, String endpoint) {
        return RestAssured.given()
                .spec(this.requestSpecification)
                .when()
                .get(endpoint)
                .jsonPath()
                .getList("", aClass);
    }
}