package onlineshop.services;

import onlineshop.domains.models.LineItem;
import onlineshop.domains.models.Order;
import onlineshop.domains.models.Product;

public interface LineItemService {

    LineItem create(Product product, long quantity, Order order);
}
