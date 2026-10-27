package com.springmasterclass.study.bai5.config;

import com.springmasterclass.study.bai5.dto.response.UserRp;
import com.springmasterclass.study.bai5.entity.User;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {

    @Bean
    public ModelMapper modelMapper() {
        ModelMapper modelMapper = new ModelMapper();

        modelMapper.getConfiguration()
                .setFieldMatchingEnabled(true)
                .setMatchingStrategy(MatchingStrategies.STRICT);
        // này là cấu hình thêm cho model mapper
        // typeMap là để map từ Entity sang Dto và ngược lại
        // addMappings là để tránh không khớp dữ liệu ví dụ 1 nơi là name 1 nơi là fullName;
        // :: là method reference là tham chiếu phương thức
        modelMapper.typeMap(User.class, UserRp.class).addMappings(mapper -> {
            mapper.map(User::getName, UserRp::setName);
        });

        return modelMapper;
    }

}
