package com.taylor.demoecommerce.domain.repository;

import com.taylor.demoecommerce.domain.Purchase;

public interface PurchaseRepository {
    List<Purchase> getAll();
    Optional<List<Purchase>> getByClient(String clientId);
    Purchase save(Purchase purchase);
}
