package com.study.service;

import com.study.entity.DangKyLop;
import com.study.repository.DangKyLopRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DangKyLopService {

    @Autowired
    private DangKyLopRepository dangKyLopRepository;

    public List<DangKyLop> getAllDangKyLops() {
        return dangKyLopRepository.findAll();
    }

    public Optional<DangKyLop> getDangKyLopById(Integer id) {
        return dangKyLopRepository.findById(id);
    }

    public List<DangKyLop> getDangKyLopsByHocVien(String hocVienId) {
        return dangKyLopRepository.findByHocVienId(hocVienId);
    }

    public List<DangKyLop> getDangKyLopsByLopHoc(String lopHocId) {
        return dangKyLopRepository.findByLopHocId(lopHocId);
    }

    public DangKyLop saveDangKyLop(DangKyLop dangKyLop) {
        return dangKyLopRepository.save(dangKyLop);
    }

    public void deleteDangKyLop(Integer id) {
        dangKyLopRepository.deleteById(id);
    }
}
