package au.gov.nlatest.library.jpa;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import au.gov.nlatest.library.Application;
import au.gov.nlatest.library.jpa.entities.Person;

/**
 * @author hiten
 * JUnit test class to test the {@link LibraryRepository} class
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@Transactional
public class LibraryRepositoryTests {

	@Autowired
	LibraryRepository repository;
	
	@Before
	public void setup() {
		//nothing.
	}
	
	/**
	 * test person count
	 */
	@Test
	public void testPersonCount() {
		assertNotNull(repository);
		assertEquals(3, repository.count()); // Expect 3 pre-loaded persons
	}
	
	
	/**
	 * test person Hiten details
	 */
	@Test
	public void testPersonHiten() {
		Person hiten = repository.findBooksByPersonId(1L); // search user with pk 1
		assertNotNull(hiten);
		assertEquals(hiten.getName(), "Hiten Ravani"); // check name
		assertEquals(hiten.getEmail(), "hiten@ravani.com"); // check email
		int actualBooksSize = repository.findBooksByPersonId(hiten.getId())
										.getBooks()
										.size();
		
		assertEquals(2, actualBooksSize); // check books
	}
	
	/**
	 * test person nobooks books count
	 */
	@Test
	public void testPersonNoBooks() {
		Person noBooks = repository.findBooksByPersonId(3L); // search user with pk 3
		
		int actualBooksSize = repository.findBooksByPersonId(noBooks.getId())
										.getBooks()
										.size();
		
		assertEquals(0, actualBooksSize); // check no books == 0
	}
}
