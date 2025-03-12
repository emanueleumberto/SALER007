package com.example.EsercizioGestionProdottiREST.services;

import com.example.EsercizioGestionProdottiREST.models.Product;
import com.example.EsercizioGestionProdottiREST.repositories.ProductRepository;
import jakarta.persistence.EntityExistsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired ProductRepository productRepository;

    public List<Product> getAllProducts() {
        //  restituisce tutti i prodotti.
        return productRepository.findAll();
    };

    public Product getProductById(Long id) {
        // restituisce un prodotto tramite ID.
        if(!productRepository.existsById(id)) {
            throw new EntityExistsException("Product_ID not exists!!!");
        }

        return productRepository.findById(id).get();
    }

    public Product saveProduct(Product product) {
        // salva un nuovo prodotto.
        productRepository.save(product);
        return product;
    }

    public void deleteProduct(Long id) {
        // elimina un prodotto.
        getProductById(id);
        productRepository.deleteById(id);
    }
}
