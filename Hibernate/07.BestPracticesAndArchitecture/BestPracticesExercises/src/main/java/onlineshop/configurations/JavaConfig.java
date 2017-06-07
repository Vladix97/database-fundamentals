package onlineshop.configurations;

import onlineshop.domains.factories.LineItemFactory;
import onlineshop.domains.factories.LocationFactory;
import onlineshop.domains.factories.OrderFactory;
import onlineshop.domains.factories.ProductFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JavaConfig {

    @Bean
    public ProductFactory productFactory() {
        return new ProductFactory();
    }

    @Bean
    public LineItemFactory lineItemFactory() {
        return new LineItemFactory();
    }

    @Bean
    public LocationFactory locationFactory() {
        return new LocationFactory();
    }

    @Bean
    public OrderFactory orderFactory() {
        return new OrderFactory();
    }
}
