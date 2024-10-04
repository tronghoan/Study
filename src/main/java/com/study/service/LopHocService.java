package com.study.service;

import com.study.entity.LopHoc;
import com.study.repository.LopHocRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LopHocService {

    @Autowired
    private LopHocRepository lopHocRepository;

    public List<LopHoc> getAllLopHocs() {
        return lopHocRepository.findAll();
    }

    public Optional<LopHoc> getLopHocById(String id) {
        return lopHocRepository.findById(id);
    }

    public List<LopHoc> getLopHocsByKhoaHoc(int khoaHocId) {
        return lopHocRepository.findByKhoaHocId(khoaHocId);
    }

    public LopHoc saveLopHoc(LopHoc lopHoc) {
        return lopHocRepository.save(lopHoc);
    }

    public void deleteLopHoc(String id) {
        lopHocRepository.deleteById(id);
    }
}
