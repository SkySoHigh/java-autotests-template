package org.jat.api.schemaBuilders;

import org.jat.api.schemas.CharacterSchema;

/**
 * Builder of CharacterSchema objects with predetermined or random data.
 * Adds an abstraction layer in order not to call builders directly from the test.
 */
public class CharacterSchemaBuilder {

    public static CharacterSchema buildWithEmptyData() {
        return CharacterSchema.builder().build();
    }

    /* All specific builders for this schema should be placed below to the screen, and it is amazing
     * Examples
     * public static CharacterSchema buildWithRandomData(){};
     * public static CharacterSchema buildWithRandomDataAndExactSpecie(String species){};
     * ...
     */
}
