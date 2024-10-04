package com.study.entity;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Data
@Table(name = "TieuLuan")
public class TieuLuan {
    @Id
    private String id;

    private String tenTieuLuan;
    private java.sql.Date ngayNop;
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
