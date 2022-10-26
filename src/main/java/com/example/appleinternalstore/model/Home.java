package com.example.appleinternalstore.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotBlank;

@Document("Home")
@Data
public class Home {
    @Id
    private String id;

    @NotBlank(message = "* Home Name is required")
    private String name;

    @NotBlank(message = "* Home Price is required")
    private float price;

    @NotBlank(message = "* Home Images are required")
    private String image;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
