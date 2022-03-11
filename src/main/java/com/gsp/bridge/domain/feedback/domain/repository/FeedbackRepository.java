package com.gsp.bridge.domain.feedback.domain.repository;

import com.gsp.bridge.domain.feedback.domain.Feedback;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FeedbackRepository extends JpaRepository<Feedback, Long> {
}
