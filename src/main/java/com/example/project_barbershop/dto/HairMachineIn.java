package com.example.project_barbershop.dto;


import com.example.project_barbershop.model.HairMachine;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;

public class HairMachineIn implements Serializable {
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

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Boolean getAvailable() {
        return available;
    }

    public void setAvailable(Boolean available) {
        this.available = available;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public HairMachine toHairMachine(HairMachineIn hairMachineIn) {
        return new HairMachine(
                hairMachineIn.getBrand(),
                hairMachineIn.getModel(),
                hairMachineIn.getPrice(),
                hairMachineIn.getAvailable(),
                hairMachineIn.getDescription(),
                hairMachineIn.getImageUrl()
        );
    }

    public void updateHairMachine(HairMachine hairMachine) {
        hairMachine.setBrand(brand);
        hairMachine.setModel(model);
        hairMachine.setPrice(price);
        hairMachine.setAvailable(available);
        hairMachine.setDescription(description);
        hairMachine.setImageUrl(imageUrl);
    }
}
