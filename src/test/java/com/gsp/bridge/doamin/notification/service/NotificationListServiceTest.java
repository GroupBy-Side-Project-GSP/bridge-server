package com.gsp.bridge.doamin.notification.service;

import com.gsp.bridge.domain.company.domain.entity.Company;
import com.gsp.bridge.domain.company.facade.CompanyFacade;
import com.gsp.bridge.domain.notification.domain.NotificationEntity;
import com.gsp.bridge.domain.notification.domain.NotificationList;
import com.gsp.bridge.domain.notification.domain.repository.NotificationListRepository;
import com.gsp.bridge.domain.notification.presentation.response.QueryNotificationListResponse;
import com.gsp.bridge.domain.notification.service.QueryNotificationListService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.when;


public class NotificationListServiceTest {

    @Mock
    private CompanyFacade companyFacade;

    @Mock
    private NotificationListRepository notificationListRepository;

    @InjectMocks
    private QueryNotificationListService service;

    @Test
    public void 알림_리스트_가져오기() {

        String name = "Test Name";
        String accountId = "Test AccountId";
        Page<NotificationList> notificationList = Page.empty(Pageable.unpaged());
        //given
        Company company = Company.builder()
                .companyName(name)
                .accountId(accountId)
                .build();
        Pageable pageable = PageRequest.of(5, 5);
        QueryNotificationListResponse response = new QueryNotificationListResponse(new ArrayList<>());

        when(companyFacade.getCurrentCompany())
                .thenReturn(company);
        given(notificationListRepository.findByCompany(company, pageable))
                .willReturn(notificationList);

        //when
        QueryNotificationListResponse execute = service.execute(pageable);

        assertThat(execute).usingRecursiveComparison().isEqualTo(response);
    }
}
