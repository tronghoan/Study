package com.study.controller;

import com.study.entity.TieuLuan;
import com.study.service.TieuLuanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/tieuluan")
public class TieuLuanController {
    @Autowired
    private TieuLuanService tieuLuanService;
    @GetMapping
    public String getAllTieuLuans(Model model) {
        List<TieuLuan> tieuLuans = tieuLuanService.getAllTieuLuans();
        model.addAttribute("tieuLuans", tieuLuans);
        return "/admin/tieuluan/index"; // Trả về file HTML tieuluan/index.html
    }
    // Hiển thị chi tiết Tiểu Luận
    @GetMapping("/detail/{id}")
    public String getTieuLuanDetail(@PathVariable("id") String id, Model model) {
        TieuLuan tieuLuan = tieuLuanService.getTieuLuanById(id).get();
        if (tieuLuan != null) {
            model.addAttribute("tieuLuan", tieuLuan);
            model.addAttribute("hocVien", tieuLuan.getHocVien());
            model.addAttribute("giangVien", tieuLuan.getGiangVien());
            // Lấy danh sách các luận văn khác
            List<TieuLuan> otherTieuLuans = tieuLuanService.getOtherTieuLuans(id);
            model.addAttribute("otherTieuLuans", otherTieuLuans);
        }
        return "/admin/tieuluan/detail";
    }
}
