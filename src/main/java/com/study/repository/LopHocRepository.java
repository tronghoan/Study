package com.study.repository;

import com.study.entity.LopHoc;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LopHocRepository extends JpaRepository<LopHoc, String> {
    List<LopHoc> findByKhoaHocId(int khoaHocId); // Truy vấn lớp học theo khóa học{
}

