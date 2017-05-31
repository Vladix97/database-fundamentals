package app.terminal;

import app.daos.BatchDao;
import app.daos.IngredientDao;
import app.daos.LabelDao;
import app.daos.ShampooDao;
import app.entities.batches.ProductionBatch;
import app.entities.enums.Size;
import app.entities.ingridients.AbstractIngredient;
import app.entities.ingridients.AmmoniumChloride;
import app.entities.ingridients.Lavender;
import app.entities.ingridients.Mint;
import app.entities.labels.ClassicLabel;
import app.entities.shampoos.AbstractShampoo;
import app.entities.shampoos.FreshNuke;
import app.services.BatchService;
import app.services.IngredientService;
import app.services.LabelService;
import app.services.ShampooService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Component
public class Terminal implements CommandLineRunner {

    private final IngredientService ingredientService;

    private final BatchService batchService;

    private final LabelService labelService;

    private final ShampooService shampooService;

    // ####
    private final ShampooDao shampooDao;

    private final BatchDao batchDao;

    private final IngredientDao ingredientDao;


    @Autowired
    public Terminal(IngredientService ingredientService, BatchService batchService, LabelService labelService, ShampooService shampooService, ShampooDao shampooDao, BatchDao batchDao, IngredientDao ingredientDao) {
        this.ingredientService = ingredientService;
        this.batchService = batchService;
        this.labelService = labelService;
        this.shampooService = shampooService;
        this.shampooDao = shampooDao;
        this.batchDao = batchDao;
        this.ingredientDao = ingredientDao;
    }

    @Override
    public void run(String... strings) throws Exception {

//        01.
//        this.shampooDao.getAbstractShampooByBrand("brand");

//        02.
//        this.shampooDao.getAbstractShampooByBrandAndSize("brand", Size.LARGE);

//        03.
//        ClassicLabel classicLabel = new ClassicLabel("title", "subtitle");
//        this.labelService.persist(classicLabel);
//        ClassicLabel classicLabelDB = this.labelService.findBy(1);
//        this.shampooDao.getAbstractShampooBySizeOrLabelOrderByPriceAsc(Size.LARGE, classicLabelDB);

//        04.
//        this.shampooDao.getAbstractShampoosByPriceIsAfterOrderByBrandDesc(new BigDecimal("123"));

//        05.
//        this.batchDao.getProductionBatchByBatchDateAfter(new Date());

//        06.
//        this.ingredientDao.getAbstractIngredientByPriceIsNullOrderByNameDesc();

//        07.
//        this.ingredientDao.getAbstractIngredientByNameStartingWith("prefix");

//        08.
//        this.ingredientDao.getAbstractIngredientByNameIn("name1", "name2", "name3");

//        09.
//        this.batchDao.getProductionBatchByShampoosIsNullOrderByBatchDateDesc();

//        10.
//        this.shampooDao.countAbstractShampooByPriceBefore(new BigDecimal("123321"));

//        11.
//        ClassicLabel classicLabel = this.labelService.findBy(1);
//        this.shampooDao.getShampoosByLabel(classicLabel);

//        12.
//        this.ingredientDao.getAllIngredientIn("name1", "name2", "name3");

//        13.
//        this.shampooDao.getShampoosAndIngredientsIn("name1", "name2", "name3");

//        14.
//        this.shampooDao.getShampoosWithIngredientsLessThanNumber(123);

//        15.
//        this.shampooDao.getShampoosWithBatchWithDateBefore(new Date());

//        16.
//        this.shampooDao.getShampoosWithSumOfIngredientsLessThan(123);

//        17.
//        ProductionBatch productionBatch = new ProductionBatch(new Date());
//        productionBatch.setId(1);
//        this.shampooDao.getShampoosWithBatchIdAndWithDifferentLabels(productionBatch, "subtitle");

//        18.
//        this.ingredientDao.getAllIngredientWithPriceHigherThan(new BigDecimal("111"));

//        19.
//        this.ingredientDao.getAllIngredientsNamesAndShampooBrands();

//        20.

    }
}
