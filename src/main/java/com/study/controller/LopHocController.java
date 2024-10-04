package com.study.controller;

import com.study.entity.LopHoc;
import com.study.service.LopHocService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/lophoc")
public class LopHocController {
    @Autowired
    private LopHocService lopHocService;
    @GetMapping
    public String getAllLopHoc(Model model) {
        List<LopHoc> lopHocs = lopHocService.getAllLopHocs();
        model.addAttribute("lopHocs", lopHocs);
        return "/admin/lophoc/index"; // Trả về file HTML lophoc/index.html
    }
    @GetMapping("/detail/{id}")
    public String getLopHocDetail(@PathVariable("id") String id, Model model) {
        LopHoc lopHoc = lopHocService.getLopHocById(id).get();
        if (lopHoc != null) {
            model.addAttribute("lopHoc", lopHoc);
            model.addAttribute("giangVien", lopHoc.getGiangVien());
            model.addAttribute("monHoc", lopHoc.getMonHoc());
            model.addAttribute("hocVienList", lopHoc.getDangKyLops());  // Danh sách học viên đăng ký
        }
        return "/admin/lophoc/detail";  // Trả về tên file HTML
    }
}
