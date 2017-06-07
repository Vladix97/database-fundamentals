package onlineshop.serviceImpls;

import onlineshop.domains.factories.LocationFactory;
import onlineshop.domains.models.Location;
import onlineshop.services.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LocationServiceImpl implements LocationService {

    private final LocationFactory locationFactory;

    @Autowired
    public LocationServiceImpl(LocationFactory locationFactory) {
        this.locationFactory = locationFactory;
    }

    @Override
    public Location create() {
        return this.locationFactory.create();
    }
}
