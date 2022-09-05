package com.example.decision;

import java.sql.Timestamp;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Decision {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String createdBy;
    private String title;
    private String content;
    private String type;
    private Timestamp dateCreated;

    public Decision() {
        this.dateCreated = new Timestamp(new Date().getTime());
    }

    public Decision(int id, String createdBy, String title, String content, String type) {
        this.id = id;
        this.createdBy = createdBy;
        this.title = title;
        this.content = content;
        this.type = type;
        this.dateCreated = new Timestamp(new Date().getTime());
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Timestamp getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Timestamp dateCreated) {
        this.dateCreated = dateCreated;
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + ", created by " + this.getCreatedBy() + ", title: " + this.getTitle() + ", type: " + this.getType() + ". ";
    }
}