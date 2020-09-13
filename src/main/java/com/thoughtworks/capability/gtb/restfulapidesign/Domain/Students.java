package com.thoughtworks.capability.gtb.restfulapidesign.Domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Students {
    int id;
    String name;
    Enum gender;
    String note;
}
