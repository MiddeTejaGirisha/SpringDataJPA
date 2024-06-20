package com.example.Mapping.Model;

import com.example.Mapping.Auditing.Auditable;
import jakarta.persistence.*;

@Entity
@Table(name = "comments")
public class Comment extends Auditable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String text;

    public Comment() {

    }
    public Comment(String text) {
        super();
        this.text = text;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
