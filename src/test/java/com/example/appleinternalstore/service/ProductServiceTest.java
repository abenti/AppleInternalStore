package com.example.appleinternalstore.service;

import com.example.appleinternalstore.model.Product;
import com.example.appleinternalstore.repository.ProductRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class ProductServiceTest {

    @Autowired
    private ProductService productService;

    @MockBean
    private ProductRepository productRepository;

    @Test
    public void whenValidName_thenEmployeeShouldBeFound() {
        Product mockProduct = new Product();
        mockProduct.setDescription("Latest iphone13 pro max");
        mockProduct.setPrice(2000);
        mockProduct.setCategory("iphone");
        mockProduct.setImage("/path/to/image");
        mockProduct.setName("Iphone 13 Prox Max");
        ArrayList list = new ArrayList();
        list.add(mockProduct);
        Mockito.doReturn(list).when(productRepository).findByCategory("iphone");

        List<Product> actualProductList = productService.getProductsByCategory("iphone");
        assertThat(actualProductList).isNotEqualTo(null);
        assertThat(actualProductList.size()).isEqualTo(1);
        assertThat(actualProductList.get(0).getName()).isEqualTo("Iphone 13 Prox Max");
    }
}
