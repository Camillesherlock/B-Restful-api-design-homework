package com.thoughtworks.capability.gtb.restfulapidesign.Domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class StudentsGroup {
    int groupId;
    String groupName;
    String groupNote;
}
