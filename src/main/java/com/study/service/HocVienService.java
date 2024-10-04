package com.study.service;

import com.study.entity.*;
import com.study.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HocVienService {

    @Autowired
    private HocVienRepository hocVienRepository;
    @Autowired
    private LopHocRepository lopRepository;

    @Autowired
    private GiangVienRepository giangVienRepository;

    @Autowired
    private ChuyenKhoaRepository chuyenKhoaRepository;

    @Autowired
    private TieuLuanRepository tieuLuanRepository;

    @Autowired
    private LuanVanRepository luanVanTotNghiepRepository;

    public List<HocVien> getAllHocViens() {
        return hocVienRepository.findAll();
    }

    public Optional<HocVien> getHocVienById(String id) {
        return hocVienRepository.findById(id);
    }

    public HocVien saveHocVien(HocVien hocVien) {
        return hocVienRepository.save(hocVien);
    }

    public void deleteHocVien(String id) {
        hocVienRepository.deleteById(id);
    }

    public List<LopHoc> getLopByKhoaHoc(int maKhoaHoc) {
        return lopRepository.findByKhoaHocId(maKhoaHoc);
    }

    public List<TieuLuan> getTieuLuanByKhoaHoc(int maKhoaHoc) {
        return tieuLuanRepository.findByKhoaHocId(maKhoaHoc);
    }

    public List<LuanVan> getLuanVanTotNghiepByKhoaHoc(int maKhoaHoc) {
        return luanVanTotNghiepRepository.findByKhoaHocId(maKhoaHoc);
    }
}
