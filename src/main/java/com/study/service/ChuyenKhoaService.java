package com.study.service;

import com.study.entity.ChuyenKhoa;
import com.study.entity.HocVien;
import com.study.repository.ChuyenKhoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class ChuyenKhoaService {
    @Autowired
    private ChuyenKhoaRepository chuyenKhoaRepository;
    public List<ChuyenKhoa> getAllChuyenKhoas() {
        return chuyenKhoaRepository.findAll();
    }

    public Optional<ChuyenKhoa> getChuyenKhoaById(String id) {
        return chuyenKhoaRepository.findById(id);
    }

    public ChuyenKhoa saveHChuyenKhoa(ChuyenKhoa chuyenKhoa) {
        return chuyenKhoaRepository.save(chuyenKhoa);
    }

    public void deleteChuyenKhoa(String id) {
        chuyenKhoaRepository.deleteById(id);
    }

}
