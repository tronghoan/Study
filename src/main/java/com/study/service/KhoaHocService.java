package com.study.service;

import com.study.entity.KhoaHoc;
import com.study.repository.KhoaHocRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class KhoaHocService {

    @Autowired
    private KhoaHocRepository khoaHocRepository;

    public List<KhoaHoc> getAllKhoaHocs() {
        return khoaHocRepository.findAll();
    }

    public Optional<KhoaHoc> getKhoaHocById(int id) {
        return khoaHocRepository.findById(id);
    }

    public KhoaHoc saveKhoaHoc(KhoaHoc khoaHoc) {
        return khoaHocRepository.save(khoaHoc);
    }

    public void deleteKhoaHoc(int id) {
        khoaHocRepository.deleteById(id);
    }
}
