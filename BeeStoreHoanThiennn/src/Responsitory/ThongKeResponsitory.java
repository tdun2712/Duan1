/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Responsitory;

import Responsitory_IPL.DBContext;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author phamt
 */
public class ThongKeResponsitory {
    
    public double getDoanhThuCaNam(int year) {
        String sql="""
                   select SUM(TongTien) from HoaDon where YEAR(NgayTao)=? and TrangThai=N'Đã Thanh Toán'
                   """;
        try(Connection con=DBContext.getConnection();PreparedStatement ps=con.prepareStatement(sql)){
            ps.setObject(1, year);
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                return rs.getDouble(1);
            }
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return 0.0;
    }


    public double getDoanhThuToDay(LocalDate toDay) {
        String sql="""
                   select SUM(TongTien) from HoaDon where NgayTao=? and TrangThai=N'Đã Thanh Toán'
                   """;
        try(Connection con=DBContext.getConnection();PreparedStatement ps=con.prepareStatement(sql)){
            ps.setObject(1, toDay);
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                return rs.getDouble(1);
            }
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return 0.0;
    }


    public double getDoanhThu7NgayGanNhat() {
        String sql="""
                   select SUM(TongTien) from HoaDon where NgayTao>=DATEADD(DAY,-7,GETDATE()) and TrangThai=N'Đã Thanh Toán'
                   """;
        try(Connection con=DBContext.getConnection();PreparedStatement ps=con.prepareStatement(sql)){
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                return rs.getDouble(1);
            }
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return 0.0;
    }


    public double getDoanhThuThangNay(String firstDayInMonth, LocalDate toDay) {
        String sql="""
                   select SUM(TongTien) from HoaDon where NgayTao between ? and ? and TrangThai=N'Đã Thanh Toán'
                   """;
        try(Connection con=DBContext.getConnection();PreparedStatement ps=con.prepareStatement(sql)){
            ps.setObject(1, firstDayInMonth);
            ps.setObject(2, toDay);
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                return rs.getDouble(1);
            }
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return 0.0;
    }


    public List<Object[]> LocDoanhThuTheoNgay(String from, String to) {
        String sql="""
                   {CALL pr_LocDoanhThuTheoNgay(?,?)}
                   """;
        String cols[]={"ngayTao","doanhThu"};
        try(Connection con=DBContext.getConnection();PreparedStatement ps=con.prepareCall(sql)){
            ps.setObject(1, from);
            ps.setObject(2, to);
            ResultSet rs=ps.executeQuery();
            List<Object[]> list=new ArrayList<>();
            while(rs.next()){
                Object[] vals=new Object[cols.length];
                for(int i=0;i<cols.length;i++){
                    vals[i]=rs.getObject(cols[i]);
                }
                list.add(vals);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }


    public List<Object[]> DoanhThuSanPham() {
        String sql="""
                   {CALL pr_DoanhThuSanPham}
                   """;
        String cols[]={"maSanPham","tenSanPham","soLuongTon","donGia","soLuongBanDuoc","doanhThuTuSanPham"};
        try(Connection con=DBContext.getConnection();PreparedStatement ps=con.prepareCall(sql)){
            ResultSet rs=ps.executeQuery();
            List<Object[]> list=new ArrayList<>();
            while(rs.next()){
                Object[] vals=new Object[cols.length];
                for(int i=0;i<cols.length;i++){
                    vals[i]=rs.getObject(cols[i]);
                }
                list.add(vals);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }


    public List<Object[]> DoanhThuSanPhamTheoTenSP(String tenLoaiSP) {
        String sql="""
                   {CALL pr_DoanhThuSanPhamTheoTenSanPham(?)}
                   """;
        String cols[]={"maSanPham","tenSanPham","soLuongTon","donGia","soLuongBanDuoc","doanhThuTuSanPham"};
        try(Connection con=DBContext.getConnection();PreparedStatement ps=con.prepareCall(sql)){
            ps.setObject(1, tenLoaiSP);
            ResultSet rs=ps.executeQuery();
            List<Object[]> list=new ArrayList<>();
            while(rs.next()){
                Object[] vals=new Object[cols.length];
                for(int i=0;i<cols.length;i++){
                    vals[i]=rs.getObject(cols[i]);
                }
                list.add(vals);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }


//    public Object[] DoanhThuSanPhamNhieuNhat() {
//        String sql="""
//                   {CALL pr_DoanhThuSanPhamNhieuNhat}
//                   """;
//        String cols[]={"maSanPham","tenSanPham","soLuongTon","donGia","soLuongBanDuoc","doanhThuTuSanPham"};
//        try(Connection con=DBContext.getConnection();PreparedStatement ps=con.prepareCall(sql)){
//            ResultSet rs=ps.executeQuery();
//            while(rs.next()){
//                Object[] vals=new Object[cols.length];
//                for(int i=0;i<cols.length;i++){
//                    vals[i]=rs.getObject(cols[i]);
//                }
//                return vals;
//            }
//        } catch (Exception e) {
//            e.printStackTrace(System.out);
//        }
//        return null;
//    }
//
//
//    public Object[] DoanhThuSanPhamItNhat() {
//        String sql="""
//                   {CALL pr_DoanhThuSanPhamItNhat}
//                   """;
//        String cols[]={"maSanPham","tenSanPham","soLuongTon","donGia","soLuongBanDuoc","doanhThuTuSanPham"};
//        try(Connection con=DBContext.getConnection();PreparedStatement ps=con.prepareCall(sql)){
//            ResultSet rs=ps.executeQuery();
//            while(rs.next()){
//                Object[] vals=new Object[cols.length];
//                for(int i=0;i<cols.length;i++){
//                    vals[i]=rs.getObject(cols[i]);
//                }
//                return vals;
//            }
//        } catch (Exception e) {
//            e.printStackTrace(System.out);
//        }
//        return null;
//    }
//
//
//    public Object[] SanPhamBanNhieuNhat() {
//        String sql="""
//                   {CALL pr_SanPhamBanNhieuNhat}
//                   """;
//        String cols[]={"maSanPham","tenSanPham","soLuongTon","donGia","soLuongBanDuoc","doanhThuTuSanPham"};
//        try(Connection con=DBContext.getConnection();PreparedStatement ps=con.prepareCall(sql)){
//            ResultSet rs=ps.executeQuery();
//            while(rs.next()){
//                Object[] vals=new Object[cols.length];
//                for(int i=0;i<cols.length;i++){
//                    vals[i]=rs.getObject(cols[i]);
//                }
//                return vals;
//            }
//        } catch (Exception e) {
//            e.printStackTrace(System.out);
//        }
//        return null;
//    }
//
//
//    public Object[] SanPhamBanItNhat() {
//        String sql="""
//                   {CALL pr_SanPhamBanItNhat}
//                   """;
//        String cols[]={"maSanPham","tenSanPham","soLuongTon","donGia","soLuongBanDuoc","doanhThuTuSanPham"};
//        try(Connection con=DBContext.getConnection();PreparedStatement ps=con.prepareCall(sql)){
//            ResultSet rs=ps.executeQuery();
//            while(rs.next()){
//                Object[] vals=new Object[cols.length];
//                for(int i=0;i<cols.length;i++){
//                    vals[i]=rs.getObject(cols[i]);
//                }
//                return vals;
//            }
//        } catch (Exception e) {
//            e.printStackTrace(System.out);
//        }
//        return null;
//    }
//
//
//    public int soSanPhamDangKinhDoanh() {
//        String sql="""
//                   select COUNT(*) from Dep where TrangThai=0
//                   """;
//        try(Connection con=DBContext.getConnection();PreparedStatement ps=con.prepareCall(sql)){
//            ResultSet rs=ps.executeQuery();
//            while(rs.next()){
//                return rs.getInt(1);
//            }
//        } catch (Exception e) {
//            e.printStackTrace(System.out);
//        }
//        return 0;
//    }
//
//
//    public int soSanPhamHetHang() {
//        String sql="""
//                   select COUNT(*) from DepChiTiet where SoLuong=0
//                   """;
//        try(Connection con=DBContext.getConnection();PreparedStatement ps=con.prepareCall(sql)){
//            ResultSet rs=ps.executeQuery();
//            while(rs.next()){
//                return rs.getInt(1);
//            }
//        } catch (Exception e) {
//            e.printStackTrace(System.out);
//        }
//        return 0;
//    }
//
//
//    public int soSanPhamSapHetHang() {
//        String sql="""
//                   select COUNT(*) from DepChiTiet where SoLuong<=5
//                   """;
//        try(Connection con=DBContext.getConnection();PreparedStatement ps=con.prepareCall(sql)){
//            ResultSet rs=ps.executeQuery();
//            while(rs.next()){
//                return rs.getInt(1);
//            }
//        } catch (Exception e) {
//            e.printStackTrace(System.out);
//        }
//        return 0;
//    }
//
//
//    public int soSanPhamNgungKinhDoanh() {
//        String sql="""
//                   select COUNT(*) from Dep where TrangThai=1
//                   """;
//        try(Connection con=DBContext.getConnection();PreparedStatement ps=con.prepareCall(sql)){
//            ResultSet rs=ps.executeQuery();
//            while(rs.next()){
//                return rs.getInt(1);
//            }
//        } catch (Exception e) {
//            e.printStackTrace(System.out);
//        }
//        return 0;
//    }


//    public ThongKe ThongKeChart(int month,int year) {
//        String sql="""
//                   select	SUM(HoaDon.TongTien) tongTienHang,
//                   		MONTH(HoaDon.NgayTao) thang
//                   from HoaDon
//                   join NhanVien on HoaDon.ID_NhanVien=NhanVien.ID_NhanVien
//                   where MONTH(HoaDon.NgayTao)=? and YEAR(NgayTao)=?
//                   group by MONTH(HoaDon.NgayTao)
//                   """;
//        try(Connection con=DBContext.getConnection();PreparedStatement ps=con.prepareStatement(sql)){
//            ps.setObject(1, month);
//            ps.setObject(2, year);
//            ResultSet rs=ps.executeQuery();
//            while(rs.next()){
//                ThongKe tk=new ThongKe();
//                tk.setTongTien(rs.getDouble(1));
//                tk.setThang(rs.getInt(2));
//                return tk;
//            }
//        } catch (Exception e) {
//            e.printStackTrace(System.out);
//        }
//        return null;
//    }

    
    public List<Object[]> listYear() {
        String sql="""
                   select distinct YEAR(HoaDon.NgayTao) ngayTao from HoaDon
                   """;
        String cols[]={"ngayTao"};
        try(Connection con=DBContext.getConnection();PreparedStatement ps=con.prepareStatement(sql)){
            ResultSet rs=ps.executeQuery();
            List<Object[]> list=new ArrayList<>();
            while(rs.next()){
                Object[] vals=new Object[cols.length];
                for(int i=0;i<cols.length;i++){
                    vals[i]=rs.getObject(cols[i]);
                }
                list.add(vals);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }


    public List<Object[]> listMonth() {
        String sql="""
                   select distinct Month(HoaDon.NgayTao) ngayTao from HoaDon
                   """;
        String cols[]={"ngayTao"};
        try(Connection con=DBContext.getConnection();PreparedStatement ps=con.prepareStatement(sql)){
            ResultSet rs=ps.executeQuery();
            List<Object[]> list=new ArrayList<>();
            while(rs.next()){
                Object[] vals=new Object[cols.length];
                for(int i=0;i<cols.length;i++){
                    vals[i]=rs.getObject(cols[i]);
                }
                list.add(vals);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }
    
}
