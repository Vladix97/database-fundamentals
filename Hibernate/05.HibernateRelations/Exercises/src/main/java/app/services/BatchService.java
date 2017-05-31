package app.services;


import app.entities.batches.ProductionBatch;

public interface BatchService {

    void persist(ProductionBatch batch);
}
