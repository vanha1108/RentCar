USE module_ban_xe;


INSERT INTO tai_khoan(ten_dang_nhap, mat_khau) VALUES ('user1', '123');
INSERT INTO tai_khoan(ten_dang_nhap, mat_khau) VALUES ('user2', '123');
INSERT INTO tai_khoan(ten_dang_nhap, mat_khau) VALUES ('user3', '123');

INSERT INTO nhan_vien(id_tai_khoan, ho_va_ten, ngay_sinh, vai_tro, kich_hoat, so_dien_thoai) VALUES (1, 'Dương Ngọc Nam', '1995/10/10', 'Nhân viên', true, '0284444747');
INSERT INTO nhan_vien(id_tai_khoan, ho_va_ten, ngay_sinh, vai_tro, kich_hoat, so_dien_thoai) VALUES (2, 'Nguyễn Thu Thuỷ', '1997/05/05', 'Nhân viên', true, '0285467747');
INSERT INTO nhan_vien(id_tai_khoan, ho_va_ten, ngay_sinh, vai_tro, kich_hoat, so_dien_thoai) VALUES (3, 'Ngô Tiến Đồng', '1996/03/09', 'Nhân viên', true, '0247555347');

INSERT INTO hang_xe(ten_hang_xe) VALUES ('Porsche');
INSERT INTO hang_xe(ten_hang_xe) VALUES ('BMW');
INSERT INTO hang_xe(ten_hang_xe) VALUES ('Mercedes');

INSERT INTO xe(id_hang_xe, ten, bien_so, dong_xe, doi_xe, mo_ta) VALUES (1, 'Porsche 911', '51-T1 063.25', 'Cao cấp', 2021, 'Màu đen');
INSERT INTO xe(id_hang_xe, ten, bien_so, dong_xe, doi_xe, mo_ta) VALUES (2, 'BMW I8', '30-V1 123.08', 'Cao cấp', 2021, 'Màu đỏ');
INSERT INTO xe(id_hang_xe, ten, bien_so, dong_xe, doi_xe, mo_ta) VALUES (3, 'Mercedes GLC300', '59-H1 345.67', 'Cao cấp', 2020, 'Màu xám, đầy đủ tiện ích');

INSERT INTO doi_tac(ten_dt, dia_chi, so_dien_thoai, ghi_chu) VALUES ('Nguyễn Thành Nam', 'Quận 1, Hồ Chí Minh', '0339876546', '');
INSERT INTO doi_tac(ten_dt, dia_chi, so_dien_thoai, ghi_chu) VALUES ('Quách Đình Bảo', 'Quận 5, Hồ Chí Minh', '02856555789', '');
INSERT INTO doi_tac(ten_dt, dia_chi, so_dien_thoai, ghi_chu) VALUES ('Nguyễn Thị Quỳnh Hoa', 'Quận 7, Hồ Chí Minh', '0335646466', '');

INSERT INTO hop_dong_ky_gui(id_dt, id_nhan_vien, ma_hd, noi_dung_hd, ngay_lap, ngay_het_han) VALUES (1, 1, 'HD001', 'Hợp đồng ký gửi số 001', '2021/11/15', '2021/11/18');
INSERT INTO hop_dong_ky_gui(id_dt, id_nhan_vien, ma_hd, noi_dung_hd, ngay_lap, ngay_het_han) VALUES (2, 2, 'HD002', 'Hợp đồng ký gửi số 002', '2021/11/16', '2021/11/20');
INSERT INTO hop_dong_ky_gui(id_dt, id_nhan_vien, ma_hd, noi_dung_hd, ngay_lap, ngay_het_han) VALUES (3, 3, 'HD003', 'Hợp đồng ký gửi số 003', '2021/11/18', '2021/11/21');

INSERT INTO hop_dong_thue_xe_dt(id_dt, id_nhan_vien, ma_hd, noi_dung_hop_dong, gia_tri_thue, ngay_bat_dau, ngay_het_han) 
VALUES (1, 1, 'HD004', 'Hợp đồng  thuê xe số 004', 1000000, '2021/11/18', '2021/11/21');
INSERT INTO hop_dong_thue_xe_dt(id_dt, id_nhan_vien, ma_hd, noi_dung_hop_dong, gia_tri_thue, ngay_bat_dau, ngay_het_han) 
VALUES (2, 2, 'HD005', 'Hợp đồng  thuê xe số 005', 2000000, '2021/11/20', '2021/11/27');
INSERT INTO hop_dong_thue_xe_dt(id_dt, id_nhan_vien, ma_hd, noi_dung_hop_dong, gia_tri_thue, ngay_bat_dau, ngay_het_han) 
VALUES (1, 1, 'HD006', 'Hợp đồng  thuê xe số 006', 2500000, '2021/11/22', '2021/11/30');

INSERT INTO xe_thue_dt(id_xe, id_hop_dong, so_luong, don_gia) VALUES (1, 1, 2, 20000000);
INSERT INTO xe_thue_dt(id_xe, id_hop_dong, so_luong, don_gia) VALUES (2, 2, 1, 10000000);
INSERT INTO xe_thue_dt(id_xe, id_hop_dong, so_luong, don_gia) VALUES (3, 3, 3, 25000000);

INSERT INTO khach_hang(ten_kh, dia_chi, so_dien_thoai, ghi_chu) VALUES ('Nguyễn Thành Ngọc', 'Thanh Xuân, Hà Nội', '0334564556', '');
INSERT INTO khach_hang(ten_kh, dia_chi, so_dien_thoai, ghi_chu) VALUES ('Nguyễn Thị Thảo', 'Quận 8, Hồ Chí Minh', '0339564713', '');
INSERT INTO khach_hang(ten_kh, dia_chi, so_dien_thoai, ghi_chu) VALUES ('Nguyễn Bảo Lan', 'Quận 1, Hồ Chí Minh', '0339578999', '');

INSERT INTO hop_dong_thue_xe_kh(id_kh, id_nhan_vien, tai_san_dat_coc, mo_ta_tai_san_dat_coc, quy_doi, noi_dung_hop_dong, hien_trang_xe, gia_tri_hop_dong, 
ngay_lap, ngay_het_han) VALUES (1, 1, '', '', 0, 'Hợp đồng thuê xe. Chúng tôi sẽ cho bên B thuê xe trong thời gian quy định', 'Còn mới', 2000000, '2021/11/18', '2021/11/25');
INSERT INTO hop_dong_thue_xe_kh(id_kh, id_nhan_vien, tai_san_dat_coc, mo_ta_tai_san_dat_coc, quy_doi, noi_dung_hop_dong, hien_trang_xe, gia_tri_hop_dong, 
ngay_lap, ngay_het_han) VALUES (2, 2, '', '', 0, 'Hợp đồng thuê xe. Chúng tôi sẽ cho bên B thuê xe trong thời gian quy định', 'Còn mới', 2500000, '2021/11/20', '2021/11/29');
INSERT INTO hop_dong_thue_xe_kh(id_kh, id_nhan_vien, tai_san_dat_coc, mo_ta_tai_san_dat_coc, quy_doi, noi_dung_hop_dong, hien_trang_xe, gia_tri_hop_dong, 
ngay_lap, ngay_het_han) VALUES (3, 3, 'Nhẫn vàng', 'Nhẫn vàng', 1000000, 'Hợp đồng thuê xe. Chúng tôi sẽ cho bên B thuê xe trong thời gian quy định', 'Còn mới', 2000000, '2021/11/18', '2021/11/30');

INSERT INTO xe_thue_kh(id_xe, id_hop_dong, so_luong, don_gia) VALUES (1, 1, 3, 25000000);
INSERT INTO xe_thue_kh(id_xe, id_hop_dong, so_luong, don_gia) VALUES (3, 3, 2, 20000000);
INSERT INTO xe_thue_kh(id_xe, id_hop_dong, so_luong, don_gia) VALUES (3, 3, 1, 5000000);

INSERT INTO hoa_don(id_kh, id_hop_dong, gia_tri, tong_tien_phat, vat, tong_thanh_toan) VALUES (1, 1, 1500000, 0, 100000, 1600000);
INSERT INTO hoa_don(id_kh, id_hop_dong, gia_tri, tong_tien_phat, vat, tong_thanh_toan) VALUES (2, 2, 2500000, 0, 250000, 2750000);
INSERT INTO hoa_don(id_kh, id_hop_dong, gia_tri, tong_tien_phat, vat, tong_thanh_toan) VALUES (3, 3, 2500000, 0, 250000, 2750000);

INSERT INTO loi_vi_pham_hd(ten_vi_pham, gia_tri) VALUES ('Trả trễ 1 ngày', 150000);

INSERT INTO vi_pham_hop_dong(id_loi, id_hoa_don) VALUES (1, 1);






