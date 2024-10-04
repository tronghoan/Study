package com.study.entity;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.*;

import java.util.List;

@Entity
@Data
@Table(name = "HocVien")
public class HocVien {
    @Id
    private String id;

    private String maHocVien;
    private String hoTen;
    private String email;
    private String soDienThoai;
    private int namNhapHoc;
    private java.sql.Date ngaySinh;

    @OneToMany(mappedBy = "hocVien")
    private List<DangKyLop> dangKyLops;

    @OneToMany(mappedBy = "hocVien")
    private List<TieuLuan> tieuLuans;

    @OneToMany(mappedBy = "hocVien")
    private List<LuanVan> luanVans;
}
