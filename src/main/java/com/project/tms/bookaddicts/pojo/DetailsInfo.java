package com.project.tms.bookaddicts.pojo;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "user_book")
public class DetailsInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private int rating;
    @ManyToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @JoinColumn(name = "id_user")
    private User user_book;
    @ManyToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @JoinColumn(name = "id_book")
    private Book book_user;
}
