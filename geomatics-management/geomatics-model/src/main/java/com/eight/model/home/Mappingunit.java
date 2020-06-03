package com.eight.model.home;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import javax.persistence.*;

@Table(name = "t_mapping_unit")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class Mappingunit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    /**
     * 单位名称
     */
    @Column(name = "unit_name")
    private String unitName;

    /**
     * 所属行政区
     */
    @Column(name = "owned_district")
    private String ownedDistrict;

    /**
     * 资质等级
     */
    @Column(name = "qualification_level")
    private String qualificationLevel;




    /**
     * 获取单位名称
     *
     * @return unit_name - 单位名称
     */
    public String getUnitName() {
        return unitName;
    }

    /**
     * 设置单位名称
     *
     * @param unitName 单位名称
     */
    public void setUnitName(String unitName) {
        this.unitName = unitName == null ? null : unitName.trim();
    }

    /**
     * 获取所属行政区
     *
     * @return owned_district - 所属行政区
     */
    public String getOwnedDistrict() {
        return ownedDistrict;
    }

    /**
     * 设置所属行政区
     *
     * @param ownedDistrict 所属行政区
     */
    public void setOwnedDistrict(String ownedDistrict) {
        this.ownedDistrict = ownedDistrict == null ? null : ownedDistrict.trim();
    }

    /**
     * 获取资质等级
     *
     * @return qualification_level - 资质等级
     */
    public String getQualificationLevel() {
        return qualificationLevel;
    }

    /**
     * 设置资质等级
     *
     * @param qualificationLevel 资质等级
     */
    public void setQualificationLevel(String qualificationLevel) {
        this.qualificationLevel = qualificationLevel == null ? null : qualificationLevel.trim();
    }



}