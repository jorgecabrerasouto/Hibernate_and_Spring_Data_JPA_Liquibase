package co.com.jorgecabrerasouto.sdjpaintro.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import co.com.jorgecabrerasouto.sdjpaintro.domain.Book;
import co.com.jorgecabrerasouto.sdjpaintro.repositories.BookRepository;

@Profile({"local", "default"})
@Component
public class DataInitializer implements CommandLineRunner {
	
	private final BookRepository bookRepository;	
	
	public DataInitializer(BookRepository bookRepository) {
		this.bookRepository = bookRepository;
	}

	@Override
	public void run(String... args) throws Exception {
		bookRepository.deleteAll();
		
		Book bookDDD = new Book("Domain Driven Design", "123", "RandomHouse");
		Book savedDDD = bookRepository.save(bookDDD);
		
		Book bookSIA = new Book("Spring in Action", "234234", "Oriely");	
		Book savedSIA = bookRepository.save(bookSIA);
		
		bookRepository.findAll().forEach(book -> {
			System.out.println("Book Id: " + book.getId());
			System.out.println("Book Title: " + book.getTitle());	
		});
	}

}
