package com.study.repository;

import com.study.entity.GiangVien;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GiangVienRepository extends JpaRepository<GiangVien, String> {
    // Tìm tất cả giảng viên trừ giảng viên có ID hiện tại
    List<GiangVien> findByIdNot(String id);
}
