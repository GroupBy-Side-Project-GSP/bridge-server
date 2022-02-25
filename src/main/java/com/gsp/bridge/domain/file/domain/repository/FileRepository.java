package com.gsp.bridge.domain.file.domain.repository;

import com.gsp.bridge.domain.file.domain.FileEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FileRepository extends JpaRepository<FileEntity, Long> {
}
