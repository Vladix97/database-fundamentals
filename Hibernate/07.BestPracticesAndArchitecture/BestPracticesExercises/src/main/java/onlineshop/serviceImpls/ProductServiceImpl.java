package onlineshop.serviceImpls;

import onlineshop.domains.dto.ProductDto;
import onlineshop.domains.factories.ProductFactory;
import onlineshop.domains.models.Product;
import onlineshop.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductFactory productFactory;

    @Autowired
    public ProductServiceImpl(ProductFactory productFactory) {
        this.productFactory = productFactory;
    }

    @Override
    public Product create(ProductDto productDto) {
        return this.productFactory.create(productDto.getName(), productDto.getPrice());
    }
}
