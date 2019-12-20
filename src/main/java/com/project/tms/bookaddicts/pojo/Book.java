package com.project.tms.bookaddicts.pojo;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Data
@Entity
public class Book implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    @Column(name = "number_of_pages")
    private int numberOfPages;
    @Column(name = "publication_year")
    @Temporal(TemporalType.DATE)
    private Date publicationYear;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_author")
    private Author author;
    @OneToMany(mappedBy = "book",fetch = FetchType.EAGER)
    private List<Comment> comments;

}
