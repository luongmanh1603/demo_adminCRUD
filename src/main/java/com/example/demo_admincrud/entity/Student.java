package com.example.demo_admincrud.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "student")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
  private Integer id;
    @Column(name = "name")
  private String name;
    @Column(name = "age")

  private Integer age;
    @ManyToOne
    @JoinColumn(name = "id_class", nullable = false)
    private ClassRoom id_class;

public Student() {}

    public Student(Integer id, String name, Integer age, ClassRoom id_class) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.id_class = id_class;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public ClassRoom getId_class() {
        return id_class;
    }

    public void setId_class(ClassRoom id_class) {
        this.id_class = id_class;
    }
}
