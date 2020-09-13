package com.thoughtworks.capability.gtb.restfulapidesign.Domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class StudentsGroup {
    private int groupId;
    private String groupName;
    private String groupNote;
    private List<Students> students;
}
