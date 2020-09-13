package com.thoughtworks.capability.gtb.restfulapidesign.Domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Students {
    private int id;
    private String name;
    private String gender;
    private String note;

    public enum Gender {
        MALE, FEMALE;
    }
}
