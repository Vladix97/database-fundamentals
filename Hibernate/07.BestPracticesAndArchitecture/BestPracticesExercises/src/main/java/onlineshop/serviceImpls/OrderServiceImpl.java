package onlineshop.serviceImpls;

import onlineshop.domains.factories.OrderFactory;
import onlineshop.domains.models.Location;
import onlineshop.domains.models.Order;
import onlineshop.repositories.OrderRepository;
import onlineshop.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class OrderServiceImpl implements OrderService {

    private final OrderFactory orderFactory;

    private final OrderRepository orderRepository;

    @Autowired
    public OrderServiceImpl(OrderFactory orderFactory, OrderRepository orderRepository) {
        this.orderFactory = orderFactory;
        this.orderRepository = orderRepository;
    }

    @Override
    public Order create(Date date, Location location) {
        return this.orderFactory.create(date, location);
    }

    @Override
    public Order persist(Order order) {
        this.orderRepository.saveAndFlush(order);

        return order;
    }
}
