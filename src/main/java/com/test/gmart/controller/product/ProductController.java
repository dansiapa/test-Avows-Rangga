package com.test.gmart.controller.product;

import com.test.gmart.dto.product.ProductDTO;
import com.test.gmart.response.DataResponse;
import com.test.gmart.response.HandlerResponse;
import com.test.gmart.service.product.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping(value = "/api/v1/product", produces = {"application/json"})
public class ProductController {

    @Autowired
    private ProductService productService;

    //Create Product
    @PostMapping("/create")
    public void createProduct(HttpServletRequest request, HttpServletResponse response,
                           @RequestParam("title") String title,
                           @RequestParam("harga") int harga,
                           @RequestParam("description") String description) throws Exception {


        ProductDTO productDTO = productService.createProduct(title, harga, description);

        if (Objects.nonNull(productDTO)) {
            DataResponse<ProductDTO> dataResponse = new DataResponse<>();
            dataResponse.setData(productDTO);
            HandlerResponse.responseSuccessWithData(response, dataResponse);
        } else {
            HandlerResponse.responseBadRequest(response, "08", "Something Wrong");
        }
    }

    //Get All Product
    @GetMapping("/all")
    public void getAllProduct(HttpServletRequest request,
                              HttpServletResponse response) throws Exception {


        List<ProductDTO> productDTO = productService.getAllProduct();

        if (Objects.nonNull(productDTO)) {
            DataResponse<List<ProductDTO>> dataResponse = new DataResponse<>();
            dataResponse.setData(productDTO);
            HandlerResponse.responseSuccessWithData(response, dataResponse);
        } else {
            HandlerResponse.responseBadRequest(response, "08", "Something Wrong");
        }
    }

    @GetMapping("/detail")
    public void getDetailProduct(HttpServletRequest request,
                                HttpServletResponse response,
                                 @RequestParam("idProduct")int idProduct) throws Exception {


        ProductDTO productDTO = productService.getProductDetail(idProduct);

        if (Objects.nonNull(productDTO)) {
            DataResponse<ProductDTO> dataResponse = new DataResponse<>();
            dataResponse.setData(productDTO);
            HandlerResponse.responseSuccessWithData(response, dataResponse);
        } else {
            HandlerResponse.responseBadRequest(response, "08", "Product Not Found");
        }
    }

}
