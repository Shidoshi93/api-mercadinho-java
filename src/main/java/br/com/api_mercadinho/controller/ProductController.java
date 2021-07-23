package br.com.api_mercadinho.controller;

import br.com.api_mercadinho.model.Product;
import br.com.api_mercadinho.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    ProductRepository productRepository;

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public void addProduct(@RequestBody Product product){
        productRepository.save(product);
    }

    @RequestMapping(value = "/getProducts", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public List<Product> getProucts() {
        return (List<Product>) productRepository.findAll();
    }

    @RequestMapping(value = "/getProduct/{id}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public Product getProduct(@PathVariable Integer id){
        Optional<Product> product = productRepository.findById(id);

        return product.get();
    }

    @RequestMapping(value = "/updateProduct/{id}", method = RequestMethod.PATCH)
    @ResponseStatus(HttpStatus.OK)
    public void updateProduct(@PathVariable Integer id, @RequestBody Product product) {
        productRepository.findById(id).map(record -> {
            record.setDesc(product.getDesc());
            record.setDescForn(product.getDescForn());
            record.setPreco(product.getPreco());
            Product updated = productRepository.save(record);
            return ResponseEntity.ok().body(updated);
        }).orElse(ResponseEntity.notFound().build());
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteProduct(@PathVariable Integer id) {
        productRepository.deleteById(id);
    }
}
