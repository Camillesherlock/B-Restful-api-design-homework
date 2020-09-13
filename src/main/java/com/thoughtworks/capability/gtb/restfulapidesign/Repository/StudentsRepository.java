package com.thoughtworks.capability.gtb.restfulapidesign.Repository;

import com.thoughtworks.capability.gtb.restfulapidesign.Domain.Students;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentsRepository {
 Students findByName(String name);
}
