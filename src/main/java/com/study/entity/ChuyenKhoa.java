package com.study.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import java.util.List;

import jakarta.persistence.Table;
import lombok.*;
@Entity
@Data
@Table(name = "ChuyenKhoa")
public class ChuyenKhoa {
    @Id
    private String id;

    private String maChuyenKhoa;
    private String tenChuyenKhoa;
    private String moTa;

    @OneToMany(mappedBy = "chuyenKhoa")
    private List<GiangVien> giangViens;

    @OneToMany(mappedBy = "chuyenKhoa")
    private List<LopHoc> lopHocs;

    @OneToMany(mappedBy = "chuyenKhoa")
    private List<MonHoc> monHocs;
}
