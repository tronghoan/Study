package com.study.controller;

import com.study.entity.GiangVienMonHoc;
import com.study.entity.LuanVan;
import com.study.entity.MonHoc;
import com.study.entity.TieuLuan;
import com.study.service.MonHocService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/monhoc")
public class MonHocController {
    @Autowired
    private MonHocService monHocService;
    @GetMapping
    public String getAllMonHocs(Model model) {
        List<MonHoc> monHocs = monHocService.getAllMonHocs();
        model.addAttribute("monHocs", monHocs);
        return "/admin/monhoc/index"; // Trả về file HTML monhoc/index.html
    }

    // Hiển thị chi tiết thông tin môn học
    @GetMapping("/detail/{id}")
    public String getMonHocDetail(@PathVariable("id") String id, Model model) {
        MonHoc monHoc = monHocService.getMonHocById(id);
        if (monHoc != null) {
            model.addAttribute("monHoc", monHoc);
        }
        // Lấy danh sách giảng viên phụ trách môn học
        List<GiangVienMonHoc> giangVienList = monHocService.getGiangVienByMonHocId(id);
        model.addAttribute("giangVienList", giangVienList);

        // Lấy danh sách tiểu luận của môn học
        List<TieuLuan> tieuLuanList = monHocService.getTieuLuanByMonHocId(id);
        model.addAttribute("tieuLuanList", tieuLuanList);

        // Lấy danh sách luận văn của môn học
        List<LuanVan> luanVanList = monHocService.getLuanVanByMonHocId(id);
        model.addAttribute("luanVanList", luanVanList);
        return "/admin/monhoc/detail";
    }
}
