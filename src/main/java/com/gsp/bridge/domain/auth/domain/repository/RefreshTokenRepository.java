package com.gsp.bridge.domain.auth.domain.repository;

import com.gsp.bridge.domain.auth.domain.RefreshToken;
import org.springframework.data.repository.CrudRepository;


public interface RefreshTokenRepository extends CrudRepository<RefreshToken, String> {
}
