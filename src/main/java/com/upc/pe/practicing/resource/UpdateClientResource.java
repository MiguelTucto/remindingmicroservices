package com.upc.pe.practicing.resource;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
public class UpdateClientResource {
    private Long id;

    @NotNull
    @NotBlank
    @Size(max = 10)
    private String name;

    @NotNull
    @NotBlank
    @Size(max = 10)
    private String lastName;

    @NotNull
    @NotBlank
    @Size(max = 50)
    private String address;

    @NotNull
    @NotBlank
    @Size(max = 10)
    private int phone;

    @NotNull
    @NotBlank
    @Size(max = 3)
    private int age;

    @NotNull
    @NotBlank
    @Size(max = 50)
    private String date;

    @NotNull
    @NotBlank
    @Size(max = 50)
    private String event;
}
