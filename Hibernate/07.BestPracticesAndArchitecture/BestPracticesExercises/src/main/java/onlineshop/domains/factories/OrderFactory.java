package onlineshop.domains.factories;

import onlineshop.domains.models.Location;
import onlineshop.domains.models.Order;

import java.util.Date;

public class OrderFactory {

    public Order create(Date date, Location location) {
        Order order = new Order();
        order.setOrderDate(date);
        order.setLocation(location);

        return order;
    }
}
