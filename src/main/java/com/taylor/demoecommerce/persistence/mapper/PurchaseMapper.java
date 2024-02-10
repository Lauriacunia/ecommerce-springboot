package com.taylor.demoecommerce.persistence.mapper;

import com.taylor.demoecommerce.domain.Purchase;
import com.taylor.demoecommerce.persistence.entity.Compra;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring", uses = {PurchaseItemMapper.class})
public interface PurchaseMapper {
    @Mappings({
            @Mapping(source = "id.idCompra", target = "purchaseId"),
            @Mapping(source = "id.idCliente", target = "clienteId"),
            @Mapping(source = "fecha", target = "date"),
            @Mapping(source = "medioPago", target = "paymentMethod"),
            @Mapping(source = "comentario", target = "comment"),
            @Mapping(source = "estado", target = "state"),
            @Mapping(source = "productos", target = "item")
    })
    Purchase toPurchase(Compra compra);
    List<Purchase> toPurchases(List<Compra> compras);

    @InheritInverseConfiguration
    @Mappings({
            @Mapping(target = "cliente",
                    ignore = true),
    })
    Compra toCompra(Purchase purchase);
}
