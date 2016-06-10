package au.gov.nlatest.library.controller.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import au.gov.nlatest.library.jpa.LibraryRepository;
import au.gov.nlatest.library.jpa.entities.Book;
import au.gov.nlatest.library.jpa.entities.Person;

/**
 * Business service class used to access the Data Layer and perform
 * any business logic
 * 
 * @author hiten
 *
 */
@Service
@Transactional
public class LibraryServiceImpl implements LibraryService {

	private static final Logger log = LoggerFactory.getLogger(LibraryServiceImpl.class);
	
	@Autowired
	private LibraryRepository daoService;

	// Business service methods.
	@Override
	@Transactional(propagation = Propagation.SUPPORTS)
	public Iterable<Person> getAllPersons() {
		log.debug("getAllPersons()");
		return daoService.findAll();
	}
	
	
	@Override
	@Transactional(propagation = Propagation.SUPPORTS)
	public Person getAllBooksForPerson(Long id) {
		log.debug("getAllBooksForPerson() - " + id);
		return daoService.findBooksByPersonId(id);
	}
	
	@Override
	@Transactional(propagation = Propagation.SUPPORTS)
	public Iterable<Book> getAllBooks() {
		log.debug("getAllBooks()");
		return daoService.findAllBooks();
	}

	

	
	// accessors and mutators

	public LibraryRepository getDaoService() {
		return daoService;
	}

	public void setDaoService(LibraryRepository daoService) {
		this.daoService = daoService;
	}

	


	

}
