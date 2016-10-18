package com.michackathon.api.domain.base;

import com.michackathon.api.domain.travelHistory.User;
import org.hibernate.envers.Audited;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.EntityListeners;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
import javax.persistence.Version;
import java.time.LocalDateTime;

/**
 * Created by Tomasz Kucharzyk
 */
@Audited
@EntityListeners(AuditingEntityListener.class)
@MappedSuperclass
public class AuditedEntity extends BaseEntity {

    @CreatedDate
    protected LocalDateTime createdDate;

    @CreatedBy
    @ManyToOne
    protected User createdBy;

    @LastModifiedDate
    protected LocalDateTime updatedDate;

    @LastModifiedBy
    @ManyToOne
    protected User updatedBy;

    @Version
    protected Long version;

    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    public User getCreatedBy() {
        return createdBy;
    }

    public LocalDateTime getUpdatedDate() {
        return updatedDate;
    }

    public User getUpdatedBy() {
        return updatedBy;
    }

    public Long getVersion() {
        return version;
    }
}
