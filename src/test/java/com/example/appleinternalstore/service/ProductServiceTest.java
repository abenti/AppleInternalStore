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
        mockProduct.setProductDescription("Latest iphone13 pro max");
        mockProduct.setProductDiscount(0.2f);
        mockProduct.setProductCategory("iphone");
        mockProduct.setProductImages("/path/to/image");
        mockProduct.setProductName("Iphone 13 Prox Max");
        ArrayList list = new ArrayList();
        list.add(mockProduct);
        Mockito.doReturn(list).when(productRepository).findByProductCategory("iphone");

        List<Product> actualProductList = productService.getProductsByCategory("iphone");
        assertThat(actualProductList).isNotEqualTo(null);
        assertThat(actualProductList.size()).isEqualTo(1);
        assertThat(actualProductList.get(0).getProductName()).isEqualTo("Iphone 13 Prox Max");
    }
}
