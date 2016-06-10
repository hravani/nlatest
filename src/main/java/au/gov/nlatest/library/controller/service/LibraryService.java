package au.gov.nlatest.library.controller.service;

import au.gov.nlatest.library.jpa.entities.Book;
import au.gov.nlatest.library.jpa.entities.Person;

/**
 * Business service interface used to access data layer and person
 * any business logic
 * 
 * @author hiten
 *
 */
public interface LibraryService {

	
	/**
	 * Get all persons
	 * @return Iterable {@link Person}
	 */
	public Iterable<Person> getAllPersons();
	
	
	/**
	 * Get all books
	 * @return Iterable {@link Book}
	 */
	public Iterable<Book> getAllBooks();
	
	
	/**
	 * Get all books for Person ID
	 * @param id Person ID
	 * @return {@link Person} with all books populated
	 */
	public Person getAllBooksForPerson(Long id);

}
