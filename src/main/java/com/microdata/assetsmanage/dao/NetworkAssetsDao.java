package com.microdata.assetsmanage.dao;

import com.microdata.assetsmanage.entity.MachineAssets;
import com.microdata.assetsmanage.entity.NetworkAssets;
import com.microdata.assetsmanage.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * 网络设备资产dao
 * Created by Longder on 2016/9/5.
 */
public class NetworkAssetsDao {
    /**
     * 添加一个网络设备资产
     *
     * @param networkAssets
     */
    public void add(NetworkAssets networkAssets) {
        try {
            Connection con = DBUtil.getConnection();
            String sql = "INSERT INTO pms_assets_network(assets_id,assets_type,room_name,room_address,cabinet_no,network_name,network_manufacturer,network_model,network_standard,network_serial,network_start_time,network_ip,network_use,network_belong_unit,network_maintain_unit,network_supplier,network_specification) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement ps = con.prepareStatement(sql);
            generateParams(ps, networkAssets);
            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeConnection();
        }
    }

    /**
     * 根据id删除一条记录
     *
     * @param id
     */
    public void delete(Integer id) {
        try {
            Connection con = DBUtil.getConnection();
            String sql = "DELECT FROM pms_assets_network WHERE id=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ps.execute();
        } catch (SQLException e) {
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
    public void update(NetworkAssets assets) {
        try {
            Connection con = DBUtil.getConnection();
            String sql = "UPDATE pms_assets_network SET assets_id=?,assets_type=?,room_name=?,room_address=?,cabinet_no=?,network_name=?,network_manufacturer=?,network_model=?,network_standard=?,network_serial=?,network_start_time=?,network_ip=?,network_use=?,network_belong_unit=?,network_maintain_unit=?,network_supplier=?,network_specification=? WHERE id=?";
            PreparedStatement ps = con.prepareStatement(sql);
            generateParams(ps, assets);
            ps.setInt(18, assets.getId());
            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeConnection();
        }
    }

    /**
     * 根据id查询一个
     */
    public NetworkAssets findById(Integer id) {
        NetworkAssets assets = null;
        try {
            Connection con = DBUtil.getConnection();
            String sql = "SELECT * FROM pms_assets_network WHERE id=?";
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
    public List<NetworkAssets> findByPage(Integer page, Integer pageSize) {
        List<NetworkAssets> list = new ArrayList<NetworkAssets>();
        try {
            Connection con = DBUtil.getConnection();
            int start = pageSize * page - pageSize;
            int limit = pageSize;
            String sql = "SELECT * FROM pms_assets_network LIMIT ?,?";
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

    private void generateParams(PreparedStatement ps, NetworkAssets assets) throws SQLException {
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
        ps.setString(12, assets.getIp());//IP地址
        ps.setString(13, assets.getUse());
        ps.setString(14, assets.getBelongUnit());
        ps.setString(15, assets.getMaintainUnit());
        ps.setString(16, assets.getSupplier());
        ps.setString(17, assets.getSpecification());
    }

    /**
     * 根据结果集填充一个对象
     *
     * @return
     */
    private NetworkAssets fillEntity(ResultSet rs) throws SQLException {
        NetworkAssets assets = new NetworkAssets();
        assets.setId(rs.getInt("id"));
        assets.setAssetsId(rs.getString("assets_id"));
        assets.setAssetsType(rs.getString("assets_type"));
        assets.setRoomName(rs.getString("room_name"));
        assets.setRoomAddress(rs.getString("room_address"));
        assets.setCabinetNo(rs.getString("cabinet_no"));
        assets.setName(rs.getString("network_name"));
        assets.setManufactorer(rs.getString("network_manufacturer"));
        assets.setModel(rs.getString("network_model"));
        assets.setStandard(rs.getString("network_standard"));
        assets.setSerial(rs.getString("network_serial"));
        assets.setStartTime(rs.getDate("network_start_time"));
        assets.setIp(rs.getString("network_ip"));
        assets.setUse(rs.getString("network_use"));
        assets.setBelongUnit(rs.getString("network_belong_unit"));
        assets.setMaintainUnit(rs.getString("network_maintain_unit"));
        assets.setSupplier(rs.getString("network_supplier"));
        assets.setSpecification(rs.getString("network_specification"));
        return assets;
    }
}
