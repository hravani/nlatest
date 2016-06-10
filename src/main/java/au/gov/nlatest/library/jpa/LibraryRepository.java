package au.gov.nlatest.library.jpa;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import au.gov.nlatest.library.jpa.entities.Book;
import au.gov.nlatest.library.jpa.entities.Person;

/**
 * Repository class (Data Access Layer)
 * @author hiten
 *
 */
public interface LibraryRepository extends CrudRepository<Person, Long> {
	
	/**
	 * Find books by Person ID
	 * @param id Person ID
	 * @return {@link Person}  
	 */
	@Query("select p from person p left join p.books where p.id =:id")
	public Person findBooksByPersonId(@Param("id") Long id);
	
	
	/**
	 * Find all books 
	 * @return {@link Book}
	 */
	@Query("select b from book b")
	public Iterable<Book> findAllBooks();

}
