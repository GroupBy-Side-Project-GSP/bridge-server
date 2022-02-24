package com.gsp.bridge.domain.favorites.domain.repository;

import com.gsp.bridge.domain.favorites.domain.Favorites;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FavoritesRepository extends JpaRepository<Favorites, Long> {
}
