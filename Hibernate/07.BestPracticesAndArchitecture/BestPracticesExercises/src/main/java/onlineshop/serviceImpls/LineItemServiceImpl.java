package onlineshop.serviceImpls;

import onlineshop.domains.factories.LineItemFactory;
import onlineshop.domains.models.LineItem;
import onlineshop.domains.models.Order;
import onlineshop.domains.models.Product;
import onlineshop.services.LineItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LineItemServiceImpl implements LineItemService {

    private final LineItemFactory lineItemFactory;

    @Autowired
    public LineItemServiceImpl(LineItemFactory lineItemFactory) {
        this.lineItemFactory = lineItemFactory;
    }

    @Override
    public LineItem create(Product product, long quantity, Order order) {
        return this.lineItemFactory.create(product, quantity, order);
    }
}
