package com.study.repository;

import com.study.entity.TieuLuan;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TieuLuanRepository extends JpaRepository<TieuLuan, String> {
    List<TieuLuan> findByKhoaHocId(int khoaHocId); // Truy vấn tiểu luận theo khóa học
    // Lấy các luận văn ngoại trừ luận văn có ID hiện tại
    List<TieuLuan> findByIdNot(String id);
    List<TieuLuan> findByMonHocId(String id);
}
