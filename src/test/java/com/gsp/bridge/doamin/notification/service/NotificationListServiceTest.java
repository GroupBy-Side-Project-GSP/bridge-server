package com.gsp.bridge.doamin.notification.service;

import com.gsp.bridge.domain.user.domain.User;
import com.gsp.bridge.domain.user.facade.UserFacade;
import com.gsp.bridge.domain.notification.domain.NotificationList;
import com.gsp.bridge.domain.notification.domain.repository.NotificationListRepository;
import com.gsp.bridge.domain.notification.presentation.response.QueryNotificationListResponse;
import com.gsp.bridge.domain.notification.service.QueryNotificationListService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class NotificationListServiceTest {

    @Mock
    private UserFacade userFacade;

    @Mock
    private NotificationListRepository notificationListRepository;

    @InjectMocks
    private QueryNotificationListService service;

    @Test
    void 알림_리스트_가져오기() {
        //given
        Page<NotificationList> notificationList = Page.empty(Pageable.unpaged());
        User user = User.builder().build();
        Pageable pageable = PageRequest.of(5, 5);
        QueryNotificationListResponse response = new QueryNotificationListResponse(new ArrayList<>());

        when(userFacade.getCurrentUser())
                .thenReturn(user);
        given(notificationListRepository.findByUser(user, pageable))
                .willReturn(notificationList);

        //when
        QueryNotificationListResponse execute = service.execute(pageable);

        assertThat(execute).usingRecursiveComparison().isEqualTo(response);
    }
}
