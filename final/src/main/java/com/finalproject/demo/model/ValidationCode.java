package com.finalproject.demo.model;

import javax.persistence.*;

@Entity
@Table
public class ValidationCode {
    @Id
    @Column(name = "code_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "code_ticket")
    private String code;
    @Column(name = "code_validity")
    private String validated;

    public ValidationCode(){

    }

    public ValidationCode(String code, String validated) {
        this.code = code;
        this.validated=validated;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getValidated() {
        return validated;
    }

    public void setValidated(String validated) {
        this.validated = validated;
    }
}
