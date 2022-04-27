package com.gsp.bridge.domain.user.domain.repository;

import com.gsp.bridge.domain.user.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {

    Optional<User> findByAccountId(String accountId);

    List<User> findAllByIdIn(List<Long> ids);

}
