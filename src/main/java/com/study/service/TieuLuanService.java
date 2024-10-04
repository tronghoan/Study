package com.study.service;

import com.study.entity.TieuLuan;
import com.study.repository.TieuLuanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TieuLuanService {

    @Autowired
    private TieuLuanRepository tieuLuanRepository;

    public List<TieuLuan> getAllTieuLuans() {
        return tieuLuanRepository.findAll();
    }

    public Optional<TieuLuan> getTieuLuanById(String id) {
        return tieuLuanRepository.findById(id);
    }

    public List<TieuLuan> getTieuLuansByKhoaHoc(int khoaHocId) {
        return tieuLuanRepository.findByKhoaHocId(khoaHocId);
    }

    public TieuLuan saveTieuLuan(TieuLuan tieuLuan) {
        return tieuLuanRepository.save(tieuLuan);
    }

    public void deleteTieuLuan(String id) {
        tieuLuanRepository.deleteById(id);
    }

    // Lấy danh sách các luận văn khác
    public List<TieuLuan> getOtherTieuLuans(String id) {
        return tieuLuanRepository.findByIdNot(id);
    }
}
