/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Controller.Koneksi;
import Models.tb_penjualan;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author User
 */
public class SellingDao extends tb_penjualan {

    private Koneksi con;
    private Statement st;
    private ResultSet res;
    private String query;

    public void Save(String idPenjualan, Date tanggal, int totalitem, int total, String nama) {
        con = new Koneksi();
        con.connect();
        try {
            st = con.conn.createStatement();
            query = "insert into tb_penjualan(id_penjualan, tanggal, total_item, total, nama_karyawan)values('" + idPenjualan + "','" + tanggal + "','" + totalitem + "','" + total + "','" + nama + "')";
            st.executeUpdate(query);
            st.close();
            con.conn.close();
            //JOptionPane.showMessageDialog(null, "");
        } catch (SQLException e) {
        }
    }

    public void SaveDetail(String idPenjualan, String namaItem, String namaPelanggan, String alamat, int jumlah, int harga, int total) {
        con = new Koneksi();
        con.connect();
        try {
            st = con.conn.createStatement();
            query = "insert into dt_penjualan(id_penjualan, nama_item, nama_pelanggan, alamat, jumlah, harga, total)values('" + idPenjualan + "','" + namaItem + "','" + namaPelanggan + "','" + alamat + "','" + jumlah + "','" + harga + "','" + total + "')";
            st.executeUpdate(query);
            st.close();
            con.conn.close();
            JOptionPane.showMessageDialog(null, "Data di Tambahkan");
        } catch (SQLException e) {
        }
    }

    public void Update(String idPemasukan, Date tanggal, String nama, String rute, String alamat, int qty, int harga, int total) {
        con = new Koneksi();
        con.connect();
        try {
            st = con.conn.createStatement();
            query = "update tb_penjualan set tanggal='" + tanggal + "', nama ='" + nama + "', rute ='" + rute + "', alamat = '" + alamat + "', qty = '" + qty + "', harga = '" + harga + "', total = '" + total + "' where id_penjualan = '" + idPemasukan + "'";
            st.executeUpdate(query);
            st.close();
            con.conn.close();
            JOptionPane.showMessageDialog(null, "Data Berhasil di Update");
        } catch (SQLException e) {

        }
    }

    public void Delete(String idPenjualan) {
        con = new Koneksi();
        con.connect();
        try {
            st = con.conn.createStatement();
            query = "delete from tb_penjualan where id_penjualan = '" + idPenjualan + "'";
            st.executeUpdate(query);
            st.close();
            con.conn.close();
            JOptionPane.showMessageDialog(null, "Data di Hapus");
        } catch (SQLException e) {

        }
    }

    public String[][] ShowByName(String nama) {

        res = null;
        String[][] data = null;
        con = new Koneksi();
        con.connect();
        int jumlahBaris = 0;
        try {
            st = con.conn.createStatement();
            query = "SELECT COUNT(id_detail) AS Jumlah FROM dt_penjualan";
            res = st.executeQuery(query);
            
            if (res.next()) {
                jumlahBaris = res.getInt("Jumlah");
            }
            //query = "select *from dt_penjualan";
            query = "SELECT "
                    + "c.id_penjualan,"
                    + "c.nama_item,"
                    + "c.nama_pelanggan,"
                    + "c.jumlah,"
                    + "c.total,"
                    + "a.tanggal "
                    + "FROM dt_penjualan c "
                    + "RIGHT JOIN tb_penjualan a "
                    + "ON c.id_penjualan = a.id_penjualan "
                    + "WHERE c.nama_pelanggan = '"+nama+"'";
            
            res = st.executeQuery(query);
            data = new String[jumlahBaris][6];
            int r = 0;
            while (res.next()) {
                data[r][0] = res.getString("c.id_penjualan");
                data[r][1] = res.getString("c.nama_item");
                data[r][2] = res.getString("c.nama_pelanggan");
                data[r][3] = res.getString("c.jumlah");
                data[r][4] = res.getString("c.total");
                data[r][5] = res.getString("a.tanggal");
                r++;
            }
            int jmlBaris = r;
            String[][] tmpArray = data;
            data = new String[jmlBaris][6];
            for (r = 0; r < jmlBaris; r++) {
                for (int c = 0; c < 6; c++) {
                    data[r][c] = tmpArray[r][c];
                }
            }
            st.close();
            con.conn.close();
        } catch (SQLException e) {
            System.err.println("SQLException : " + e.getMessage());
        }
        return data;
    }
    
    public String[][] ShowByDate(Date dari, Date sampai) {

        res = null;
        String[][] data = null;
        con = new Koneksi();
        con.connect();
        int jumlahBaris = 0;
        try {
            st = con.conn.createStatement();
            query = "SELECT COUNT(id_detail) AS Jumlah FROM dt_penjualan";
            res = st.executeQuery(query);
            
            if (res.next()) {
                jumlahBaris = res.getInt("Jumlah");
            }
            //query = "select *from dt_penjualan";
            query = "SELECT "
                    + "c.id_penjualan,"
                    + "c.nama_item,"
                    + "c.nama_pelanggan,"
                    + "c.jumlah,"
                    + "c.total,"
                    + "a.tanggal "
                    + "FROM dt_penjualan c "
                    + "RIGHT JOIN tb_penjualan a "
                    + "ON c.id_penjualan = a.id_penjualan WHERE a.tanggal BETWEEN '"+dari+"' AND '"+sampai+"' ";
            
            res = st.executeQuery(query);
            data = new String[jumlahBaris][6];
            int r = 0;
            while (res.next()) {
                data[r][0] = res.getString("c.id_penjualan");
                data[r][1] = res.getString("c.nama_item");
                data[r][2] = res.getString("c.nama_pelanggan");
                data[r][3] = res.getString("c.jumlah");
                data[r][4] = res.getString("c.total");
                data[r][5] = res.getString("a.tanggal");
                r++;
            }
            int jmlBaris = r;
            String[][] tmpArray = data;
            data = new String[jmlBaris][6];
            for (r = 0; r < jmlBaris; r++) {
                for (int c = 0; c < 6; c++) {
                    data[r][c] = tmpArray[r][c];
                }
            }
            st.close();
            con.conn.close();
        } catch (SQLException e) {
            System.err.println("SQLException : " + e.getMessage());
        }
        return data;
    }
    
    public String[][] Show() {

        res = null;
        String[][] data = null;
        con = new Koneksi();
        con.connect();
        int jumlahBaris = 0;
        try {
            st = con.conn.createStatement();
            query = "SELECT COUNT(id_detail) AS Jumlah FROM dt_penjualan";
            res = st.executeQuery(query);
            
            if (res.next()) {
                jumlahBaris = res.getInt("Jumlah");
            }
            //query = "select *from dt_penjualan";
            query = "SELECT "
                    + "c.id_penjualan,"
                    + "c.nama_item,"
                    + "c.nama_pelanggan,"
                    + "c.jumlah,"
                    + "c.total,"
                    + "a.tanggal "
                    + "FROM dt_penjualan c "
                    + "RIGHT JOIN tb_penjualan a "
                    + "ON c.id_penjualan = a.id_penjualan ";
            
            res = st.executeQuery(query);
            data = new String[jumlahBaris][6];
            int r = 0;
            while (res.next()) {
                data[r][0] = res.getString("c.id_penjualan");
                data[r][1] = res.getString("c.nama_item");
                data[r][2] = res.getString("c.nama_pelanggan");
                data[r][3] = res.getString("c.jumlah");
                data[r][4] = res.getString("c.total");
                data[r][5] = res.getString("a.tanggal");
                r++;
            }
            int jmlBaris = r;
            String[][] tmpArray = data;
            data = new String[jmlBaris][6];
            for (r = 0; r < jmlBaris; r++) {
                for (int c = 0; c < 6; c++) {
                    data[r][c] = tmpArray[r][c];
                }
            }
            st.close();
            con.conn.close();
        } catch (SQLException e) {
            System.err.println("SQLException : " + e.getMessage());
        }
        return data;
    }
}
