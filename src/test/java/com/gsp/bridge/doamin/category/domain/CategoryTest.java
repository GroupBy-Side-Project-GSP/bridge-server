package com.gsp.bridge.doamin.category.domain;

import com.gsp.bridge.domain.cateogry.domain.Category;
import com.gsp.bridge.domain.company.domain.entity.Company;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class CategoryTest {

    @Test
    void 카테고리_객체_생성() {

        //given
        String title = "제목";
        Company company = Company.builder().build();

        Category category  = Category.builder()
                .title(title)
                .company(company)
                .build();

        //then
        Assertions.assertAll(
                () -> Assertions.assertEquals(title,category.getTitle()),
                () -> Assertions.assertEquals(company, category.getCompany())
        );
    }
    
}
