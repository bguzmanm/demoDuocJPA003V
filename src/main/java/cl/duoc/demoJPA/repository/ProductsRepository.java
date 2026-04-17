package cl.duoc.demoJPA.repository;

import cl.duoc.demoJPA.model.Products;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductsRepository extends JpaRepository<Products, Long> {
    List<Products> findByName(String name);
    // JPQL
    @Query("SELECT p FROM Products p WHERE p.stock < p.stockMin")
    List<Products> filterByStockMenorAlMinimo();
    // JPQL
    @Query("SELECT p FROM Products p WHERE p.stock < :stockMenor")
    List<Products> buscarConStockMenorA(@Param("stockMenor") Integer stockMenor);
    // SQL Nativo
    @Query(value = "SELECT * FROM products p WHERE p.stock > :stock", nativeQuery = true)
    List<Products> buscarConStockMasAltoQue(@Param("stock") Integer stock);
}
