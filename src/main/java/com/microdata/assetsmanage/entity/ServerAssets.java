package com.microdata.assetsmanage.entity;

/**
 * 服务器资产
 * Created by Longder on 2016/9/5.
 */
public class ServerAssets extends BaseAssets {
    /**
     * 硬盘配置
     */
    private String hardDisk;
    /**
     * cpu配置
     */
    private String cpu;
    /**
     * 内存配置
     */
    private String memory;
    /**
     * RAID卡型号
     */
    private String raidCard;
    /**
     * HBA卡信息
     */
    private String hbaCard;
    /**
     * 网卡信息
     */
    private String networkCard;
    /**
     * ip地址
     */
    private String ip;

    public String getHardDisk() {
        return hardDisk;
    }

    public void setHardDisk(String hardDisk) {
        this.hardDisk = hardDisk;
    }

    public String getCpu() {
        return cpu;
    }

    public void setCpu(String cpu) {
        this.cpu = cpu;
    }

    public String getMemory() {
        return memory;
    }

    public void setMemory(String memory) {
        this.memory = memory;
    }

    public String getRaidCard() {
        return raidCard;
    }

    public void setRaidCard(String raidCard) {
        this.raidCard = raidCard;
    }

    public String getHbaCard() {
        return hbaCard;
    }

    public void setHbaCard(String hbaCard) {
        this.hbaCard = hbaCard;
    }

    public String getNetworkCard() {
        return networkCard;
    }

    public void setNetworkCard(String networkCard) {
        this.networkCard = networkCard;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }
}
