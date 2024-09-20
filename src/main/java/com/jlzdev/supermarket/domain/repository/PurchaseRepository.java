package com.jlzdev.supermarket.domain.repository;

import com.jlzdev.supermarket.domain.Purchase;

import java.util.List;
import java.util.Optional;

public interface PurchaseRepository {
  List<Purchase> getAll();
  Optional<List<Purchase>> getByClient(String clientId);
  Purchase save(Purchase purchase);
}
