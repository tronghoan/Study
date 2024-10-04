package com.study.entity;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.List;

@Entity
@Data
@Table(name = "KhoaHoc")
public class KhoaHoc {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String tenKhoaHoc;
    private Date ngayBatDau;
    private Date ngayKetThuc;
    private String moTa;

    @OneToMany(mappedBy = "khoaHoc")
    private List<LopHoc> lopHocs;

    @OneToMany(mappedBy = "khoaHoc")
    private List<GiangVienMonHoc> giangVienMonHocs;

    @OneToMany(mappedBy = "khoaHoc")
    private List<LuanVan> luanVans;

    @OneToMany(mappedBy = "khoaHoc")
    private List<TieuLuan> tieuLuans;
}
