package com.jlzdev.supermarket.web.controller;

import com.jlzdev.supermarket.domain.Product;
import com.jlzdev.supermarket.domain.Purchase;
import com.jlzdev.supermarket.domain.service.PurchaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("purchases")
public class PurchaseController {
  @Autowired
  private PurchaseService purchaseService;

  @GetMapping("/all")
  public ResponseEntity<List<Purchase>> getAll(){
    return new ResponseEntity<>(purchaseService.getAll(), HttpStatus.OK);
  }

  @GetMapping("/client/{id}")
  public ResponseEntity<List<Purchase>> getByClientId(@PathVariable("id") String clientId){
    return purchaseService.getByClient(clientId)
        .map(purchases -> new ResponseEntity<>(purchases, HttpStatus.OK))
        .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
  }

  @PostMapping("/save")
  public ResponseEntity<Purchase>  save(@RequestBody Purchase product){
    return new ResponseEntity<>(purchaseService.save(product), HttpStatus.CREATED);
  }


}
