package com.aditya.ecom_project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.aditya.ecom_project.model.*;

import lombok.experimental.Delegate;

import com.aditya.ecom_project.Service.ProductService;

import java.util.*;
@CrossOrigin
@RestController
@RequestMapping("/api")
public class ProductController {
 private ProductService ps; 

 @Autowired
 public ProductController(ProductService ps){
   this.ps=ps;
 }

 @GetMapping("/")
 public String greet(){
    return "hey there!";
 }

 @GetMapping("/products")
 public List<Product> getProducts(){
    return ps.getAllProducts();
 }

@GetMapping("/product/{id}")
public Product geProduct(@PathVariable int id){
   return ps.getProductById(id);
}
@PostMapping("/product")
public void addProduct(@RequestPart Product product,@RequestPart MultipartFile imageFile){
   try{
   ps.addProduct(product,imageFile);
}
catch(Exception e){}
}



@GetMapping("/product/{productId}/image")
public byte[] getImageByProductId (@PathVariable int productId){
 Product prod=ps.getProductById(productId);
 byte[] imageFile=  prod.getImageDate();
 return imageFile;
 
}

@PutMapping("/product/{id}")
public void updateProduct(@PathVariable int id,@RequestPart Product product,@RequestPart MultipartFile imageFile){
   try{
   ps.updateProduct(id, product, imageFile);
}
catch(Exception e){}  
}


@DeleteMapping("/product/{id}")
public void deleteProduct(@PathVariable int id){
ps.deleteProduct(id);
}

@GetMapping("/products/search")
public List<Product> search(@RequestParam String keyword){
   List<Product> p=ps.search(keyword);
   return p;
}
}
