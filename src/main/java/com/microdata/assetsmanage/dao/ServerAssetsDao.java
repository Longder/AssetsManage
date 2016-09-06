package com.microdata.assetsmanage.dao;

import com.microdata.assetsmanage.entity.ServerAssets;
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
public class ServerAssetsDao {
    /**
     * 添加一个
     *
     * @param assets
     */
    public void add(ServerAssets assets) {
        try {
            Connection con = DBUtil.getConnection();
            String sql = "INSERT INTO pms_assets_server(assets_id,assets_type,room_name,room_address,cabinet_no,server_name,server_manufacturer,server_model,server_standard,server_serial,server_hard_disk,server_cpu,server_memory,server_raid_card,server_hba_card,server_network_card,server_start_time,server_ip,server_use,server_belong_unit,server_maintain_unit,server_supplier,server_specification) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
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
     * 根据id删除
     *
     * @param id
     */
    public void delete(Integer id) {
        try {
            Connection con = DBUtil.getConnection();
            String sql = "DELETE FROM pms_assets_server WHERE id=?";
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
    public void update(ServerAssets assets) {
        try {
            Connection con = DBUtil.getConnection();
            String sql = "UPDATE pms_assets_server SET assets_id=?,assets_type=?,room_name=?,room_address=?,cabinet_no=?,server_name=?,server_manufacturer=?,server_model=?,server_standard=?,server_serial=?,server_hard_disk=?,server_cpu=?,server_memory=?,server_raid_card=?,server_hba_card=?,server_network_card=?,server_start_time=?,server_ip=?,server_use=?,server_belong_unit=?,server_maintain_unit=?,server_supplier=?,server_specification=? WHERE id=?";
            PreparedStatement ps = con.prepareStatement(sql);
            generateParams(ps, assets);
            ps.setInt(24, assets.getId());
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
    public ServerAssets findById(Integer id) {
        ServerAssets assets = null;
        try {
            Connection con = DBUtil.getConnection();
            String sql = "SELECT * FROM pms_assets_server WHERE id=?";
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
    public List<ServerAssets> findByPage(Integer page, Integer pageSize) {
        List<ServerAssets> list = new ArrayList<ServerAssets>();
        try {
            Connection con = DBUtil.getConnection();
            int start = pageSize * page - pageSize;
            int limit = pageSize;
            String sql = "SELECT * FROM pms_assets_server LIMIT ?,?";
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

    private void generateParams(PreparedStatement ps, ServerAssets assets) throws SQLException {
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
        ps.setString(11, assets.getHardDisk());
        ps.setString(12, assets.getCpu());
        ps.setString(13, assets.getMemory());
        ps.setString(14, assets.getRaidCard());
        ps.setString(15, assets.getHbaCard());
        ps.setString(16, assets.getNetworkCard());
        ps.setDate(17, assets.getStartTime());
        ps.setString(18, assets.getIp());
        ps.setString(19, assets.getUse());
        ps.setString(20, assets.getBelongUnit());
        ps.setString(21, assets.getMaintainUnit());
        ps.setString(22, assets.getSupplier());
        ps.setString(23, assets.getSpecification());
    }

    /**
     * 根据结果集填充一个对象
     *
     * @return
     */
    private ServerAssets fillEntity(ResultSet rs) throws SQLException {
        ServerAssets assets = new ServerAssets();
        assets.setId(rs.getInt("id"));
        assets.setAssetsId(rs.getString("assets_id"));
        assets.setAssetsType(rs.getString("assets_type"));
        assets.setRoomName(rs.getString("room_name"));
        assets.setRoomAddress(rs.getString("room_address"));
        assets.setCabinetNo(rs.getString("cabinet_no"));
        assets.setName(rs.getString("server_name"));
        assets.setManufactorer(rs.getString("server_manufacturer"));
        assets.setModel(rs.getString("server_model"));
        assets.setStandard(rs.getString("server_standard"));
        assets.setSerial(rs.getString("server_serial"));
        assets.setStartTime(rs.getDate("server_start_time"));
        assets.setUse(rs.getString("server_use"));
        assets.setBelongUnit(rs.getString("server_belong_unit"));
        assets.setMaintainUnit(rs.getString("server_maintain_unit"));
        assets.setSupplier(rs.getString("server_supplier"));
        assets.setSpecification(rs.getString("server_specification"));
        assets.setHardDisk(rs.getString("server_hard_disk"));
        assets.setCpu(rs.getString("server_cpu"));
        assets.setMemory(rs.getString("server_memory"));
        assets.setRaidCard(rs.getString("server_raid_card"));
        assets.setHbaCard(rs.getString("server_hba_card"));
        assets.setNetworkCard(rs.getString("server_network_card"));
        assets.setIp(rs.getString("server_ip"));
        return assets;
    }
}
