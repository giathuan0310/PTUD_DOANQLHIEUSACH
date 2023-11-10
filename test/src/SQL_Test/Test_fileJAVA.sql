create database Test
use Test


CREATE TABLE NhaCungCap (
    
    maNCC varchar(15) PRIMARY KEY,
    tenNCC varchar(15) NOT NULL,
    sdt varchar(12) NOT NULL,
    diaChi varchar(50) NOT NULL,
	tinhTrang varchar(15) not null,
	

    
);
drop table KhachHang
CREATE TABLE KhachHang (
    maKH varchar(5) PRIMARY KEY,
	tenKH varchar(15) not NULL,
	ngaySinh Date not null,
	diaChi varchar(50) not null,
	sdt varchar(12) NOT NULL,
	
);

create table NhaXuatBan(
	maNXB varchar(15) PRIMARY KEY,
	tenNXB varchar(15),
	diaChi varchar(50)

)

create table TheLoai(
	maTheLoai varchar(15)PRIMARY KEY,
	tenTheLoai varchar(15) not null,
)

create table TacGia(
	maTacGia varchar(15)PRIMARY KEY,
	tenTacGia varchar(15) not null,
)
drop table Sach
CREATE TABLE Sach (
    
    maSach varchar(5) PRIMARY KEY,
    tenSach varchar(50) NOT NULL,
    maNCC varchar(15) NOT NULL,
    donGiaNhap float NOT NULL,
	soLuong int not null,
	TheLoai varchar(15) not null,
	maNXB varchar(15) not null,
	maTacGia varchar(15) not null,
	hinhAnh varchar(50)  null
	

	 Foreign key(maNCC) references NhaCungCap(maNCC),
	 Foreign key(TheLoai) references TheLoai(maTheLoai),
	 Foreign key(maNXB) references NhaXuatBan(maNXB),
	 Foreign key(maTacGia) references TacGia(maTacGia),
   
);





Insert into NhaXuatBan values ('NXB001','Hong Danh','HCM'),('NXB002','Hieu Nhan','Ca Mau'),('NXB003','Hai Banh','HCM'),('NXB004','Gia Thuan','Bac Lieu')

Insert into TacGia values ('TG001','Nhan'),('TG002','Thuan') ,('TG003','Danh'),('TG004','Hai')
Insert into TheLoai values ('TL001','Lich Su'),('TL002','Khoa Hoc'),('TL003','Toan hoc'),('TL004','Giai Tri'),('TL005','Truyen Tranh')

Insert into Sach values ('MS001','Vo Chong A Phu','NCC001',10000,20,'TL001','NXB001','TG001','') 
Insert into Sach values ('MS002','Làm Đĩ','NCC002',10000,2,'TL001','NXB003','TG004','') 
Insert into KhachHang values (N'KH001',N'Gia Thuan','03-10-2003','Go Vap',N'0942192110'),(N'KH002',N'Gia Thuan','03-10-2003','Go Vap',N'0942192110')
Insert into NhaCungCap values (N'NCC001',N'Gia Thuan',N'0942192110','Go Vap',N'Dang hoat dong'),(N'NCC002',N'Hieu Nhan',N'0942192110','Go Vap',N'Dang hoat dong')




select * from Sach
select * from TacGia
select * from TheLoai
select * from NhaXuatBan
 
select * from NhaCungCap
select * from KhachHang



