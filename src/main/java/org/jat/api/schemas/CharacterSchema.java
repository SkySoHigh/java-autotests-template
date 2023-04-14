package org.jat.api.schemas;

import lombok.*;
import org.jat.core.Endpoints;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class CharacterSchema extends BaseSchema {
    private int id;
    private String name;
    private String status;
    private String species;
    private String type;
    private String gender;
    private Origin origin;
    private Location location;
    private String image;
    private String[] episode;
    private String url;
    private String created;

    @Override
    public String getEndpoint() {
        return Endpoints.CHARACTER.getText();
    }

}

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
class Origin {
    private String name;
    private String url;
}

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
class Location {
    private String name;
    private String url;
}