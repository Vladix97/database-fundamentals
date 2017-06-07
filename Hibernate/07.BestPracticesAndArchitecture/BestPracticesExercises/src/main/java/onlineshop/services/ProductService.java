package onlineshop.services;

import onlineshop.domains.dto.ProductDto;
import onlineshop.domains.models.Product;

public interface ProductService {

    Product create(ProductDto productDto);
}
