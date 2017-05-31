package app.daos;

import app.entities.batches.ProductionBatch;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;

@Repository
@Transactional
public interface BatchDao extends JpaRepository<ProductionBatch, Long> {

    List<ProductionBatch> getProductionBatchByBatchDateAfter(Date date);

    List<ProductionBatch> getProductionBatchByShampoosIsNullOrderByBatchDateDesc();
}
