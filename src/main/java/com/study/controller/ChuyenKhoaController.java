package com.study.controller;

import com.study.entity.*;
import com.study.service.ChuyenKhoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/chuyenkhoa")
public class ChuyenKhoaController {
    @Autowired
    private ChuyenKhoaService chuyenKhoaService;

    // Hiển thị danh sách chuyên khoa
    @GetMapping
    public String getAllChuyenKhoa(Model model) {

        List<ChuyenKhoa> chuyenKhoas = chuyenKhoaService.getAllChuyenKhoas();
        model.addAttribute("chuyenKhoas", chuyenKhoas);
        return "admin/chuyenkhoa/index"; // Trả về file HTML chuyenkhoa/index.html
    }
    //Thông tin chi tiết chuyên khoa theo ID
    @GetMapping("/detail/{id}")
    public String getKhoaHocById(@PathVariable String id, Model model) {
        Optional<ChuyenKhoa> chuyenKhoa = chuyenKhoaService.getChuyenKhoaById(id);
        List<LopHoc> lopHocs = chuyenKhoa.get().getLopHocs();
        List<MonHoc> monHocs = chuyenKhoa.get().getMonHocs();
        List<GiangVien> giangViens = chuyenKhoa.get().getGiangViens();
        model.addAttribute("monHocs", monHocs);
        model.addAttribute("lopHocs", lopHocs);
        model.addAttribute("giangViens", giangViens);


        if (chuyenKhoa.isPresent()) {
            model.addAttribute("chuyenKhoa", chuyenKhoa.get());
            return "admin/chuyenkhoa/detail"; // Trả về file HTML chuyenkhoa/detail.html
        } else {
            return "admin/chuyenkhoa/index";
        }
    }
}
