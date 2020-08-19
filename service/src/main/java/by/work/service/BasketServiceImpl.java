package by.work.service;

import by.work.database.entity.Basket;
import by.work.database.repository.BasketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class BasketServiceImpl implements BasketService {

    private final BasketRepository basketRepository;

    @Autowired
    public BasketServiceImpl(BasketRepository basketRepository) {
        this.basketRepository = basketRepository;
    }

    @Override
    public void save(Basket basket) {
        basketRepository.save(basket);
    }

    @Override
    public List<Basket> findAllByOrderID(Long id) {
        return basketRepository.findAllByOrderID(id);
    }
}
