package com.aditya.ecom_project.model;

import java.sql.Date;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Component
public class Product {

 @Id  
 @GeneratedValue(strategy = GenerationType.IDENTITY) 
 private int id;
 private String name;
 private String description;
 private String brand;
 private int price;
 private String category;
 
 private Date releaseDate;
 private boolean productAvailable;
 private int stockQuantity;
 @Lob
 private byte[] imageDate;
 private String imageName;
 private String imageType;

}
