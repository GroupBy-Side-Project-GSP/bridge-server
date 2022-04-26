package com.gsp.bridge.doamin.category.domain;

import com.gsp.bridge.domain.category.domain.Category;
import com.gsp.bridge.domain.user.domain.User;
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
        User user = User.builder().build();

        Category category  = Category.builder()
                .title(title)
                .user(user)
                .build();

        //then
        Assertions.assertAll(
                () -> Assertions.assertEquals(title,category.getTitle()),
                () -> Assertions.assertEquals(user, category.getUser())
        );
    }
    
}
