package com.study.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Data
@Table(name = "LopHoc")
public class LopHoc {
    @Id
    private String id;

    private String maLop;
    private java.sql.Date ngayBatDau;
    private java.sql.Date ngayKetThuc;
    private int soLuongToiDa;

    @ManyToOne
    @JoinColumn(name = "monHoc_id")
    private MonHoc monHoc;

    @ManyToOne
    @JoinColumn(name = "giangVien_id")
    private GiangVien giangVien;

    @ManyToOne
    @JoinColumn(name = "chuyenKhoa_id")
    private ChuyenKhoa chuyenKhoa;

    @OneToMany(mappedBy = "lopHoc")
    private List<DangKyLop> dangKyLops;

    @ManyToOne
    @JoinColumn(name = "khoaHoc_id")
    private KhoaHoc khoaHoc;
}
