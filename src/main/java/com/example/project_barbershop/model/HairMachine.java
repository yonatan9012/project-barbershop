package com.example.project_barbershop.model;

import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;

@Entity
@Table(name="HairMachine")

public class HairMachine implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotBlank
    @Length(min = 3, max = 30)
    private String brand;

    @Min(3)
    @Max(20)
    private String model;

    @Min(100)
    @Max(2000)
    private Double price;

    @NotBlank
    private Boolean available;

    @Length(max = 500)
    private String description;

    @Max(100)
    private String imageUrl;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public @NotBlank @Length(min = 3, max = 30) String getBrand() {
        return brand;
    }

    public void setBrand(@NotBlank @Length(min = 3, max = 30) String brand) {
        this.brand = brand;
    }

    public @Min(3) @Max(20) String getModel() {
        return model;
    }

    public void setModel(@Min(3) @Max(20) String model) {
        this.model = model;
    }

    public @Min(100) @Max(2000) Double getPrice() {
        return price;
    }

    public void setPrice(@Min(100) @Max(2000) Double price) {
        this.price = price;
    }

    public @NotBlank Boolean getAvailable() {
        return available;
    }

    public void setAvailable(@NotBlank Boolean available) {
        this.available = available;
    }

    public @Length(max = 500) String getDescription() {
        return description;
    }

    public void setDescription(@Length(max = 500) String description) {
        this.description = description;
    }

    public @Max(100) String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(@Max(100) String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public HairMachine() {
    }

    public HairMachine(String brand, String model, Double price, Boolean available, String description, String imageUrl) {
        this.brand = brand;
        this.model = model;
        this.price = price;
        this.available = available;
        this.description = description;
        this.imageUrl = imageUrl;
    }
}