package com.gsp.bridge.infrastructure.dto;

import com.gsp.bridge.domain.notification.domain.type.Type;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.util.List;

@Getter
@NoArgsConstructor
public class SubscribeRequest {

    @NotNull(message = "List는 Null일 수 없습니다.")
    private List<Long> userIdList;

    @NotNull(message = "topic은 Null일 수 없습니다.")
    private Type type;

}
