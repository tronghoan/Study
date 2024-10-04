package com.study.entity;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@Table(name = "GiangVienMonHoc")
public class GiangVienMonHoc {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private int namHoc;
    private int hocKy;

    @ManyToOne
    @JoinColumn(name = "giangVien_id")
    private GiangVien giangVien;

    @ManyToOne
    @JoinColumn(name = "monHoc_id")
    private MonHoc monHoc;

    @ManyToOne
    @JoinColumn(name = "khoaHoc_id")
    private KhoaHoc khoaHoc;
}
