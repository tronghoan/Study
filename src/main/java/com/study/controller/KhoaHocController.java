package com.study.controller;

import com.study.entity.*;
import com.study.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/khoahoc")
public class KhoaHocController {

    @Autowired
    private KhoaHocService khoaHocService;
    @Autowired
    private ChuyenKhoaService chuyenKhoaService;
    @Autowired
    private GiangVienService giangVienService;
    @Autowired
    private MonHocService monHocService;
    @Autowired
    private TieuLuanService tieuLuanService;
    @Autowired
    private LuanVanService luanVanService;
    @Autowired
    private LopHocService lopHocService;

    // Hiển thị danh sách khoá học
    @GetMapping
    public String getAllKhoaHocs(Model model) {
        List<KhoaHoc> khoaHocs = khoaHocService.getAllKhoaHocs();
        model.addAttribute("khoaHocs", khoaHocs);
        List<ChuyenKhoa> chuyenKhoas = chuyenKhoaService.getAllChuyenKhoas();
        model.addAttribute("chuyenKhoas", chuyenKhoas);
        List<GiangVien> giangViens = giangVienService.getAllGiangViens();
        model.addAttribute("giangViens", giangViens);
        List<MonHoc> monHocs = monHocService.getAllMonHocs();
        model.addAttribute("monHocs", monHocs);
        List<TieuLuan> tieuLuans = tieuLuanService.getAllTieuLuans();
        model.addAttribute("tieuLuans", tieuLuans);
        List<LuanVan> luanVans = luanVanService.getAllLuanVans();
        model.addAttribute("luanVans", luanVans);
        List<LopHoc> lopHocs = lopHocService.getAllLopHocs();
        model.addAttribute("lopHocs", lopHocs);
        return "admin/khoahoc/index"; // Trả về file HTML khoahoc/index.html
    }

    // Hiển thị chi tiết 1 khoá học
    @GetMapping("/{id}")
    public String getKhoaHocById(@PathVariable Integer id, Model model) {
        Optional<KhoaHoc> khoaHoc = khoaHocService.getKhoaHocById(id);
        if (khoaHoc.isPresent()) {
            model.addAttribute("khoaHoc", khoaHoc.get());
            return "/admin/khoahoc/detail"; // Trả về file HTML khoahoc/detail.html
        } else {
            return "/admin/khoahoc/index";
        }
    }
}
