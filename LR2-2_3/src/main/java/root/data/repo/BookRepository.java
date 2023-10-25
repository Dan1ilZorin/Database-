package root.data.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import root.data.model.Book;

public interface BookRepository extends JpaRepository<Book, Long> {
}
