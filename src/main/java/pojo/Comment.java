package pojo;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
public class Comment implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String text;
    private int rating;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_book")
    private Book book;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_user")
    private User user;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Comment comment = (Comment) o;
        return id == comment.id &&
                rating == comment.rating &&
                text.equals(comment.text) &&
                book.equals(comment.book) &&
                user.equals(comment.user);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, text, rating, book, user);
    }
}
