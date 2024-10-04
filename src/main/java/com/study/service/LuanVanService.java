package com.study.service;

import com.study.entity.GiangVien;
import com.study.entity.LuanVan;
import com.study.repository.LuanVanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LuanVanService {

    @Autowired
    private LuanVanRepository luanVanRepository;

    public List<LuanVan> getAllLuanVans() {
        return luanVanRepository.findAll();
    }

    public Optional<LuanVan> getLuanVanById(String id) {
        return luanVanRepository.findById(id);
    }

    public List<LuanVan> getLuanVansByKhoaHoc(Integer khoaHocId) {
        return luanVanRepository.findByKhoaHocId(khoaHocId);
    }

    public LuanVan saveLuanVan(LuanVan luanVan) {
        return luanVanRepository.save(luanVan);
    }

    public void deleteLuanVan(String id) {
        luanVanRepository.deleteById(id);
    }

    public List<LuanVan> getLuanVaByGiangVien(String giangVienId) {
        return luanVanRepository.findByGiangVienId(giangVienId);
    }

    // Lấy danh sách các luận văn khác khác (trừ luận văn hiện tại)
    public List<LuanVan> getOtherLuanVanss(String currentLuanVanId) {
        return luanVanRepository.findByIdNot(currentLuanVanId);
    }
}
