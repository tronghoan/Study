package com.study.service;

import com.study.entity.GiangVien;
import com.study.repository.GiangVienRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GiangVienService {

    @Autowired
    private GiangVienRepository giangVienRepository;

    public List<GiangVien> getAllGiangViens() {
        return giangVienRepository.findAll();
    }

    public Optional<GiangVien> getGiangVienById(String id) {
        return giangVienRepository.findById(id);
    }

    public GiangVien saveGiangVien(GiangVien giangVien) {
        return giangVienRepository.save(giangVien);
    }

    public void deleteGiangVien(String id) {
        giangVienRepository.deleteById(id);
    }

    // Lấy danh sách các giảng viên khác (trừ giảng viên hiện tại)
    public List<GiangVien> getOtherGiangViens(String currentGiangVienId) {
        return giangVienRepository.findByIdNot(currentGiangVienId);
    }
}
