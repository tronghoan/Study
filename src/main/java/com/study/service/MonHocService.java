package com.study.service;

import com.study.entity.GiangVienMonHoc;
import com.study.entity.LuanVan;
import com.study.entity.MonHoc;
import com.study.entity.TieuLuan;
import com.study.repository.GiangVienMonHocRepository;
import com.study.repository.LuanVanRepository;
import com.study.repository.MonHocRepository;
import com.study.repository.TieuLuanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MonHocService {

    @Autowired
    private MonHocRepository monHocRepository;

    @Autowired
    private GiangVienMonHocRepository giangVienMonHocRepository;

    @Autowired
    private TieuLuanRepository tieuLuanRepository;

    @Autowired
    private LuanVanRepository luanVanRepository;

    public List<MonHoc> getAllMonHocs() {
        return monHocRepository.findAll();
    }

    public MonHoc saveMonHoc(MonHoc monHoc) {
        return monHocRepository.save(monHoc);
    }

    public void deleteMonHoc(String id) {
        monHocRepository.deleteById(id);
    }

    // Lấy thông tin chi tiết của môn học
    public MonHoc getMonHocById(String id) {
        Optional<MonHoc> monHoc = monHocRepository.findById(id);
        return monHoc.orElse(null);
    }

    // Lấy danh sách giảng viên phụ trách môn học
    public List<GiangVienMonHoc> getGiangVienByMonHocId(String monHocId) {
        return giangVienMonHocRepository.findByMonHocId(monHocId);
    }

    // Lấy danh sách tiểu luận của môn học
    public List<TieuLuan> getTieuLuanByMonHocId(String monHocId) {
        return tieuLuanRepository.findByMonHocId(monHocId);
    }

    // Lấy danh sách luận văn của môn học
    public List<LuanVan> getLuanVanByMonHocId(String monHocId) {
        return luanVanRepository.findByMonHocId(monHocId);
    }
}
