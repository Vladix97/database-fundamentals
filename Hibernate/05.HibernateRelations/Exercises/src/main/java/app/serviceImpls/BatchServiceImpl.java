package app.serviceImpls;

import app.daos.BatchDao;
import app.entities.batches.ProductionBatch;
import app.services.BatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BatchServiceImpl implements BatchService {

    private final BatchDao batchDao;

    @Autowired
    public BatchServiceImpl(BatchDao batchDao) {
        this.batchDao = batchDao;
    }

    @Override
    public void persist(ProductionBatch batch) {
        this.batchDao.saveAndFlush(batch);
    }
}
