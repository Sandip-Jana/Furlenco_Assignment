package com.sandipjana.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Optional;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "student")
public class Student {


  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String name;
  @Column(name="class")
  private Integer grade;
  private Boolean active;

  @Column(name="admissionyear")
  @Temporal(TemporalType.DATE)
  private Date admissionYear;


  public Student() {
  }

  public Student(Long id, String name, int grade, boolean active, Date admissionyear) {
    this.id = id;
    this.name = name;
    this.grade = grade;
    this.active = active;
    this.admissionYear = admissionyear;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getGrade() {
    return grade;
  }

  public void setGrade(int grade) {
    this.grade = grade;
  }

  public boolean isActive() {
    return active;
  }

  public void setActive(boolean active) {
    this.active = active;
  }

  public Date getadmissionyear() {
    return admissionYear;
  }

  public void setadmissionyear(Date admissionyear) {
    this.admissionYear = admissionyear;
  }

}
