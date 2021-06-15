package com.lh.springboottemplate.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.Instant;

/**
 * 基础的实体对象.
 *
 * @author lh
 */
@Data
@EntityListeners(AuditingEntityListener.class)
@MappedSuperclass
@AllArgsConstructor
@NoArgsConstructor
public class BaseEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @CreatedBy private Long createdBy;

  @Column(columnDefinition = "timestamp with time zone not null")
  @CreatedDate
  private Instant createdTime;

  @LastModifiedBy private Long lastModifiedBy;

  @Column(columnDefinition = "timestamp with time zone")
  @LastModifiedDate
  private Instant lastModifiedTime;
}
