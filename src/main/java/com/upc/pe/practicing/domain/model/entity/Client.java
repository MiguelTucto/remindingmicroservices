package com.upc.pe.practicing.domain.model.entity;

import com.upc.pe.shared.domain.model.AuditModel;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
@With
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "clients")
public class Client extends AuditModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @NotBlank
    @Size(max = 10)
    @Column(unique = true)
    private String name;

    @NotNull
    @NotBlank
    @Size(max = 10)
    @Column(unique = true)
    private String lastName;

    @NotNull
    @NotBlank
    @Size(max = 50)
    @Column(unique = true)
    private String address;

    @NotNull
    @NotBlank
    @Size(max = 10)
    @Column(unique = true)
    private int phone;

    @NotNull
    @NotBlank
    @Size(max = 3)
    @Column(unique = true)
    private int age;

    @NotNull
    @NotBlank
    @Size(max = 50)
    @Column(unique = true)
    private String date;

    @NotNull
    @NotBlank
    @Size(max = 50)
    @Column(unique = true)
    private String event;
}
