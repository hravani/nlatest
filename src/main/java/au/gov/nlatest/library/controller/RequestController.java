package au.gov.nlatest.library.controller;

import java.util.function.Consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import au.gov.nlatest.library.controller.service.LibraryService;
import au.gov.nlatest.library.jpa.entities.Book;
import au.gov.nlatest.library.jpa.entities.Person;

@Controller
public class RequestController {
	private static final Logger log = LoggerFactory.getLogger(RequestController.class);
	
	@Autowired
	private LibraryService service;
	
	@RequestMapping("/")
    public String welcome(@RequestParam(value="name", required=false, defaultValue="World") String name, Model model) {
        log.debug("welcome...");
        model.addAttribute("selection", "welcome");
		
        return "welcome";
    }
	
	@RequestMapping(value = "/retrieve/{id}", method = RequestMethod.GET)
	public String retrieveBooksList(Model model, @PathVariable("id") Long id) {
		log.debug("retrieveBooksList() - " + id);
	    model.addAttribute("person", service.getAllBooksForPerson(id));

	    return "results :: resultsList";
	}

	@RequestMapping(value = "/books", method = RequestMethod.GET)
	public String booksList(Model model) {
		log.debug("booksList()");
	    model.addAttribute("books", service.getAllBooks());
		model.addAttribute("selection", "book");
	    return "books";
	}
	
	@RequestMapping(value = "/person", method = RequestMethod.GET)
	public String personList(Model model) {
		log.debug("personList()");
//	    model.addAttribute("books", service.getAllBooksForPerson(id));
		model.addAttribute("selection", "person");
		
		Iterable<Person> list =  service.getAllPersons();
		
		
		model.addAttribute("list", list);
        
        list.forEach(new Consumer<Person>() {

			@Override
			public void accept(Person p) {
				log.debug("----------------");
				log.debug("ID: " + p.getId());
				log.debug("Name: " + p.getName());
				log.debug("Email: " + p.getEmail());
				log.debug(">>>Books: ");
				for(Book b : p.getBooks()) {
					log.debug(">>> " + b.toString());
				}
				log.debug("----------------");
			}
		});
	    return "person";
	}
	
	// accessors and mutators
	public LibraryService getService() {
		return service;
	}

	public void setService(LibraryService service) {
		this.service = service;
	}
	
	
	

}
