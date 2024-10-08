package com.jlzdev.supermarket.web.controller;

import com.jlzdev.supermarket.domain.Product;
import com.jlzdev.supermarket.domain.service.ProductService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/products")
public class ProductController {
  @Autowired
  private ProductService productService;

  @GetMapping("all")
  @Operation(summary = "Get all product",
      responses = {
          @ApiResponse(description = "Successful Operation",
              content = @Content(mediaType = "application/json",
              schema = @Schema(implementation = Product.class)))
      })
  public ResponseEntity<List<Product>> getAll(){
    return new ResponseEntity<>(productService.getAll(), HttpStatus.OK);
  }

  @Operation(summary = "Get products by category", description = "Returns a list of products for a given category ID")
  @ApiResponses(value = {
      @ApiResponse(responseCode = "200", description = "Successfully retrieved the list of products"),
      @ApiResponse(responseCode = "404", description = "Category not found")
  })
  @GetMapping("category/{id}")
  public ResponseEntity<List<Product>>  getByCategory(@PathVariable("id") int categoryId){
    return productService.getByCategory(categoryId)
        .map(prdoduct -> new ResponseEntity<>(prdoduct, HttpStatus.OK))
        .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
  }


  @GetMapping("product/{id}")
  public ResponseEntity<Product> getProduct(@PathVariable("id") int productId){
    return productService.getProduct(productId)
        .map(product -> new ResponseEntity<>(product, HttpStatus.OK))
        .orElse( new ResponseEntity<>(HttpStatus.NOT_FOUND));
  }

  @PostMapping("/save")
  public ResponseEntity<Product>  save(@RequestBody Product product){
    return new ResponseEntity<>(productService.save(product), HttpStatus.CREATED);
  }

  @DeleteMapping("/delete/{id}")
  public ResponseEntity delete(@PathVariable("id") int productId){
    if(productService.delete(productId)){
      return new ResponseEntity<>(HttpStatus.OK);
    }else{
      return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
  }


}
