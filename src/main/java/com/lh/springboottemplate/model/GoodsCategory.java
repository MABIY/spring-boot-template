package com.lh.springboottemplate.model;

import lombok.*;
import lombok.experimental.Accessors;

import javax.persistence.*;

/**
 * 商品分类.
 *
 * @author lh
 */
@Data
@Builder
@EqualsAndHashCode(callSuper = true)
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
@Table(
    name = "goods_category",
    indexes = {@Index(columnList = "code")},
    uniqueConstraints = {
      @UniqueConstraint(columnNames = {"goodsType","merchantId", "categoryName"}),
      @UniqueConstraint(columnNames = {"merchantId", "code"}),
    })
public class GoodsCategory extends BaseEntity {

  @Column(updatable = false, nullable = false)
  private Long code;

  @Column(updatable = false, nullable = false)
  private Long merchantId;

  @Column(updatable = false, nullable = false)
  @Builder.Default
  private Long parentCode = 0L;

  /** 分类名称 */
  @Column(length = 100)
  private String categoryName;

  /** 分类类型 */
  @Enumerated(EnumType.STRING)
  @Column(nullable = false)
  private GoodsType goodsType;

  /** 排序字段 */
  @Column(nullable = false)
  private Long rank;

  /**
   * 关联商品数量
   */
  @Transient
  private Long relevancyGoodsCount;

  /** 商品类型 */
  public enum GoodsType {

    /** 设备 */
    DEVICE,
    /** IP */
    IP,
    /** 耗材 */
    COMPONENT,
    /** 软件工具 */
    SOFT_TOOLS,
  }
}
