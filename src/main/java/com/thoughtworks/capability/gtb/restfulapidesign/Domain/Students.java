package com.thoughtworks.capability.gtb.restfulapidesign.Domain;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonSerialize
public class Students {
    private int id;
    private String name;
    private Gender gender;
    private String note;

    public enum Gender {
        MALE,
        FEMALE;
    }
}
