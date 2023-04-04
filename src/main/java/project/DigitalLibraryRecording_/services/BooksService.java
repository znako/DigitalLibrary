package project.DigitalLibraryRecording_.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import project.DigitalLibraryRecording_.models.Book;
import project.DigitalLibraryRecording_.models.Person;
import project.DigitalLibraryRecording_.repositories.BooksRepository;


import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class BooksService {

    private final BooksRepository booksRepository;

    @Autowired
    public BooksService(BooksRepository booksRepository) {
        this.booksRepository = booksRepository;
    }

    public List<Book> findAll(){
        return booksRepository.findAll();
    }

    public Book findOne(int id){
        Optional<Book> foundBook = booksRepository.findById(id);
        return foundBook.orElse(null);
    }

    @Transactional
    public void save(Book book){
        booksRepository.save(book);
    }

    @Transactional
    public void update(int id, Book updatedBook){
        Book bookToBeUpdated = booksRepository.findById(id).get();
        updatedBook.setBook_id(id);
        updatedBook.setOwner(bookToBeUpdated.getOwner());
        booksRepository.save(updatedBook);
    }

    @Transactional
    public void delete(int id){
        booksRepository.deleteById(id);
    }

    public Optional<Person> findBookOwner(int id){
        return Optional.ofNullable(booksRepository.findById(id).orElse(null).getOwner());
    }

    @Transactional
    public void release(int id){
        Book book = booksRepository.findById(id).orElse(null);
        book.setOwner(null);
    }

    @Transactional
    public void assign(int id, Person person){
        booksRepository.findById(id).orElse(null).setOwner(person);
    }
}
