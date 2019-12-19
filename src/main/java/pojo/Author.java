package pojo;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Entity
public class Author implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String surname;
    @Temporal(TemporalType.DATE)
    private Date birthday;
    @OneToMany(mappedBy = "author",cascade = CascadeType.ALL,
            orphanRemoval = true,fetch = FetchType.EAGER)
    private List<Book> books;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Author author = (Author) o;
        return id == author.id &&
                name.equals(author.name) &&
                surname.equals(author.surname) &&
                birthday.equals(author.birthday) &&
                books.equals(author.books);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, surname, birthday, books);
    }
}
