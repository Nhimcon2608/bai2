package com.example.bai2.config;

import com.example.bai2.model.Category;
import com.example.bai2.model.PriceEntry;
import com.example.bai2.model.PriceType;
import com.example.bai2.model.Product;
import com.example.bai2.repository.CategoryRepository;
import com.example.bai2.repository.PriceEntryRepository;
import com.example.bai2.repository.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDate;

@Component
public class DataSeeder implements CommandLineRunner {

    private final CategoryRepository categoryRepository;
    private final ProductRepository productRepository;
    private final PriceEntryRepository priceEntryRepository;

    public DataSeeder(
            CategoryRepository categoryRepository,
            ProductRepository productRepository,
            PriceEntryRepository priceEntryRepository
    ) {
        this.categoryRepository = categoryRepository;
        this.productRepository = productRepository;
        this.priceEntryRepository = priceEntryRepository;
    }

    @Override
    public void run(String... args) {
        if (categoryRepository.count() > 0 || productRepository.count() > 0) {
            return;
        }

        Category electronics = new Category();
        electronics.setName("Điện tử");
        electronics.setDescription("Thiết bị điện tử và phụ kiện");
        categoryRepository.save(electronics);

        Category home = new Category();
        home.setName("Gia dụng");
        home.setDescription("Sản phẩm dùng trong gia đình");
        categoryRepository.save(home);

        Product iphone = new Product();
        iphone.setSku("IP15-128-BLK");
        iphone.setName("iPhone 15 128GB");
        iphone.setDescription("Phiên bản màu đen, chính hãng VN/A");
        iphone.setCategory(electronics);
        iphone.setActive(true);
        productRepository.save(iphone);

        Product airFryer = new Product();
        airFryer.setSku("AIR-FRY-06L");
        airFryer.setName("Nồi chiên không dầu 6L");
        airFryer.setDescription("Dung tích lớn, công nghệ Rapid Air");
        airFryer.setCategory(home);
        airFryer.setActive(true);
        productRepository.save(airFryer);

        PriceEntry retailIphone = new PriceEntry();
        retailIphone.setProduct(iphone);
        retailIphone.setPriceType(PriceType.RETAIL);
        retailIphone.setPrice(new BigDecimal("21990000"));
        retailIphone.setCurrency("VND");
        retailIphone.setEffectiveDate(LocalDate.now());
        retailIphone.setNote("Giá niêm yết cửa hàng");
        priceEntryRepository.save(retailIphone);

        PriceEntry onlineIphone = new PriceEntry();
        onlineIphone.setProduct(iphone);
        onlineIphone.setPriceType(PriceType.ONLINE);
        onlineIphone.setPrice(new BigDecimal("21490000"));
        onlineIphone.setCurrency("VND");
        onlineIphone.setEffectiveDate(LocalDate.now());
        onlineIphone.setNote("Áp dụng kênh online");
        priceEntryRepository.save(onlineIphone);

        PriceEntry retailAirFryer = new PriceEntry();
        retailAirFryer.setProduct(airFryer);
        retailAirFryer.setPriceType(PriceType.RETAIL);
        retailAirFryer.setPrice(new BigDecimal("2890000"));
        retailAirFryer.setCurrency("VND");
        retailAirFryer.setEffectiveDate(LocalDate.now());
        retailAirFryer.setNote("Giá tiêu chuẩn");
        priceEntryRepository.save(retailAirFryer);
    }
}
