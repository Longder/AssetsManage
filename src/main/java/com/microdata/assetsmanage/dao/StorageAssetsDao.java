package com.microdata.assetsmanage.dao;

import com.microdata.assetsmanage.entity.StorageAssets;
import com.microdata.assetsmanage.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * 存储设备资产Dao
 * Created by Longder on 2016/9/5.
 */
public class StorageAssetsDao {
    /**
     * 新增一条
     *
     * @param assets
     */
    public void add(StorageAssets assets) {
        try {
            Connection con = DBUtil.getConnection();
            String sql = "INSERT INTO pms_assets_storage(assets_id,assets_type,room_name,room_address,cabinet_no,storage_name,storage_manufacturer,storage_model,storage_standard,storage_serial,storage_cache,storage_capacity,storage_total_size,storage_start_time,storage_ip,storage_use,storage_belong_unit,storage_maintain_unit,storage_supplier,storage_specification) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement ps = con.prepareStatement(sql);
            generateParams(ps, assets);
            ps.execute();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeConnection();
        }
    }

    /**
     * 根据id删除一条
     */
    public void delete(Integer id) {
        try {
            Connection con = DBUtil.getConnection();
            String sql = "DELETE FROM pms_assets_storage WHERE id=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ps.execute();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeConnection();
        }
    }

    /**
     * 更新一条
     */
    private void update(StorageAssets assets) {
        try {
            Connection con = DBUtil.getConnection();
            String sql = "UPDATE pms_assets_storage SET assets_id=?,assets_type=?,room_name=?,room_address=?,cabinet_no=?,storage_name=?,storage_manufacturer=?,storage_model=?,storage_standard=?,storage_serial=?,storage_cache=?,storage_capacity=?,storage_total_size=?,storage_start_time=?,storage_ip=?,storage_use=?,storage_belong_unit=?,storage_maintain_unit=?,storage_supplier=?,storage_specification=? WHERE id=?";
            PreparedStatement ps = con.prepareStatement(sql);
            generateParams(ps, assets);
            ps.setInt(21, assets.getId());
            ps.execute();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeConnection();
        }
    }

    /**
     * 根据ID查询一条
     *
     * @param id
     * @return
     */
    public StorageAssets findById(Integer id) {
        StorageAssets assets = null;
        try {
            Connection con = DBUtil.getConnection();
            String sql = "SELECT * FROM pms_assets_storage WHERE id=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                assets = fillEntity(rs);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeConnection();
        }
        return assets;
    }

    /**
     * 分页查询
     *
     * @param page
     * @param pageSize
     * @return
     */
    public List<StorageAssets> findByPage(Integer page, Integer pageSize) {
        List<StorageAssets> list = new ArrayList<StorageAssets>();
        try {
            Connection con = DBUtil.getConnection();
            int start = pageSize * page - pageSize;
            int limit = pageSize;
            String sql = "SELECT * FROM pms_assets_storage LIMIT ?,?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, start);
            ps.setInt(2, limit);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(fillEntity(rs));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeConnection();
        }
        return list;
    }

    private void generateParams(PreparedStatement ps, StorageAssets assets) throws SQLException {
        ps.setString(1, assets.getAssetsId());
        ps.setString(2, assets.getAssetsType());
        ps.setString(3, assets.getRoomName());
        ps.setString(4, assets.getRoomAddress());
        ps.setString(5, assets.getCabinetNo());
        ps.setString(6, assets.getName());
        ps.setString(7, assets.getManufactorer());
        ps.setString(8, assets.getModel());
        ps.setString(9, assets.getStandard());
        ps.setString(10, assets.getSerial());
        ps.setString(11, assets.getCache());
        ps.setString(12, assets.getCapacity());
        ps.setString(13, assets.getTotalSize());
        ps.setDate(14, assets.getStartTime());
        ps.setString(15, assets.getIp());
        ps.setString(16, assets.getUse());
        ps.setString(17, assets.getBelongUnit());
        ps.setString(18, assets.getMaintainUnit());
        ps.setString(19, assets.getSupplier());
        ps.setString(20, assets.getSpecification());
    }

    /**
     * 根据结果集填充一个对象
     *
     * @return
     */
    private StorageAssets fillEntity(ResultSet rs) throws SQLException {
        StorageAssets assets = new StorageAssets();
        assets.setId(rs.getInt("id"));
        assets.setAssetsId(rs.getString("assets_id"));
        assets.setAssetsType(rs.getString("assets_type"));
        assets.setRoomName(rs.getString("room_name"));
        assets.setRoomAddress(rs.getString("room_address"));
        assets.setCabinetNo(rs.getString("cabinet_no"));
        assets.setName(rs.getString("storage_name"));
        assets.setManufactorer(rs.getString("storage_manufacturer"));
        assets.setModel(rs.getString("storage_model"));
        assets.setStandard(rs.getString("storage_standard"));
        assets.setSerial(rs.getString("storage_serial"));
        assets.setStartTime(rs.getDate("storage_start_time"));
        assets.setUse(rs.getString("storage_use"));
        assets.setBelongUnit(rs.getString("storage_belong_unit"));
        assets.setMaintainUnit(rs.getString("storage_maintain_unit"));
        assets.setSupplier(rs.getString("storage_supplier"));
        assets.setSpecification(rs.getString("storage_specification"));
        assets.setCache(rs.getString("storage_cache"));
        assets.setCapacity(rs.getString("storage_capacity"));
        assets.setTotalSize(rs.getString("storage_total_size"));
        assets.setIp(rs.getString("storage_ip"));
        return assets;
    }
}
