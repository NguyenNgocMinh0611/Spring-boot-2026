package com.springmasterclass.study.bai5.repository.specifications;

import com.springmasterclass.study.bai5.entity.Product;
import jakarta.persistence.criteria.Predicate;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.StringUtils;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;


public class ProductSpecification {

    // này là làm cho cách 3
    public static Specification<Product> filterProducts(String name, BigDecimal price, String category) {
        // return 1 biểu thức lamda gồm 3 tham số
        // tùy biến ngay khi runtime khi người dùng nhập vào
        // root đại diện chính cho chính bảng products trong DB. Dùng root để trỏ tới các cột (vd: root.get("price") tương đương với cột price
        // query (CriteriaQuery): đại diện cho tổng thể câu lệnh query (SELECT, FROM, WHERE, GROUP BY). Trong các bài toán lọc cơ bản,
           // chúng ta ít khi đụng tới biến này, trừ khi cần viết Sub-query (truy vấn lồng nhau)
        // criteriaBuilder(CriteriaBuilder): Đây là "người thợ xây" tạo ra các phép toán trong mệnh đề WHERE. Bất cứ khi nào
           // cần các toán tử như LIKE, =, <, >, AND, OR, đều phải gọi criteriaBuilder để làm.
        return ((root, query, criteriaBuilder) -> {
            // Predicate khởi tạo một danh sách các điều kiện
            // trong Predicate của Jpa sẽ đại diện cho một điều kiện đơn lẻ
            List<Predicate> predicates = new ArrayList<>();

            // kiểm tra coi có tồn tại không
            if (StringUtils.hasText(name)) {
                predicates.add(criteriaBuilder.like(criteriaBuilder.lower(root.get("name")), "%" +name.toLowerCase() + "%"));
            }

            if (StringUtils.hasText(category)) {
                predicates.add(criteriaBuilder.like(criteriaBuilder.lower(root.get("category")), "%" +category.toLowerCase() + "%"));
            }

            if (price != null) {
                predicates.add(criteriaBuilder.lessThanOrEqualTo(root.get("price"), price));
            }

            // and() chỉ dùng cho mảng nên predicates cần convert sang mảng
            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        });
    }

}
