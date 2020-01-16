package com.project.tms.bookaddicts.pojo;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Objects;


@Entity
@Getter
@Setter
@EqualsAndHashCode
public class Book implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    @Column(name = "number_of_pages")
    private int numberOfPages;
    @Column(name = "publication_year")
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date publicationYear;
    private String image;
    @Column(name = "link_to_source")
    private String linkToSource;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_author")
    private Author author;
    @OneToMany(mappedBy = "book",fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    private List<Comment> comments;
    @OneToMany(mappedBy = "book_user",fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @Fetch(value = FetchMode.SUBSELECT)
    private List<DetailsInfo> users;

}
