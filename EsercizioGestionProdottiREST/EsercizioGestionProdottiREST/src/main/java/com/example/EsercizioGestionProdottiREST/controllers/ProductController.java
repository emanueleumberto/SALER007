package com.example.EsercizioGestionProdottiREST.controllers;

import com.example.EsercizioGestionProdottiREST.models.Product;
import com.example.EsercizioGestionProdottiREST.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ReflectionUtils;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    @Autowired ProductService productService;

    //GET /products → restituisce tutti i prodotti.
    @GetMapping
    public List<Product> getProducts() {
        return productService.getAllProducts();
    }
    //GET /products/{id} → restituisce un prodotto specifico.
    @GetMapping("/{id}")
    public ResponseEntity<Product> getProduct(@PathVariable Long id) {
        /*try {
            return new ResponseEntity<Product>(productService.getProductById(id), HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_FOUND);
        }*/
        //return new ResponseEntity<Product>(productService.getProductById(id), HttpStatus.OK);
        return ResponseEntity.ok(productService.getProductById(id));
    }
    //POST /products → aggiunge un nuovo prodotto.
    @PostMapping
    public ResponseEntity<?> createProduct(@RequestBody Product product) {
        /*try {
            return new ResponseEntity<Product>(productService.saveProduct(product), HttpStatus.CREATED);
        } catch (DataIntegrityViolationException e) {
            return new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_FOUND);
        }*/
        return ResponseEntity.ok(productService.saveProduct(product));
    }
    //PUT /products/{id} → aggiorna un prodotto.
    @PutMapping("/{id}")
    public ResponseEntity<?> updatePutProduct(@PathVariable Long id, @RequestBody Product product) {
        /*try {
            productService.getProductById(id);
            if(id == product.getId()) {
                return new ResponseEntity<Product>(productService.saveProduct(product), HttpStatus.OK);
            } else {
                return new ResponseEntity<String>("product id not found", HttpStatus.NOT_FOUND);
            }
        } catch (NoSuchElementException e) {
            return new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_FOUND);
        }*/
        if(productService.getProductById(id).getId() == product.getId()) {
            return ResponseEntity.ok(productService.saveProduct(product));
        } else {
            return ResponseEntity.badRequest().body("product id not found");
        }

    }
    //PATCH /products/{id} → aggiorna un prodotto.
    @PatchMapping("/{id}")
    public ResponseEntity<?> updatePatchProduct(@PathVariable Long id,  @RequestBody Map<String, Object> updates){
        /*try {
            Product product = productService.getProductById(id);
            updates.forEach((key, value) -> {
                Field field = ReflectionUtils.findField(Product.class, key);
                if(field != null) {
                    field.setAccessible(true);
                    ReflectionUtils.setField(field, product , value);
                }
            });
            return new ResponseEntity<Product>(productService.saveProduct(product), HttpStatus.OK);

        } catch (NoSuchElementException e) {
            return new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_FOUND);
        }*/

        Product product = productService.getProductById(id);
        updates.forEach((key, value) -> {
            Field field = ReflectionUtils.findField(Product.class, key);
            if(field != null) {
                field.setAccessible(true);
                ReflectionUtils.setField(field, product , value);
            }
        });
        return ResponseEntity.ok(productService.saveProduct(product));
    }

    //DELETE /products/{id} → elimina un prodotto.
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable Long id)  {
        /*try {
            productService.getProductById(id);
            productService.deleteProduct(id);
            return new ResponseEntity<String>("Product deleted!", HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_FOUND);
        }*/

        productService.deleteProduct(id);
        return ResponseEntity.ok("Product deleted!");
    }

}
