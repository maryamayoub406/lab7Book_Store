package scd.lab.onlinebookstore.repository;

import scd.lab.onlinebookstore.entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.data.repository.query.Param;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

    @Query("SELECT b FROM Book b WHERE b.price > :price")
    List<Book> findBooksByPriceGreaterThan(@Param("price") Double price);

    @Modifying
    @Transactional
    @Query("UPDATE Book b SET b.price = :price WHERE b.id = :id")
    void updateBookPrice(@Param("id") Long id, @Param("price") Double price);

    @Modifying
    @Transactional
    @Query("DELETE FROM Book b WHERE b.id = :id AND b.inStock = false")
    void deleteOutOfStockBook(@Param("id") Long id);

    @Query("SELECT b FROM Book b WHERE LOWER(b.title) LIKE LOWER(CONCAT('%', :keyword, '%'))")
    List<Book> findBooksByTitle(@Param("keyword") String keyword);
}
