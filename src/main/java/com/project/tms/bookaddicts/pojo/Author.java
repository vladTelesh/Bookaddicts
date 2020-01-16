package com.project.tms.bookaddicts.pojo;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
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
public class Author implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "name")
    private String nameAuthor;
    private String surname;
    private String patronymic;
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date birthday;
    @OneToMany(mappedBy = "author",cascade = CascadeType.ALL,
            orphanRemoval = true,fetch = FetchType.EAGER)
    private List<Book> books;

}
