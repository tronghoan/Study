package com.study.repository;

import com.study.entity.LuanVan;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LuanVanRepository extends JpaRepository<LuanVan, String> {
    List<LuanVan> findByKhoaHocId(int khoaHocId); // Truy vấn luận văn theo khóa học
    List<LuanVan> findByGiangVienId(String giangVienId); // Truy vấn luận văn theo khóa học
    // Lấy danh sách các luận văn khác
    List<LuanVan> findByIdNot(String id);
    List<LuanVan> findByMonHocId(String id);
}
