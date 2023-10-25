package root.data.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import root.data.model.Book;
import root.data.model.BorrowedBook;

public interface BorrowedBookRepository extends JpaRepository<BorrowedBook, Long> {
}
