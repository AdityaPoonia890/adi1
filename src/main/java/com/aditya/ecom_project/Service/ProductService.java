package com.aditya.ecom_project.Service;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.aditya.ecom_project.Repository.ProductRepo;
import com.aditya.ecom_project.model.Product;



@Service
public class ProductService {
@Autowired
 ProductRepo pr;  
 
 

public List<Product> getAllProducts() {
    return  pr.findAll();
}

public Product getProductById(int id){
    return pr.findById(id).orElse(new Product());
}

public void addProduct(Product prod,MultipartFile imageFile)throws Exception{
  prod.setImageDate(imageFile.getBytes());
  prod.setImageName(imageFile.getOriginalFilename());
  prod.setImageType(imageFile.getContentType());  
  pr.save(prod);
  

}
public void updateProduct(int id,Product product,MultipartFile imageFile)throws IOException{
  
  product.setImageDate(imageFile.getBytes());
  product.setImageName(imageFile.getOriginalFilename());
  product.setImageType(imageFile.getContentType());
  pr.save(product);
  
}
public void deleteProduct(int id){
  Product prod=pr.findById(id).orElse( new Product());
  pr.delete(prod);
}
public List<Product> search(String keyword){
   return pr.searchByKeyword(keyword);
}
}
