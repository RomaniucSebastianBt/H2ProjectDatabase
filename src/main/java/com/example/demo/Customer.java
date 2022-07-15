package com.example.demo;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


import lombok.*;

@Data
@Entity
@Table(name="CUSTOMER")
@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor

public class Customer {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)

    @Column (name = "id",updatable = false ,nullable = false )
    private long id;
    @Column (name="name")
    private String name;
    @Column(name="age")
    private int age;
    @Column(name="location")
    private String location;

}
