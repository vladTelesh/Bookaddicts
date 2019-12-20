package com.project.tms.bookaddicts.pojo;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Data
@Entity
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String surname;
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date birthday;
    private String email;
    private String password;
    @Transient
    private String passwordConfirm;
    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL,orphanRemoval = true,
            fetch = FetchType.EAGER)
    private List<Comment> comments;

}
