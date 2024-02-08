package com.example.SpringbootCRUD.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name="Register")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name="F_name")
    private String name;
    @Column(name="email_id")
    private String emailId;
    @Column(name="DOB")
    private String DOB;

}
