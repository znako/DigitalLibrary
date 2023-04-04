package project.DigitalLibraryRecording_.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import project.DigitalLibraryRecording_.models.Book;

public interface BooksRepository extends JpaRepository<Book, Integer> {
}
