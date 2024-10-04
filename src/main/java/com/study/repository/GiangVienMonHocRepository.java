package com.study.repository;

import com.study.entity.GiangVienMonHoc;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GiangVienMonHocRepository extends JpaRepository<GiangVienMonHoc, Integer> {
    List<GiangVienMonHoc> findByKhoaHocId(int khoaHocId); // Truy vấn giảng viên môn học theo khóa học
    List<GiangVienMonHoc> findByMonHocId(String monHocId); // Truy vấn giảng viên môn học theo khóa học
    List<GiangVienMonHoc> findByGiangVienId(String giangVienId); // Truy vấn giảng viên môn học theo khóa học
}
