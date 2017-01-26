package com.softtek.academy.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class Audit implements Serializable {

	private static final long serialVersionUID = 1L;

	@Column(name = "CREATED_DATE", nullable = false, updatable = false)
	@CreatedDate
	private Date createdDate;

	@Column(name = "MODIFIED_DATE", nullable = false, updatable = false)
	@LastModifiedDate
	private Date modifiedDate;

	@PrePersist
	protected void onCreate() {
		createdDate = new Date();
		modifiedDate = new Date();
	}

}
