package com.gsp.bridge.domain.file.domain;

import lombok.Builder;
import lombok.Getter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Getter
@Entity
@Table(name = "file")
public class FileEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String file;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "business-collaboration-id")
    private BusinessCollaboration businessCollaboration;

    @Builder
    public FileEntity(String file, BusinessCollaboration businessCollaboration) {
        this.file = file;
        this.businessCollaboration = businessCollaboration;
    }
}
