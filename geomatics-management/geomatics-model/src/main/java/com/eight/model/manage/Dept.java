package com.eight.model.manage;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import javax.persistence.*;

@Table(name = "t_dept")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class Dept {
    /**
     * 部门ID
     */
    @Id
    @Column(name = "DEPT_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long deptId;

    /**
     * 上级部门ID
     */
    @Column(name = "PARENT_ID")
    private Long parentId;

    /**
     * 部门名称
     */
    @Column(name = "DEPT_NAME")
    private String deptName;

    /**
     * 排序
     */
    @Column(name = "ORDER_NUM")
    private Double orderNum;

    /**
     * 创建时间
     */
    @Column(name = "CREATE_TIME")
    private String createTime;

    /**
     * 修改时间
     */
    @Column(name = "MODIFY_TIME")
    private String modifyTime;
}