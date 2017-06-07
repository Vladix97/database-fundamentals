package onlineshop.controllers;

import onlineshop.domains.dto.ProductDto;
import onlineshop.domains.models.LineItem;
import onlineshop.domains.models.Location;
import onlineshop.domains.models.Order;
import onlineshop.domains.models.Product;
import onlineshop.services.LineItemService;
import onlineshop.services.LocationService;
import onlineshop.services.OrderService;
import onlineshop.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Date;

@Controller
public class ShopController {

    private final LocationService locationService;

    private final LineItemService lineItemService;

    private final OrderService orderService;

    private final ProductService productService;

    @Autowired
    public ShopController(LocationService locationService, LineItemService lineItemService, OrderService orderService, ProductService productService) {
        this.locationService = locationService;
        this.lineItemService = lineItemService;
        this.orderService = orderService;
        this.productService = productService;
    }

    @GetMapping("/shop")
    public String shopForm(Model model) {
        model.addAttribute("productDto", new ProductDto());

        return "/shop";
    }

    @PostMapping("/shop")
    public String shopSubmit(@ModelAttribute ProductDto productDto) {
        Order order = this.registerOrder();
        Product product = this.createProduct(productDto);
        long quantity = productDto.getQuantity();

        this.addLineItem(product, quantity, order);

        return "redirect:/shop";
    }

    private Order registerOrder() {
        Location location = this.locationService.create();
        Order order = this.orderService.create(new Date(), location);
        return this.orderService.persist(order);
    }

    private Product createProduct(ProductDto productDto) {
        return this.productService.create(productDto);
    }

    private void addLineItem(Product product, long quantity, Order order) {
        LineItem lineItem = this.lineItemService.create(product, quantity, order);
        order.addLineItem(lineItem);
        this.orderService.persist(order);
    }
}
