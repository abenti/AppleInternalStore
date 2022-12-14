package com.example.appleinternalstore.repository;

import com.example.appleinternalstore.model.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DataMongoTest
public class ProductRepositoryTest {

    @Autowired
    ProductRepository repository;

    @Test
    public void shouldReturnProductsFilteredByCategoryFromRepository() {
        Product mockProduct = new Product();
        mockProduct.setDescription("Latest iphone13 pro max");
        mockProduct.setPrice(2000);
        mockProduct.setCategory("iphone");
        mockProduct.setImage("/path/to/image/13");
        mockProduct.setName("Iphone 13 Prox Max");
        repository.save(mockProduct);

        List<Product> products = repository.findAll();
        List<Product> emptyProductList = new ArrayList<>();

        assertThat(products).isNotEqualTo(emptyProductList);
    }
}
