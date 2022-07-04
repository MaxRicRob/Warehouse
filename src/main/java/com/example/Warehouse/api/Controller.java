package com.example.Warehouse.api;

import com.example.Warehouse.entity.DefaultProductResponse;
import com.example.Warehouse.entity.ProductComponentResponse;
import com.example.Warehouse.domain.WarehouseService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
public class Controller {

    private final WarehouseService warehouseService;

    @GetMapping("/defaultProducts")
    public List<DefaultProductResponse> retrieveAllProducts() {
        return warehouseService.retrieveAllDefaultProducts()
                .stream()
                .map(DefaultProductConverter::toProductResponse)
                .collect(Collectors.toList());
    }

    @GetMapping("/components")
    public List<ProductComponentResponse> getAllProductComponents() {

        return warehouseService
                .retrieveAllProductComponents()
                .stream()
                .map(ProductComponentConverter::toProductComponentResponse)
                .collect(Collectors.toList());
    }
}
