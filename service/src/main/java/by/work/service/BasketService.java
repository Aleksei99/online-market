package by.work.service;

import by.work.database.entity.Basket;

import java.util.List;

public interface BasketService {
    void save(Basket basket);
    List<Basket> findAllByOrderID(Long id);
}
