 Create database DuAn1
 go
 use  DuAn1
 go

 --drop table NhanVien
 create  table NhanVien(
   Id INT IDENTITY(1,1) PRIMARY KEY,
	Ma VARCHAR(50) ,
	HoTen nVARCHAR(30),
	SDT nvarchar(15),
	username nvarchar(300),
	[password] nvarchar(300),
	ViTri varchar(30),
	GioiTinh nvarchar(5),
	NgaySinh date,
	TrangThai nvarchar(300)
 )

 --drop table KhachHang
 create  table KhachHang(
   Id INT IDENTITY(1,1) PRIMARY KEY,
	--Ma VARCHAR(50) ,
	HoTen NVARCHAR(30),
	SDT nvarchar(15),
	GioiTinh Nvarchar(5),
	DiaChi nvarchar(200)
--	DiemTichLuy float
)

 --drop table ThanhToan
Create table ThanhToan(
Id INT IDENTITY(1,1) PRIMARY KEY,
Ma nvarchar(100) ,
Phuongthuc nvarchar(100),

) 

--drop table KichThuoc
CREATE TABLE KichThuoc(
Id INT IDENTITY(1,1) PRIMARY KEY,
Ma NVARCHAR(20) ,
size NVARCHAR(300) 
)

--drop table ChatLieu
CREATE TABLE ChatLieu(
Id INT IDENTITY(1,1)  PRIMARY KEY,
Ten NVARCHAR(300) 
)

--drop table thuongHieu
create table thuongHieu(
Id INT IDENTITY(1,1)  PRIMARY KEY,
tenThuongHieu nvarchar(100)
)
--drop table MauSac
CREATE TABLE MauSac(
Id INT IDENTITY(1,1)  PRIMARY KEY,
Ten NVARCHAR(300) 
)

--drop table SANPHAM
CREATE TABLE SanPham(
	Id INT IDENTITY(1,1) PRIMARY KEY,
	Ma VARCHAR(10),
	Ten NVARCHAR(200) ,
)

--drop table KhuyenMai
 create table KhuyenMai(
   Id INT IDENTITY(1,1) PRIMARY KEY,
   IdSPham int,
  Ma NVARCHAR(20) ,
  Ten NVARCHAR(400) ,
  NgayBatDau DATE ,
  NgayKetThuc DATE ,
  MucGiamGia FLOAT ,
  Trangthai NVARCHAR(400)
  CONSTRAINT FK_IdSPham FOREIGN KEY (IdSPham) REFERENCES SanPham(Id)
 )

--drop table ChiTietSanPham
CREATE TABLE ChiTietSanPham(
Id INT IDENTITY(1,1) PRIMARY KEY,
IdThuongHieu int,
IdMauSac INT,
IdKichThuoc INT ,
IdChatlieu int ,
IdSP INT,
SoLuong INT,
Gia float ,
MoTa NVARCHAR(100)
CONSTRAINT FK_IdThuongHieu FOREIGN KEY (IdThuongHieu) REFERENCES thuonghieu(Id),
CONSTRAINT FK_IdMauSac FOREIGN KEY (IdMauSac) REFERENCES MauSac(Id),
CONSTRAINT FK_IdKichThuoc FOREIGN KEY (IdKichThuoc) REFERENCES KichThuoc(Id),
CONSTRAINT FK_IdChatLieu FOREIGN KEY (IdChatLieu) REFERENCES ChatLieu(Id),
CONSTRAINT FK_IdSP FOREIGN KEY (IdSP) REFERENCES SanPham(Id)
)

--drop table anh
/*CREATE TABLE Anh(
Id INT IDENTITY(1,1) PRIMARY KEY,
IdSPCT int,
[URL] NVARCHAR(300) 
CONSTRAINT FK_IdSPCT FOREIGN KEY (IdSPCT) REFERENCES ChiTietSanPham(Id)
)*/


--drop table HoaDon
 CREATE TABLE HoaDon(
Id INT IDENTITY(1,1) PRIMARY KEY,
IdNV INT,
IdKhachHang int,
IdThanhToan int,
--Ma NVARCHAR(100) ,
NgayTao DATE ,
--NgayNhan DATE,
--SDT nvarchar(13),
TongTien float ,
TrangThai nvarchar(300),
--DiaChiShip NVARCHAR(200)
CONSTRAINT FK_IdNV FOREIGN KEY (IdNV) REFERENCES NhanVien(Id),
CONSTRAINT FK_IdThanhToan FOREIGN KEY (IdThanhtoan) REFERENCES ThanhToan(Id),
CONSTRAINT FK_IdKhachHang FOREIGN KEY (IdKhachHang) REFERENCES KhachHang(Id)
)

--drop table HoaDonChiTiet
CREATE TABLE HoaDonChiTiet(
Id INT IDENTITY(1,1) PRIMARY KEY,
IdHoaDon INT,
IdSanphamCT INT,
SoLuong INT ,
DonGia float 
CONSTRAINT FK_IdHD FOREIGN KEY (IdHoaDon) REFERENCES HoaDon(Id),
CONSTRAINT FK_IdSanPham FOREIGN KEY (IdSanPhamCT) REFERENCES ChiTietSanPham(Id)
)

------------------------------------
--nhanVien select* from Nhanvien
insert into NhanVien values('NV01',N'Nguyen Quang Tuan','0337865491','tuannq','123456','Admin','Nam','8-6-2004',N'Đang lam')
--insert into NhanVien values('NV02',N'Trần Quốc Toàn','0337296591','toantq','123456','Admin','Nam','10-6-2004',N'Đang làm')
insert into NhanVien values('NV02',N'Chu Quang Doanh','0337896426','doanhcq','123456','NhanVien','Nam','10-10-2004',N'Đang lam')
--insert into NhanVien values('NV04',N'Đào Mạnh Cường','0336198457','cuongdm','123456','NhanVien','Nam','3-3-2002',N'Đang làm')
insert into NhanVien values('NV03',N'Pham Thi Hue','0336450136','huept','123456','NhanVien',N'Nữ','1-16-2004',N'Đang lam')
insert into NhanVien values('NV04',N'Le Kha Hoang','0333069909','hoanglk','123456','NhanVien',N'Nam','08-25-2004',N'Đang lam')

--KhachHang select* from KhachHang
insert into KhachHang values (N'Pham Thuy Duong','0338701925',N'Nữ',N'Vinh Loc-Thanh Hoa')
insert into KhachHang values (N'Le Xuan Truong','0338708888',N'Nam',N'Nam Tu Liêm-Ha Noi')

--Thanhtoan  select *from ThanhToan
insert into ThanhToan values('TT01',N'Chuyen khoan')
insert into ThanhToan values('TT02',N'Tien mat')

--hoadon select*from HoaDon
insert into HoaDon values(3,1,1,'11-5-2023',250000,N'Đã thanh toán')
insert into HoaDon values (1,2,2,'11-5-2023',250000,N'Chưa thanh toán')
insert into HoaDon values (2,2,2,'11-5-2023',600000,N'Hủy hóa đơn')

--SanPham select * from SanPham
insert into SANPHAM values('SP01',N'Quan jean')
insert into SANPHAM values('SP02',N'Ao phong hinh')
insert into SANPHAM values('SP03',N'Ao so mi')

--Voucher select* from KhuyenMai
/*insert into Voucher values(1,'Voucher01','Halloween','10-25-2023','10-31-2023',30,N'Kết thúc')
insert into Voucher values(1,'Voucher02',N'Vui đón tết','1-25-2023','1-3-2024',20,N'Chưa bắt đầu')
insert into Voucher values(1,'Voucher03','Happy birthday','11-5-2023','11-30-2023',15,N'Đang diễn ra')*/
insert into KhuyenMai(Ma,Ten,NgayBatDau,NgayKetThuc,MucGiamGia,Trangthai) values ('Voucher01','Halloween','10-25-2023','10-31-2023',30000,N'Kết thúc')
insert into KhuyenMai(Ma,Ten,NgayBatDau,NgayKetThuc,MucGiamGia,Trangthai) values('Voucher02',N'Vui đón tết','12-25-2023','1-5-2024',20000,N'Chưa bắt đầu')
insert into KhuyenMai(Ma,Ten,NgayBatDau,NgayKetThuc,MucGiamGia,Trangthai) values('Voucher03','Happy birthday','12-5-2023','12-30-2023',15000,N'Đang diễn ra')

--kichthuoc select *from KichThuoc
insert into KichThuoc values('KT01','S')
insert into KichThuoc values('KT02','M')
insert into KichThuoc values('KT03','L')

--mausac select *from mausac
insert into MauSac values (N'Đen')
insert into MauSac values (N'Trang')
insert into MauSac values ('Be')

--ThuongHieu select *from ThuongHieu
insert into thuongHieu values ('adidas')
insert into thuongHieu values ('routine')

--chatlieu select *from Chatlieu
insert into ChatLieu values ('Cotton')
insert into ChatLieu values (N'Nhung tam') 

--chitietsanpham select *from chitietsanpham
insert into ChiTietSanPham  values(2,1,2,2,1,20,300000,N'Quần sooc bò')
insert into ChiTietSanPham  values(1,2,2,1,2,25,250000,N'Áo phông dáng rộng hình in 2 mặt')
insert into ChiTietSanPham  values(2,3,3,2,3,13,350000,N'Sơ mi nhung tăm')

--hoadonchitiet select *from hoadonchitiet
select *from hoadon
select *from chitietsanpham
insert into HoaDonChiTiet values(1,2,1,250000)
insert into HoaDonChiTiet values(1,2,1,260000)
insert into HoaDonChiTiet values(3,1,2,300000)
--insert into HoaDonChiTiet values(2,2,2,250000)

update HoaDonChiTiet set SoLuong=? where id=?
select *from HoaDon
select *from hoadonchitiet
delete from HoaDonChiTiet
delete from HoaDon


select SUM(SoLuong*DonGia) as Tongtien from HoaDonChiTiet 
update NhanVien set Ma=?,HoTen=?,SDT=?,username=?,[password]=?,ViTri=?,NgaySinh=? where id=?
select *from NhanVien
delete from HoaDon

select HoaDon.Id,NhanVien.Id as NVID,NhanVien.Ma as MaNV,NhanVien.HoTen as TenNV,HoaDon.TongTien,HoaDon.TrangThai,HoaDon.NgayTao,ThanhToan.Phuongthuc as phuongThucTT,
KhachHang.HoTen as TenKH,KhachHang.SDT as SDT
 from HoaDon join NhanVien on HoaDon.IdNV=NhanVien.Id
join ThanhToan on HoaDon.IdThanhToan=ThanhToan.Id
join KhachHang on HoaDon.IdKhachHang=KhachHang.Id

where HoaDon.TrangThai=N'Chưa thanh toán'
select *from HoaDon where TrangThai=N'Đã thanh toán'

select HoaDon.Id,NhanVien.Ma as MaNV,NhanVien.HoTen as TenNV,HoaDon.TongTien,HoaDon.TrangThai,ThanhToan.Phuongthuc as phuongThucTT,
KhachHang.HoTen as TenKH,KhachHang.SDT as SDT
                    from HoaDon join NhanVien on HoaDon.IdNV=NhanVien.Id
                    join ThanhToan on HoaDon.IdThanhToan=ThanhToan.Id
					join KhachHang on HoaDon.IdKhachHang=KhachHang.Id
where HoaDon.TrangThai=N'Chưa thanh toán'
insert into HoaDon (IdNV,IdKhachHang,IdThanhToan,NgayTao,TongTien,TrangThai) values (?,?,?,?,?,?)

select *from HoaDonChiTiet  join HoaDon on HoaDonChiTiet.IdHoaDon= HoaDon.Id where HoaDon.NgayTao='11-28-2023'

update ChiTietSanPham where id=1

select * from HoaDonChiTiet join ChiTietSanPham on HoaDonChiTiet.IdSanphamCT=ChiTietSanPham.Id where ChiTietSanPham.Id=2
--no o day nay
select HoaDonChiTiet.*,HoaDonChiTiet.DonGia*HoaDonChiTiet.SoLuong as ThanhTien,ChiTietSanPham.*,
                    SanPham.*,thuongHieu.*,MauSac.*,KichThuoc.*,ChatLieu.*,HoaDon.* from HoaDonChiTiet 	
                    join ChiTietSanPham on HoaDonChiTiet.IdSanphamCT=ChiTietSanPham.Id
                    join SanPham on ChiTietSanPham.IdSP=SanPham.Id
                    join thuongHieu on ChiTietSanPham.IdThuongHieu=thuongHieu.Id
                    join MauSac on ChiTietSanPham.IdMauSac=MauSac.Id
                    join KichThuoc on ChiTietSanPham.IdKichThuoc=KichThuoc.Id
                    join ChatLieu on ChiTietSanPham.IdChatlieu=ChatLieu.Id 
					join HoaDon on HoaDonChiTiet.IdHoaDon=HoaDon.Id
					where HoaDonChiTiet.Id=6
					where HoaDon.Id = 8
		where ChiTietSanPham.Id=8
		--trong db select van ra
		-- phai dauuu trong kia la where HoaDon.Id = ? mà đây lại là ChiTiétP
select *from ChiTietSanPham


-- SanPham.Ma,SanPham.Ten,
select SanPham.Ma,SanPham.Ten, HoaDonChiTiet.DonGia,HoaDonChiTiet.SoLuong,HoaDonChiTiet.IdSanphamCT
from HoaDon join HoaDonChiTiet on HoaDon.Id=HoaDonChiTiet.IdHoaDon
join ChiTietSanPham on HoaDonChiTiet.IdSanphamCT=ChiTietSanPham.Id
join SanPham on SanPham.Id=ChiTietSanPham.IdSP
		where HoaDon.Id=1

		SELECT TOP 1 * FROM HOADON ORDER BY ID DESC
select HoaDon.Id,NhanVien.Ma as MaNV,NhanVien.HoTen as TenNV,HoaDon.TongTien,HoaDon.TrangThai as TrangThai,HoaDon.NgayTao as NgayTaoHD,ThanhToan.Phuongthuc as phuongThucTT,
                    KhachHang.HoTen as TenKH,KhachHang.SDT as SDT
                     from HoaDon join NhanVien on HoaDon.IdNV=NhanVien.Id
                    join ThanhToan on HoaDon.IdThanhToan=ThanhToan.Id
                    join KhachHang on HoaDon.IdKhachHang=KhachHang.Id where NgayTao between '04-12-2023'  and '08-12-2023'

					--day à,dung roi-- thử ạchy 0i

					select HoaDon.Id,NhanVien.Ma as MaNV,NhanVien.HoTen as TenNV,HoaDon.TongTien,HoaDon.TrangThai,HoaDon.NgayTao as NgayTaoHD,ThanhToan.Phuongthuc as phuongThucTT,
                    KhachHang.HoTen as TenKH,KhachHang.SDT as SDT
                     from HoaDon join NhanVien on HoaDon.IdNV=NhanVien.Id
                    join ThanhToan on HoaDon.IdThanhToan=ThanhToan.Id
                    join KhachHang on HoaDon.IdKhachHang=KhachHang.Id order by id desc

delete from HoaDonChiTiet where Id=?

select * from HoaDonChiTiet

select * from ChiTietSanPham
update ChiTietSanPham set SOLUONG = 4 WHERE ID = 4
select * from HoaDonChiTiet
select *from KhuyenMai
select *from HoaDon
select *from NhanVien

	update HoaDon set IdNV=1,  IdThanhToan=1,TongTien=700000 ,TrangThai=N'Đã thanh toán' where id=4
select Hoadon.*,HoaDonChiTiet.*,HoaDonChiTiet.DonGia*HoaDonChiTiet.SoLuong as ThanhTien,ChiTietSanPham.*,
                    SanPham.*,thuongHieu.*,MauSac.*,KichThuoc.*,ChatLieu.* from HoaDonChiTiet
					join HoaDon on HoaDonChiTiet.IdHoaDon=HoaDon.Id
                    join ChiTietSanPham on HoaDonChiTiet.IdSanphamCT=ChiTietSanPham.Id
                   join SanPham on ChiTietSanPham.IdSP=SanPham.Id
                    join thuongHieu on ChiTietSanPham.IdThuongHieu=thuongHieu.Id
                    join MauSac on ChiTietSanPham.IdMauSac=MauSac.Id
                    join KichThuoc on ChiTietSanPham.IdKichThuoc=KichThuoc.Id
                    join ChatLieu on ChiTietSanPham.IdChatlieu=ChatLieu.Id
					where HoaDon.id=4