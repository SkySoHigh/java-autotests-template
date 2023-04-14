package org.jat.api;

import io.restassured.specification.RequestSpecification;
import org.jat.api.controllers.BaseRawController;
import org.jat.api.controllers.BaseSchemaController;


/**
 * ApiClient class to provide access to all controllers and corresponding methods.
 */
public class ApiClient {
    private final RequestSpecification requestSpecification;

    // Base Controllers
    public BaseSchemaController baseSchemaController;
    public BaseRawController baseRawController;

    // Custom Controllers should be put below
    // ...


    public ApiClient(RequestSpecification requestSpecification) {
        this.requestSpecification = requestSpecification;
        initializeControllers();
    }


    private void initializeControllers() {
        // Default controllers
        this.baseRawController = new BaseRawController(this.requestSpecification);
        this.baseSchemaController = new BaseSchemaController(this.requestSpecification);
    }


}




