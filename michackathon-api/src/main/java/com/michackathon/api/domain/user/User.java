package com.michackathon.api.domain.user;

import com.michackathon.api.domain.base.AuditedEntity;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by Tomcy John
 */
@Entity
@Table(name = "USER")
public class User extends AuditedEntity {

}
