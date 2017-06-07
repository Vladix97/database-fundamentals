package onlineshop.domains.factories;

import onlineshop.domains.models.LineItem;
import onlineshop.domains.models.Order;
import onlineshop.domains.models.Product;

public class LineItemFactory {

    public LineItem create(Product product, long quantity, Order order) {
        LineItem lineItem = new LineItem();
        lineItem.setProduct(product);
        lineItem.setQuantity(quantity);
        lineItem.setOrder(order);

        return lineItem;
    }
}
