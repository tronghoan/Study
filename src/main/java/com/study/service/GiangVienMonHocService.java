package com.study.service;

import com.study.entity.GiangVienMonHoc;
import com.study.repository.GiangVienMonHocRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GiangVienMonHocService {

    @Autowired
    private GiangVienMonHocRepository giangVienMonHocRepository;

    public List<GiangVienMonHoc> getAllGiangVienMonHocs() {
        return giangVienMonHocRepository.findAll();
    }

    public Optional<GiangVienMonHoc> getGiangVienMonHocById(int id) {
        return giangVienMonHocRepository.findById(id);
    }

    public List<GiangVienMonHoc> getGiangVienMonHocsByKhoaHoc(int khoaHocId) {
        return giangVienMonHocRepository.findByKhoaHocId(khoaHocId);
    }
    public List<GiangVienMonHoc> getGiangVienMonHocsByMonHoc(String monHocId) {
        return giangVienMonHocRepository.findByMonHocId(monHocId);
    }

    public GiangVienMonHoc saveGiangVienMonHoc(GiangVienMonHoc giangVienMonHoc) {
        return giangVienMonHocRepository.save(giangVienMonHoc);
    }

    public void deleteGiangVienMonHoc(int id) {
        giangVienMonHocRepository.deleteById(id);
    }
}
