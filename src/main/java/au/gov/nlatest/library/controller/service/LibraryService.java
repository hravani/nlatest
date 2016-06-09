package au.gov.nlatest.library.controller.service;

import au.gov.nlatest.library.jpa.entities.Book;
import au.gov.nlatest.library.jpa.entities.Person;

public interface LibraryService {
	
	public void addBook(Book book);
	
	public Iterable<Person> getAllPersons();
	
	public Iterable<Book> getAllBooks();
	
	public Person getAllBooksForPerson(Long id);

}
