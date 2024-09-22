package com.aditya.ecom_project.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.*;
import com.aditya.ecom_project.model.Product;
@Repository
public interface ProductRepo extends JpaRepository<Product,Integer>{

@Query("SELECT p FROM Product p WHERE"+
       " LOWER(p.brand) LIKE LOWER(CONCAT('%',:keyword,'%'))")   
 public List<Product> searchByKeyword(String keyword);
}
