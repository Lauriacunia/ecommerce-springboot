package com.taylor.demoecommerce.persistence;

import com.taylor.demoecommerce.domain.Purchase;
import com.taylor.demoecommerce.domain.repository.PurchaseRepository;
import com.taylor.demoecommerce.persistence.crud.CompraCrudRepository;
import com.taylor.demoecommerce.persistence.entity.Compra;
import com.taylor.demoecommerce.persistence.mapper.PurchaseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class CompraRepository implements PurchaseRepository {
    @Autowired
    private CompraCrudRepository compraCrudRepository;

    @Autowired
    private PurchaseMapper mapper;

    @Override
    public List<Purchase> getAll() {
        return mapper.toPurchases((List<Compra>) compraCrudRepository.findAll());
    }

    @Override
    public Optional<List<Purchase>> getByClient(String clientId) {
        return compraCrudRepository.findByIdCliente(clientId)
                .map(compras -> mapper.toPurchases(compras));
    }

    @Override
    public Purchase save(Purchase purchase) {
        System.out.println("purchase====>" + purchase);
        Compra compra = mapper.toCompra(purchase);
        System.out.println("compra====>" + compra);
        compra.getProductos().forEach(producto -> producto.setCompra(compra));
        return mapper.toPurchase(compraCrudRepository.save(compra));
    }

}
