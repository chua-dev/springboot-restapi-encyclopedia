package com.javaspring.springbootrestapi.encyclopedia.bean;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@Builder
@NoArgsConstructor
public class Student {
    private int id;
    private String firstName;
    private String lastName;
}
