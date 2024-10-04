package com.study.repository;

import com.study.entity.DangKyLop;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DangKyLopRepository extends JpaRepository<DangKyLop, Integer> {
    List<DangKyLop> findByHocVienId(String hocVienId);
    List<DangKyLop> findByLopHocId(String lopHocId);
}
