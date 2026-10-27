package com.springmasterclass.study.bai5.controller;

import com.springmasterclass.study.bai5.common.ApiResponse;
import com.springmasterclass.study.bai5.common.BaseController;
import com.springmasterclass.study.bai5.dto.record.ProductResponse;
import com.springmasterclass.study.bai5.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/products")
@RequiredArgsConstructor
public class ProductController extends BaseController {

    private final ProductService productService;

    @GetMapping
    public ApiResponse<Page<ProductResponse>> getAllProducts(
            @RequestParam(value = "page_no", defaultValue = "0") int page,
            @RequestParam(value = "page_size", defaultValue = "10") int size,
            @RequestParam(defaultValue = "id") String sortBy,
            @RequestParam(defaultValue = "asc") String sortDir,
            // này ko có required = false thì nó cần phải có name nếu ko sẽ luôn báo lỗi
            @RequestParam(value = "name", required = false) String name,
            // này đang bổ sung cho cách 2
            @RequestParam(value = "category", required = false) String category
    ){
        Sort sort = sortDir.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortBy).ascending() : Sort.by(sortBy).descending();
        // đối tượng Pageable hiểu như là 1 bản hợp đồng hoặc là một lời yêu cầu
        // sẽ đóng vai trò như một bản order chứa các thông tin cấu hình về phân trang của tầng service hoặc controller
        // Pageable không tự lấy dữ liệu mà chỉ lưu trữ:
        // - Page Number: tôi muốn lấy dữ liệu từ trang số mấy
        // - Page size: Mỗi trang tôi muốn lấy bao nhiêu bản ghi
        // - Sort(tùy chọn): Dữ liệu trả về cần sắp xếp theo tiêu chí nào
        // PageRequest này là người thực thi
        // là 1 class triển khai impliments trực tiếp của interface của Pageable
        // đây là cách phổ biến để tạo đối tượng Pageable trong Spring Boot
        // thay vì khởi tạo hàm new thì PageRequest cung cấp 1 thg static factory method cực kỳ tiện lợi
        Pageable pageable = PageRequest.of(page == 0 ? page : page - 1, size, sort);

        return ApiResponse.success(productService.getAllProducts(name, category, pageable));
    }


}
