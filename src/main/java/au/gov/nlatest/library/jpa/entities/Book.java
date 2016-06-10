package au.gov.nlatest.library.jpa.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * JPA Entity Book
 * 
 * @author hiten
 * 
 */
@Entity (name = "book")
public class Book {
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private long id;
	
	@Column
    private String title;
	
	@Column
    private String author;
	
	@Column
    private String isbn;
	
	@ManyToOne
	@JoinColumn(name="person_id")
	private Person person;
	

    protected Book() {}

    public Book(String title, String auther, String isbn) {
        this.title = title;
        this.author = auther;
        this.isbn = isbn;
    }

  
    
    /*
     * accessors and mutators
     */

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}
    
	@Override
	public String toString() {
		return String.format("Book[id=%d, title='%s', auther='%s', isbn='%s']",
				id, title, author, isbn);
	}

}
