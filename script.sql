CREATE DATABASE IF NOT EXISTS module_ban_xe ;

USE module_ban_xe;

CREATE TABLE tai_khoan (
	id int primary key auto_increment,
    ten_dang_nhap nvarchar(50) not null,
    mat_khau nvarchar(20) not null
);

CREATE TABLE nhan_vien (
	id int primary key auto_increment,
    id_tai_khoan int not null,
    ho_va_ten nvarchar(100) not null,
    ngay_sinh date,
    vai_tro nvarchar(50),
    kich_hoat boolean,
    so_dien_thoai decimal
);

CREATE TABLE hang_xe (
	id int primary key auto_increment,
    ten_hang_xe nvarchar(100) not null
);

CREATE TABLE xe (
	id int primary key auto_increment,
    id_hang_xe	int not null,
    ten nvarchar(100) not null,
    bien_so varchar(15) not null,
    dong_xe nvarchar(50),
    doi_xe int,
    mo_ta nvarchar(255)
);

CREATE TABLE khach_hang (
	id int primary key auto_increment,
    ten_kh nvarchar(100) not null,
    dia_chi nvarchar(100),
    so_dien_thoai decimal,
    ghi_chu nvarchar(255)
);

CREATE TABLE hop_dong_thue_xe_kh (
	id int primary key auto_increment,
    id_kh int not null,
    id_nhan_vien int not null,
    tai_san_dat_coc nvarchar(255),
    mo_ta_tai_san_dat_coc nvarchar(255),
    quy_doi float,
    noi_dung_hop_dong nvarchar(255),
    hien_trang_xe nvarchar(255),
    gia_tri_hop_dong float not null,
    ngay_lap date not null,
    ngay_het_han date
);

CREATE TABLE xe_thue_kh (
	id int primary key auto_increment,
    id_xe int not null,
    id_hop_dong int not null,
    so_luong int,
    don_gia float
);

CREATE TABLE doi_tac (
	id int primary key auto_increment,
    ten_dt nvarchar(100) not null,
    dia_chi nvarchar(150),
    so_dien_thoai decimal,
	ghi_chu nvarchar(255)
);

CREATE TABLE xe_thue_dt (
	id int primary key auto_increment,
    id_xe int not null,
    id_hop_dong int not null,
	so_luong int,
    don_gia float
);

CREATE TABLE hop_dong_thue_xe_dt (
	id int primary key auto_increment,
    id_dt int not null,
    id_nhan_vien int not null,
    ma_hd nvarchar(100),
    noi_dung_hop_dong nvarchar(255),
    gia_tri_thue nvarchar(100),
    ngay_bat_dau date,
    ngay_het_han date
);

CREATE TABLE hop_dong_ky_gui (
	id int primary key auto_increment,
    id_dt int not null,
    id_nhan_vien int not null,
    ma_hd nvarchar(100),
	noi_dung_hd nvarchar(255),
    ngay_lap date,
    ngay_het_han date
);

CREATE TABLE hoa_don (
	id int primary key auto_increment,
    id_kh int not null,
    id_hop_dong int not null,
	gia_tri float,
    tong_tien_phat float,
    vat float,
    tong_thanh_toan float
);

CREATE TABLE loi_vi_pham_hd (
	id int primary key auto_increment,
    ten_vi_pham nvarchar(255) not null,
	gia_tri float
);

CREATE TABLE vi_pham_hop_dong (
	id int primary key auto_increment,
    id_loi int not null,
    id_hoa_don int not null
);

ALTER TABLE xe ADD CONSTRAINT fk_xe_hang_xe FOREIGN KEY (id_hang_xe) REFERENCES hang_xe(id);

ALTER TABLE xe_thue_dt ADD CONSTRAINT fk_xe_thue_dt_xe FOREIGN KEY (id_xe) REFERENCES xe(id);

ALTER TABLE xe_thue_dt ADD CONSTRAINT fk_xe_thue_dt_hop_dong_thue_xe_dt FOREIGN KEY (id_hop_dong) REFERENCES hop_dong_thue_xe_dt(id);

ALTER TABLE hop_dong_thue_xe_dt ADD CONSTRAINT fk_hop_dong_thue_xe_dt_doi_tac FOREIGN KEY (id_dt) REFERENCES doi_tac(id);

ALTER TABLE hop_dong_thue_xe_dt ADD CONSTRAINT fk_hop_dong_thue_xe_dt_nhan_vien FOREIGN KEY (id_nhan_vien) REFERENCES  nhan_vien(id);

ALTER TABLE hop_dong_ky_gui ADD CONSTRAINT fk_hop_dong_ky_gui_doi_tac FOREIGN KEY (id_dt) REFERENCES doi_tac(id);

ALTER TABLE hop_dong_ky_gui ADD CONSTRAINT fk_hop_dong_ky_gui_nhan_vien FOREIGN KEY (id_nhan_vien) REFERENCES nhan_vien(id);

ALTER TABLE xe_thue_kh ADD CONSTRAINT fk_xe_thue_kh_xe FOREIGN KEY (id_xe) REFERENCES xe(id);

ALTER TABLE xe_thue_kh ADD CONSTRAINT fk_xe_thue_kh_hop_dong_thue_xe_kh FOREIGN KEY (id_hop_dong) REFERENCES hop_dong_thue_xe_kh(id);

ALTER TABLE hop_dong_thue_xe_kh ADD CONSTRAINT fk_hop_dong_thue_xe_kh_khach_hang FOREIGN KEY (id_kh) REFERENCES khach_hang(id);

ALTER TABLE hop_dong_thue_xe_kh ADD CONSTRAINT fk_hop_dong_thue_xe_kh_nhan_vien FOREIGN KEY (id_nhan_vien) REFERENCES nhan_vien(id);

ALTER TABLE hoa_don ADD CONSTRAINT fk_hoa_don_hop_dong_thue_xe_kh FOREIGN KEY (id_hop_dong) REFERENCES hop_dong_thue_xe_kh(id);

ALTER TABLE hoa_don ADD CONSTRAINT fk_hoa_don_khach_hang FOREIGN KEY (id_kh) REFERENCES khach_hang(id);

ALTER TABLE vi_pham_hop_dong ADD CONSTRAINT fk_vi_pham_hop_dong_loi_vi_pham_hd FOREIGN KEY (id_loi) REFERENCES loi_vi_pham_hd(id);

ALTER TABLE vi_pham_hop_dong ADD CONSTRAINT fk_vi_pham_hop_dong_hoa_don FOREIGN KEY (id_hoa_don) REFERENCES hoa_don(id);

ALTER TABLE nhan_vien ADD CONSTRAINT fk_vi_nhan_vien_tai_khoan FOREIGN KEY (id_tai_khoan) REFERENCES tai_khoan(id);












