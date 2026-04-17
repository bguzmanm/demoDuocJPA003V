package cl.duoc.demoJPA.service.impl;

import cl.duoc.demoJPA.model.Products;
import cl.duoc.demoJPA.repository.ProductsRepository;
import cl.duoc.demoJPA.service.ProductsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductsServiceImpl implements ProductsService {

    private final ProductsRepository repository;

    @Override
    public List<Products> findAll() {
        return repository.findAll();
    }

    @Override
    public Products findById(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public Products create(Products products) {
        return repository.save(products);
    }

    @Override
    public Products update(Products products) {
        return repository.save(products);
    }

    @Override
    public boolean deleteById(Long id) {
        repository.deleteById(id);
        return true;
    }

    @Override
    public List<Products> filterByStockMenorAlMinimo() {
        return repository.filterByStockMenorAlMinimo();
    }

    @Override
    public List<Products> buscarConStockMenorA(Integer stockMenor) {
        return repository.buscarConStockMenorA(stockMenor);
    }

    @Override
    public List<Products> buscarConStockMasAltoQue(Integer stock) {
        return repository.buscarConStockMasAltoQue(stock);
    }
}
