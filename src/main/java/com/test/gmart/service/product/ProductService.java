package com.test.gmart.service.product;

import com.test.gmart.dto.product.ProductDTO;
import com.test.gmart.model.product.ProductModel;
import com.test.gmart.repository.product.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    //CREATE PRODUCT
    public ProductDTO createProduct(String title, int harga, String description) {

        ProductModel productModel = new ProductModel();

        productModel.setTitleProduct(title);
        productModel.setHargaProduct(harga);
        productModel.setDescriptionProduct(description);
        productModel.setCreatedAt(LocalDateTime.now());

        return convertDTO(productRepository.save(productModel));
    }

    public List<ProductDTO> getAllProduct(){
        return productRepository.findAll().stream().map(this::convertDTO).collect(Collectors.toList());
    }

    public ProductDTO getProductDetail(int idProduct){
        Optional<ProductModel> getProductDetail = productRepository.findById(idProduct);
        if (getProductDetail == null){
            return null;
        }else {
            return convertDTO(getProductDetail.get());
        }
    }

    private ProductDTO convertDTO(ProductModel item) {
        ProductDTO productDTO = new ProductDTO();
        productDTO.setIdProduct(item.getIdProduct());
        productDTO.setTitle(item.getTitleProduct());
        productDTO.setHarga(item.getHargaProduct());
        productDTO.setDescription(item.getDescriptionProduct());
        return productDTO;
    }
}
