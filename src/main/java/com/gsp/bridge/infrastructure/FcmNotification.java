package com.gsp.bridge.infrastructure;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.messaging.*;
import com.gsp.bridge.domain.notification.domain.NotificationEntity;
import com.gsp.bridge.domain.notification.domain.repository.NotificationRepository;
import com.gsp.bridge.domain.user.domain.User;
import com.gsp.bridge.domain.user.domain.repository.UserRepository;
import com.gsp.bridge.infrastructure.dto.NotificationRequest;
import com.gsp.bridge.infrastructure.dto.SubscribeRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@SuppressWarnings("EqualsBetweenInconvertibleTypes")
@Slf4j
@RequiredArgsConstructor
@Component
public class FcmNotification implements FcmUtil{

    private final UserRepository userRepository;
    private final NotificationRepository notificationRepository;

    @Value("${firebase.path}")
    private String path;

    private static final String MESSAGING_SCOPE = "https://www.googleapis.com/auth/firebase.messaging";
    private static final String[] SCOPES = {MESSAGING_SCOPE};

    @PostConstruct
    @Override
    public void initialize() {
        try {
            FirebaseOptions options = FirebaseOptions.builder()
                    .setCredentials(GoogleCredentials.fromStream(new ClassPathResource(path).getInputStream())
                            .createScoped(Arrays.asList(SCOPES)))
                    .build();

            if (FirebaseApp.getApps().isEmpty()) {
                FirebaseApp.initializeApp(options);
                log.info("Firebase application has been initialized");
            }
        } catch (IOException e) {
            log.error(e.getMessage());
        }

    }

    @Override
    public void sendNotification(NotificationRequest request) {
        Integer notificationId = notificationRepository.save(
                NotificationEntity.builder()
                        .title(request.getTitle())
                        .content(request.getContent())
                        .type(request.getType())
                        .data(request.getData())
                        .build()
        ).getId();

        Message message = Message.builder()
                .putData("notification-id", notificationId.toString())
                .putData("click_action", request.getClickAction())
                .setToken(request.getUser().getAppDeviceToken())
                .setNotification(
                        Notification.builder()
                                .setTitle(request.getTitle())
                                .setBody(request.getContent())
                                .build()
                )
                .setApnsConfig(ApnsConfig.builder()
                        .setAps(Aps.builder()
                                .setSound("default")
                                .build())
                        .build())
                .setTopic((request.getType().toString()))
                .build();
        FirebaseMessaging.getInstance().sendAsync(message);
    }

    @Override
    public void subscribeTopic(SubscribeRequest request) {
        List<User> userList = userRepository.findAllByIdIn(request.getUserIdList());

        try {
            for (int i = 0; i < userList.size() / 1000; i++) {
                List<String> deviceTokenListToSubscribe = userList.subList(i * 1000, 1000 * i + 1000)
                        .stream().map(User::getAppDeviceToken)
                        .collect(Collectors.toList());

                FirebaseMessaging.getInstance(FirebaseApp.getInstance())
                        .subscribeToTopic(
                                deviceTokenListToSubscribe, request.getType().toString()
                        );
            }
        } catch (FirebaseMessagingException e) {
            log.error(e.getMessage());
        }
    }
    
}
