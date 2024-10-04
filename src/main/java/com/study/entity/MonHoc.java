package com.study.entity;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Data
@Table(name = "MonHoc")
public class MonHoc {
    @Id
    private String id;

    private String maMon;
    private String tenMon;
    private int soTinChi;
    private String moTa;
    private int kyHoc;

    @ManyToOne
    @JoinColumn(name = "chuyenKhoa_id")
    private ChuyenKhoa chuyenKhoa;

    @OneToMany(mappedBy = "monHoc")
    private List<LopHoc> lopHocs;

    @OneToMany(mappedBy = "monHoc")
    private List<TieuLuan> tieuLuans;

    @OneToMany(mappedBy = "monHoc")
    private List<LuanVan> luanVans;

    @OneToMany(mappedBy = "monHoc")
    private List<GiangVienMonHoc> giangVienMonHocs;
}
