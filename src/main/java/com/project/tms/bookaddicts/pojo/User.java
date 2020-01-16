package com.project.tms.bookaddicts.pojo;

import lombok.Data;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.*;


@Data
@Entity
public class User implements UserDetails {

    private static final long serialVersionUID = -4893961412599713984L;

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
    @Fetch(value = FetchMode.SUBSELECT)
    private List<Comment> comments;
    @OneToMany(mappedBy = "user_book",fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    private List<DetailsInfo> books;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.emptyList();
    }

    @Override
    public String getUsername() {
        return this.getEmail();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
