package com.microdata.assetsmanage.dao;

import com.microdata.assetsmanage.entity.MachineAssets;
import com.microdata.assetsmanage.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Longder on 2016/9/5.
 */
public class MachineAssetsDao {
    /**
     * 添加一个设备资产
     *
     * @param machineAssets
     */
    public void add(MachineAssets machineAssets) {
        try {
            Connection con = DBUtil.getConnection();
            String sql = "INSERT INTO pms_assets_machine(assets_id,assets_type,room_name,room_address,cabinet_no,machine_name,machine_manufacturer,machine_model,machine_standard,machine_serial,machine_start_time,machine_use,machine_belong_unit,machine_maintain_unit,machine_supplier,machine_specification) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement ps = con.prepareStatement(sql);
            generateParams(ps, machineAssets);
            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeConnection();
        }
    }

    /**
     * 根据id删除一个
     *
     * @param id
     */
    public void delete(Integer id) {
        try {
            Connection con = DBUtil.getConnection();
            String sql = "DELETE FROM pms_assets_machine WHERE id=?";
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
     * 更新一条记录
     *
     * @param assets
     */
    public void update(MachineAssets assets) {
        try {
            Connection con = DBUtil.getConnection();
            String sql = "UPDATE pms_assets_machine SET assets_id=?,assets_type=?,room_name=?,room_address=?,cabinet_no=?,machine_name=?,machine_manufacturer=?,machine_model=?,machine_standard=?,machine_serial=?,machine_start_time=?,machine_use=?,machine_belong_unit=?,machine_maintain_unit=?,machine_supplier=?,machine_specification=? WHERE id=?";
            PreparedStatement ps = con.prepareStatement(sql);
            generateParams(ps, assets);
            ps.setInt(17, assets.getId());
            ps.execute();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeConnection();
        }
    }

    /**
     * 根据id查询一条
     *
     * @return
     */
    public MachineAssets findById(Integer id) {
        MachineAssets assets = null;
        try {
            Connection con = DBUtil.getConnection();
            String sql = "SELECT * FROM pms_assets_machine WHERE id=?";
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
     * @param page     页数
     * @param pageSize 页容量
     * @return
     */
    public List<MachineAssets> findByPage(Integer page, Integer pageSize) {
        List<MachineAssets> list = new ArrayList<MachineAssets>();
        try {
            Connection con = DBUtil.getConnection();
            int start = pageSize * page - pageSize;
            int limit = pageSize;
            String sql = "SELECT * FROM pms_assets_machine LIMIT ?,?";
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

    private void generateParams(PreparedStatement ps, MachineAssets assets) throws SQLException {
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
        ps.setDate(11, assets.getStartTime());
        ps.setString(12, assets.getUse());
        ps.setString(13, assets.getBelongUnit());
        ps.setString(14, assets.getMaintainUnit());
        ps.setString(15, assets.getSupplier());
        ps.setString(16, assets.getSpecification());
    }

    /**
     * 根据结果集填充一个对象
     *
     * @return
     */
    private MachineAssets fillEntity(ResultSet rs) throws SQLException {
        MachineAssets assets = new MachineAssets();
        assets.setId(rs.getInt("id"));
        assets.setAssetsId(rs.getString("assets_id"));
        assets.setAssetsType(rs.getString("assets_type"));
        assets.setRoomName(rs.getString("room_name"));
        assets.setRoomAddress(rs.getString("room_address"));
        assets.setCabinetNo(rs.getString("cabinet_no"));
        assets.setName(rs.getString("machine_name"));
        assets.setManufactorer(rs.getString("machine_manufacturer"));
        assets.setModel(rs.getString("machine_model"));
        assets.setStandard(rs.getString("machine_standard"));
        assets.setSerial(rs.getString("machine_serial"));
        assets.setStartTime(rs.getDate("machine_start_time"));
        assets.setUse(rs.getString("machine_use"));
        assets.setBelongUnit(rs.getString("machine_belong_unit"));
        assets.setMaintainUnit(rs.getString("machine_maintain_unit"));
        assets.setSupplier(rs.getString("machine_supplier"));
        assets.setSpecification(rs.getString("machine_specification"));
        return assets;
    }
}
