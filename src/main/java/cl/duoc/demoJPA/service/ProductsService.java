package cl.duoc.demoJPA.service;

import cl.duoc.demoJPA.model.Products;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductsService {
    List<Products> findAll();
    Products findById(Long id);
    Products create(Products products);
    Products update(Products products);
    boolean deleteById(Long id);

    List<Products> filterByStockMenorAlMinimo();
    List<Products> buscarConStockMenorA(Integer stockMenor);
    List<Products> buscarConStockMasAltoQue(Integer stock);
}
