package org.jat.api.controllers;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

/**
 * Controller, which contains default methods for http requests returning a Response object
 */
public class BaseRawController {

    private final RequestSpecification requestSpecification;


    public BaseRawController(RequestSpecification requestSpecification) {
        this.requestSpecification = requestSpecification;
    }

    public RequestSpecification request() {
        return RestAssured.given().spec(this.requestSpecification);
    }

    public Response post(String endpoint, Object body) {
        RequestSpecification req = RestAssured.given().spec(this.requestSpecification);
        if (body != null) {
            req.body(body);
        }
        return req.post(endpoint)
                .then()
                .extract()
                .response();
    }

    public Response post(String endpoint) {
        return post(endpoint, null);
    }


    public Response put(String endpoint, Object body) {
        RequestSpecification req = RestAssured.given().spec(this.requestSpecification);
        if (body != null) {
            req.body(body);
        }
        return req.put(endpoint)
                .then()
                .extract()
                .response();
    }

    public Response put(String endpoint) {
        return put(endpoint, null);
    }


    public Response get(String endpoint) {
        return RestAssured.given()
                .spec(this.requestSpecification)
                .when()
                .get(endpoint)
                .then()
                .extract()
                .response();
    }


    public Response delete(String endpoint) {
        return RestAssured.given()
                .spec(this.requestSpecification)
                .when()
                .delete(endpoint)
                .then()
                .extract()
                .response();
    }

}