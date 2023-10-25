package root.data.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.sql.Date;

@Entity
@Getter
@Setter
@Table(name = "BorrowedBooks")
public class BorrowedBook {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "BorrowID")
    private int borrowID;

    @Column(name = "ReaderID")
    private int readerID;

    @Column(name = "BookID")
    private int bookID;

    @Column(name = "BorrowDate")
    private Date borrowDate;

    @Column(name = "ReturnDate")
    private Date returnDate;

}
