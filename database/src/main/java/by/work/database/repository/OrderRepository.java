package by.work.database.repository;

import by.work.database.entity.Order;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface OrderRepository extends CrudRepository<Order,Long> {
}
