package com.microdata.assetsmanage.test;

import com.microdata.assetsmanage.dao.MachineAssetsDao;
import com.microdata.assetsmanage.dao.NetworkAssetsDao;
import com.microdata.assetsmanage.dao.StorageAssetsDao;
import com.microdata.assetsmanage.entity.MachineAssets;
import com.microdata.assetsmanage.entity.NetworkAssets;
import com.microdata.assetsmanage.entity.StorageAssets;
import org.junit.Test;

import java.util.List;

/**
 * Created by Longder on 2016/9/5.
 */
public class DaoTest {
    @Test
    public void testAdd() {
        //MachineAssetsDao dao = new MachineAssetsDao();
        //MachineAssets assets = new MachineAssets();
        //NetworkAssetsDao dao = new NetworkAssetsDao();
        //ServerAssetsDao dao = new ServerAssetsDao();
        StorageAssetsDao dao = new StorageAssetsDao();
        StorageAssets assets = new StorageAssets();
        assets.setAssetsId("123");
        assets.setAssetsType("交换机");
        assets.setRoomName("房间一");
        assets.setRoomAddress("大树营");
        assets.setCabinetNo("321");
        assets.setName("设施1");
        assets.setManufactorer("制造商");
        assets.setModel("型号2");
        assets.setIp("114.114.114.114");
        assets.setStandard("端口数");
        assets.setSerial("序列号");
        assets.setUse("用途");
        assets.setBelongUnit("所属单位");
        assets.setMaintainUnit("维护单位");
        assets.setSpecification("说明说明");
        assets.setCache("缓存十分大！");
        assets.setTotalSize("总量很牛B");
        assets.setCapacity("规格也不错");
        dao.add(assets);
    }

    @Test
    public void testUpdate() {
        NetworkAssetsDao dao = new NetworkAssetsDao();
        NetworkAssets assets = new NetworkAssets();
        assets.setId(1);
        assets.setAssetsId("123334555");
        assets.setAssetsType("空调33");
        assets.setRoomName("房间二");
        assets.setRoomAddress("大树营");
        assets.setCabinetNo("321");
        assets.setName("设施2");
        assets.setManufactorer("制造商");
        assets.setModel("型号444");
        assets.setStandard("端口数");
        assets.setSerial("序列号222");
        assets.setIp("169.168.1.1");
        assets.setUse("用途222");
        assets.setBelongUnit("所属单位222");
        assets.setMaintainUnit("维护单位222");
        assets.setSpecification("说明说明222");
        dao.update(assets);
    }

    @Test
    public void testDelete() {
        MachineAssetsDao dao = new MachineAssetsDao();
        dao.delete(2);
    }

    @Test
    public void testFindById() {
        /*NetworkAssetsDao dao = new NetworkAssetsDao();
        NetworkAssets assets = dao.findById(1);
        System.out.println(assets.getIp());*/
        StorageAssetsDao dao = new StorageAssetsDao();
        StorageAssets entity = dao.findById(1);
        System.out.println(entity.getTotalSize());
    }

    @Test
    public void testFindByPage() {
        MachineAssetsDao dao = new MachineAssetsDao();
        List<MachineAssets> list = dao.findByPage(1,1);
        System.out.println(list.size());
    }
}
