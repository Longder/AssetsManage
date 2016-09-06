package com.microdata.assetsmanage.entity;

import java.io.Serializable;
import java.sql.Date;

/**
 * 所有资产实体的父类，抽出共有部分
 * Created by Longder on 2016/9/5.
 */
public class BaseAssets implements Serializable {
    /**
     * 主键
     */
    private Integer id;
    /**
     * 资产ID
     */
    private String assetsId;
    /**
     * 资产类别
     */
    private String assetsType;
    /**
     * 机房名称
     */
    private String roomName;
    /**
     * 机房地点
     */
    private String roomAddress;
    /**
     * 机柜编号
     */
    private String cabinetNo;
    /**
     * 设施名称
     */
    private String name;
    /**
     * 设施生产厂商
     */
    private String manufactorer;
    /**
     * 设施型号
     */
    private String model;
    /**
     * 设施规格
     */
    private String standard;
    /**
     * 设施序列号
     */
    private String serial;
    /**
     * 设施投运时间
     */
    private Date startTime;
    /**
     * 设施用途
     */
    private String use;
    /**
     * 设施所属单位
     */
    private String belongUnit;
    /**
     * 设施运维单位
     */
    private String maintainUnit;
    /**
     * 设施供货商
     */
    private String supplier;
    /**
     * 设施说明
     */
    private String specification;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAssetsId() {
        return assetsId;
    }

    public void setAssetsId(String assetsId) {
        this.assetsId = assetsId;
    }

    public String getAssetsType() {
        return assetsType;
    }

    public void setAssetsType(String assetsType) {
        this.assetsType = assetsType;
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    public String getRoomAddress() {
        return roomAddress;
    }

    public void setRoomAddress(String roomAddress) {
        this.roomAddress = roomAddress;
    }

    public String getCabinetNo() {
        return cabinetNo;
    }

    public void setCabinetNo(String cabinetNo) {
        this.cabinetNo = cabinetNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getManufactorer() {
        return manufactorer;
    }

    public void setManufactorer(String manufactorer) {
        this.manufactorer = manufactorer;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getStandard() {
        return standard;
    }

    public void setStandard(String standard) {
        this.standard = standard;
    }

    public String getSerial() {
        return serial;
    }

    public void setSerial(String serial) {
        this.serial = serial;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public String getUse() {
        return use;
    }

    public void setUse(String use) {
        this.use = use;
    }

    public String getBelongUnit() {
        return belongUnit;
    }

    public void setBelongUnit(String belongUnit) {
        this.belongUnit = belongUnit;
    }

    public String getMaintainUnit() {
        return maintainUnit;
    }

    public void setMaintainUnit(String maintainUnit) {
        this.maintainUnit = maintainUnit;
    }

    public String getSupplier() {
        return supplier;
    }

    public void setSupplier(String supplier) {
        this.supplier = supplier;
    }

    public String getSpecification() {
        return specification;
    }

    public void setSpecification(String specification) {
        this.specification = specification;
    }
}
