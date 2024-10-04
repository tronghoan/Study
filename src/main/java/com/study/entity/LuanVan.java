package com.study.entity;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Data
@Table(name = "LuanVan")
public class LuanVan {
    @Id
    private String id;

    private String tenLuanVan;
    private java.sql.Date ngayBaoVe;
    private float diem;

    @ManyToOne
    @JoinColumn(name = "hocVien_id")
    private HocVien hocVien;

    @ManyToOne
    @JoinColumn(name = "monHoc_id")
    private MonHoc monHoc;

    @ManyToOne
    @JoinColumn(name = "giangVien_id")
    private GiangVien giangVien;

    @ManyToOne
    @JoinColumn(name = "khoaHoc_id")
    private KhoaHoc khoaHoc;
}
