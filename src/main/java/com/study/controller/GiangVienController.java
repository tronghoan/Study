package com.study.controller;

import com.study.entity.GiangVien;
import com.study.entity.LuanVan;
import com.study.service.GiangVienService;
import com.study.service.LuanVanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/giangvien")
public class GiangVienController {

    @Autowired
    private GiangVienService giangVienService;

    @Autowired
    private LuanVanService luanVanService;

    @GetMapping
    public String getAllGiangViens(Model model) {
        List<GiangVien> giangViens = giangVienService.getAllGiangViens();
        model.addAttribute("giangViens", giangViens);
        return "/admin/giangvien/index"; // Trả về file HTML giangvien/index.html
    }

    @GetMapping("/detail/{id}")
    public String getGiangVienById(@PathVariable String id, Model model) {
        GiangVien giangVien = giangVienService.getGiangVienById(id)
                .orElse(null);
        if (giangVien != null) {
            model.addAttribute("giangVien", giangVien);
            model.addAttribute("monHocList", giangVien.getGiangVienMonHocs()); // Môn học do giảng viên giảng dạy
            model.addAttribute("luanVanList", giangVien.getLuanVans()); // Luận văn hướng dẫn
            model.addAttribute("lopHocList", giangVien.getLopHocs()); //Lớp học do giảng viên phụ trách
            List<GiangVien> otherGiangViens = giangVienService.getOtherGiangViens(id);
            model.addAttribute("otherGiangViens", otherGiangViens); // Danh sách các giảng viên khác
        }

        return "/admin/giangvien/detail";  // Trả về tên file HTML
    }
}