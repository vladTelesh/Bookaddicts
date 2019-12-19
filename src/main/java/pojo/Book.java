package pojo;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Objects;

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

    public int getNumberOfPages() {
        return numberOfPages;
    }

    public void setNumberOfPages(int numberOfPages) {
        this.numberOfPages = numberOfPages;
    }

    public Date getPublicationYear() {
        return publicationYear;
    }

    public void setPublicationYear(Date publicationYear) {
        this.publicationYear = publicationYear;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return id == book.id &&
                numberOfPages == book.numberOfPages &&
                name.equals(book.name) &&
                publicationYear.equals(book.publicationYear) &&
                author.equals(book.author) &&
                comments.equals(book.comments);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, numberOfPages, publicationYear, author, comments);
    }
}
