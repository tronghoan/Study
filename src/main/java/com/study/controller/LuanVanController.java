package com.study.controller;

import com.study.entity.LuanVan;
import com.study.entity.TieuLuan;
import com.study.service.LuanVanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/luanvan")
public class LuanVanController {
    @Autowired
    private LuanVanService luanVanService;
    @GetMapping
    public String getAllLuanVans(Model model) {
        List<LuanVan> luanVans = luanVanService.getAllLuanVans();
        model.addAttribute("luanVans", luanVans);
        return "/admin/luanvan/index"; // Trả về file HTML luanvan/index.html
    }
    // Hiển thị chi tiết Luận Văn
    @GetMapping("/detail/{id}")
    public String getLuanVanDetail(@PathVariable("id") String id, Model model) {
        LuanVan luanVan = luanVanService.getLuanVanById(id).get();
        if (luanVan != null) {
            model.addAttribute("luanVan", luanVan);
            model.addAttribute("hocVien", luanVan.getHocVien());  // Thông tin học viên thực hiện luận văn
            model.addAttribute("giangVien", luanVan.getGiangVien());  // Thông tin giảng viên hướng dẫn
            // Lấy danh sách các luận văn khác
            List<LuanVan> otherLuanVans = luanVanService.getOtherLuanVanss(id);
            model.addAttribute("otherLuanVans", otherLuanVans);
        }
        return "/admin/luanvan/detail";
    }
}
