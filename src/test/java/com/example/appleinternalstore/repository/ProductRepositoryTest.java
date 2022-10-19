package com.example.appleinternalstore.repository;

import com.example.appleinternalstore.model.Cart;
import com.example.appleinternalstore.model.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class ProductRepositoryTest {

    @Autowired
    ProductRepository repository;

    @Test
    public void shouldReturnProductsFilteredByCategoryFromRepository()
    {
        Product product = new Product();
        product.setProductName("Iphone 13 Prox Max");
        product.setProductDescription("Iphone 13 Prox Max");
        product.setProductPrice(1200);
        product.setProductCategory("iphone");
        product.setProductImages("image to iphone");
        product.setProductDiscount(0.2f);
        Cart cart = new Cart();
        List<Product> productList = new ArrayList<>();
        productList.add(product);
        cart.setProductList(productList);
        cart.setUserId("1234");
        product.setCart(cart);

        repository.save(product);

        List<Product> products = repository.findAll();
        List<Product> emptyProductList = new ArrayList<>();

        assertThat(products).isNotEqualTo(emptyProductList);
    }
}
