package com.taylor.demoecommerce.web.controller;

import com.taylor.demoecommerce.domain.Purchase;
import com.taylor.demoecommerce.domain.service.PurchaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping()
public class PurchaseController {
    @Autowired
    private PurchaseService purchaseService;

    @GetMapping("/purchases")
    public ResponseEntity<List<Purchase>> getAll() {
        return new ResponseEntity<>(purchaseService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/purchases/client/{idClient}")
    public ResponseEntity<List<Purchase>> getByClient(@PathVariable("idClient") String clientId) {
        return purchaseService.getByClient(clientId).map(
                purchases -> new ResponseEntity<>(purchases, HttpStatus.OK)
        ).orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/purchases")
    public ResponseEntity<Purchase> save(@RequestBody Purchase purchase) {
        System.out.println("purchase en controller====>" + purchase);
        return new ResponseEntity<>(purchaseService.save(purchase), HttpStatus.CREATED);
    }
}
