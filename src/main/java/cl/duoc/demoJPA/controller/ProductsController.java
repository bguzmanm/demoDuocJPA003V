package cl.duoc.demoJPA.controller;

import cl.duoc.demoJPA.model.Products;
import cl.duoc.demoJPA.service.ProductsService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.function.EntityResponse;

import java.util.List;

@RestController
@RequestMapping("/api/v1/products")
@RequiredArgsConstructor
public class ProductsController {
    private final ProductsService service;

    @GetMapping
    public ResponseEntity<List<Products>> findAll(){
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/stock-minimo")
    public ResponseEntity<List<Products>> filterByStockMenorAlMinimo(){
        return ResponseEntity.ok(service.filterByStockMenorAlMinimo());
    }
    @GetMapping("/menor/{stockMenor}")
    List<Products> buscarConStockMenorA(@PathVariable Integer stockMenor){
        return service.buscarConStockMenorA(stockMenor);
    }
    @GetMapping("/mas-alto/{stock}")
    List<Products> buscarConStockMasAltoQue(@PathVariable Integer stock){
        return service.buscarConStockMasAltoQue(stock);
    }
}
