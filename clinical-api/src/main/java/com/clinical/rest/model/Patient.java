package com.clinical.rest.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "patient")
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String firstName;
    private String lastName;

    public List<ClinicalData> getClinicalDataList() {
        return clinicalDataList;
    }

    public void setClinicalDataList(List<ClinicalData> clinicalDataList) {
        this.clinicalDataList = clinicalDataList;
    }

    private int age;

    @OneToMany(cascade = CascadeType.ALL , mappedBy = "patient" , fetch = FetchType.EAGER)
    private List<ClinicalData> clinicalDataList;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
