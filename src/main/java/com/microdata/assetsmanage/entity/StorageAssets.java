package com.microdata.assetsmanage.entity;

/**
 * 存储设备资产
 * Created by Longder on 2016/9/5.
 */
public class StorageAssets extends BaseAssets {
    /**
     * 缓存配置
     */
    private String cache;
    /**
     * 容量规格
     */
    private String capacity;
    /**
     * 总容量
     */
    private String totalSize;
    /**
     * ip地址
     */
    private String ip;

    public String getCache() {
        return cache;
    }

    public void setCache(String cache) {
        this.cache = cache;
    }

    public String getCapacity() {
        return capacity;
    }

    public void setCapacity(String capacity) {
        this.capacity = capacity;
    }

    public String getTotalSize() {
        return totalSize;
    }

    public void setTotalSize(String totalSize) {
        this.totalSize = totalSize;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }
}
