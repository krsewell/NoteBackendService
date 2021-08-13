package com.ksdev.notesvc.record;

import javax.persistence.*;

import com.ksdev.notesvc.utils.DocumentIdService;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;


import java.time.Instant;

@Entity
@NoArgsConstructor
public class TextRecord {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @ColumnDefault("''")
    @Column(length = 1024)
    private String title;

    @Column(columnDefinition = "MediumText default ''")
    private String content;

    @Column(name = "created_at")
    @CreatedDate
    private long createdAt;

    @Column(name = "updated_at")
    @LastModifiedDate
    private long updatedAt;

    private String license;

    @Column(name = "document_id", length = 21)
    private String documentId;
    @Version
    private long version;


    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public boolean hasTitle() { return title != null; }

    public String getContent() {
        return content;
    }
    public void setContent(String content) {
        this.content = content;
    }
    public boolean hasContent() { return content != null; }

    public long getCreatedAt() {
        return createdAt;
    }
    public void setCreatedAt(long createdAt) { this.createdAt = createdAt; }

    public long getUpdatedAt() {
        return updatedAt;
    }
    public void setUpdatedAt(long updatedAt) { this.updatedAt = updatedAt; }

    public String getLicense() {
        return license;
    }
    public void setLicense(String license) {
        this.license = license;
    }
    public boolean hasLicense() { return license != null; }

    public String getDocumentId() { return documentId; }
    public void setDocumentId(String documentId) { this.documentId = documentId; }
    public boolean hasDocumentId() { return documentId != null; }

    @PrePersist
    public void onCreate() {
        if (this.createdAt == 0) {
            this.createdAt = this.updatedAt = Instant.now().toEpochMilli();
            this.documentId = DocumentIdService.getNewId();
        }

    }

}
