package com.study.entity;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@Table(name = "DangKyLop")
public class DangKyLop {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private java.sql.Date ngayDangKy;
    private float diem;

    @ManyToOne
    @JoinColumn(name = "hocVien_id")
    private HocVien hocVien;

    @ManyToOne
    @JoinColumn(name = "lopHoc_id")
    private LopHoc lopHoc;
}