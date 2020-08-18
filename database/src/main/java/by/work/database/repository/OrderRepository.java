package by.work.database.repository;

import by.work.database.entity.Order;
import by.work.database.entity.Product;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.util.List;

@Transactional
public interface OrderRepository extends CrudRepository<Order, Long> {
    @Query("select o from Order o where o.timeOrder >= :timeOrder and o.totalAmount is not null")
    List<Order> findAllWithTimeOrderAfter(@Param("timeOrder") Timestamp timeOrder);

    Order findById(Long id);
}
