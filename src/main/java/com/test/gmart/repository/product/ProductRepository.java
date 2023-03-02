package com.test.gmart.repository.product;

import com.test.gmart.model.product.ProductModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<ProductModel, Integer> {

}
