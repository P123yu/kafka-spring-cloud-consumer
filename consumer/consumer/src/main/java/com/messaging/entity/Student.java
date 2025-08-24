package com.messaging.entity;

import lombok.*;
import org.springframework.context.annotation.Configuration;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Configuration
@ToString
public class Student {
    private String name;
    private String city;
    private Double marks;
}
