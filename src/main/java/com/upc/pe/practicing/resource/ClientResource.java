package com.upc.pe.practicing.resource;

import lombok.*;

@Getter
@Setter
@With
@NoArgsConstructor
@AllArgsConstructor
public class ClientResource {
    private Long id;
    private String name;
    private String lastName;
    private String address;
    private int phone;
    private int age;
    private String date;
    private String event;
}
