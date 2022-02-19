package com.volodichev.frdemo.entity;

import jakarta.persistence.*;

import java.sql.Date;
import java.util.List;

@Entity
public class Survey {
    @Id
    @GeneratedValue
    private long id;
    @Column
    private String name;
    @Column
    private Date start;
    @Column
    private Date end;
    @Column
    private String description;
    @OneToMany
    private List<Question> questions;

    public Survey(){}

    public void addQuestions(Question question){
        questions.add(question);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getStart() {
        return start;
    }

    public void setStart(Date start) {
        this.start = start;
    }

    public Date getEnd() {
        return end;
    }

    public void setEnd(Date end) {
        this.end = end;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Question> getQuestions() {
        return questions;
    }
}
