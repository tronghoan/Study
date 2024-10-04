package com.study.entity;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Data
@Table(name = "GiangVien")
public class GiangVien {
    @Id
    private String id;

    private String hoTen;
    private String hocVi;
    private String hocHam;
    private String email;
    private String soDienThoai;

    @ManyToOne
    @JoinColumn(name = "chuyenKhoa_id")
    private ChuyenKhoa chuyenKhoa;

    @OneToMany(mappedBy = "giangVien")
    private List<LopHoc> lopHocs;

    @OneToMany(mappedBy = "giangVien")
    private List<TieuLuan> tieuLuans;

    @OneToMany(mappedBy = "giangVien")
    private List<LuanVan> luanVans;

    @OneToMany(mappedBy = "giangVien")
    private List<GiangVienMonHoc> giangVienMonHocs;
}
