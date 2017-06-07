package onlineshop.services;

import onlineshop.domains.models.Location;
import onlineshop.domains.models.Order;

import java.util.Date;

public interface OrderService {

    Order create(Date date, Location location);

    Order persist(Order order);
}
