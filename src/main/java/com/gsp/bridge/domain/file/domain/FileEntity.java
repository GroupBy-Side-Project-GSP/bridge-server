package com.gsp.bridge.domain.file.domain;

import com.gsp.bridge.domain.businesscollaboration.domain.BusinessCollaboration;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "tbl_file")
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
