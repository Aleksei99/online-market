package by.work.database.repository;

import by.work.database.entity.Basket;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface BasketRepository extends CrudRepository<Basket,Long> {
    List<Basket> findAllByOrderID(Long id);
}
