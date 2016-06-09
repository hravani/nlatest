package au.gov.nlatest.library.jpa;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import au.gov.nlatest.library.jpa.entities.Book;
import au.gov.nlatest.library.jpa.entities.Person;

public interface LibraryRepository extends CrudRepository<Person, Long> {
	@Query("select p from person p join fetch p.books where p.id =:id")
	public Person findBooksByPersonId(@Param("id") Long id);
	
	@Query("select b from book b")
	public Iterable<Book> findAllBooks();

}
