package org.jat.api.schemas;

/**
 * Base schema which should be used by all high level schemas.
 * Could contain mandatory fields, required by all heirs
 */
public abstract class BaseSchema {

    /**
     * Abstract method to ensure getEndpoint method for each request schema.
     * Could be empty if there is no corresponding endpoint for schema.
     *
     * @return String endpoint
     */
    public abstract String getEndpoint();


    /**
     * Abstract method to ensure getId method for each request schema.
     * Could be empty if there is no id field in the schema.
     *
     * @return int id
     */
    public abstract int getId();


}
