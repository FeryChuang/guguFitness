package com.example.demo.controller;
import com.example.demo.model.Chick;
import com.example.demo.model.ChickRepository;
import com.example.demo.model.Member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttribute;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import java.util.List;

@Controller
@RequestMapping("/chick")
public class ChickController {
    
    @Autowired
    private ChickRepository chickRepository; // 注入ChickRepository


    
    
    @RequestMapping(value = "/info", method = RequestMethod.GET) // 修改映射路径
    public ResponseEntity<Chick> getChickInfo(@SessionAttribute("loggedInMember") Member member) {
        Integer memberid = member.getMemberId();
        List<Chick> chickData = chickRepository.findByMemberId(memberid);

        if (!chickData.isEmpty()) {
            return new ResponseEntity<>(chickData.get(0), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    
  /////////更新經驗值/////////////////////////////////////////////////////////////
    @PostMapping("/updateExp")
    public ResponseEntity<String> updateExp(@SessionAttribute("loggedInMember") Member member, @RequestParam Integer timeInSeconds) {
        try {
            Integer memberId = member.getMemberId();
            List<Chick> chickData = chickRepository.findByMemberId(memberId);

            if (!chickData.isEmpty()) {
                Chick chick = chickData.get(0);
                // 更新经验值字段，假设经验值字段为currentExp
                chick.setCurrentExp(chick.getCurrentExp() + timeInSeconds);
                chickRepository.save(chick);
                return ResponseEntity.ok("经验值更新成功");
            } else {
                return ResponseEntity.status(404).body("未找到相关的Chick记录");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(500).body("服务器错误");
        }
    }
    
 // 新增重生按鈕的方法
    @PostMapping("/resetExp")
    public ResponseEntity<String> resetExp(@SessionAttribute("loggedInMember") Member member) {
        try {
            Integer memberId = member.getMemberId();
            List<Chick> chickData = chickRepository.findByMemberId(memberId);

            if (!chickData.isEmpty()) {
                Chick chick = chickData.get(0);
                // 檢查經驗值是否大於等於270000
                if (chick.getCurrentExp() >= 270000) {
                    // 如果經驗值足夠，執行重生操作

                    // 重置經驗值為0
                    chick.setCurrentExp(0);

                    // 增加重生次數
                    chick.setLifecount(chick.getLifecount() + 1);

                    // 在這里向資料庫回傳更新的數據
                    chickRepository.save(chick);

                    return ResponseEntity.ok("經驗值已重置，重生次數增加，並向資料庫回傳數據。");
                } else {
                    // 如果經驗值不足，返回錯誤消息
                    return ResponseEntity.badRequest().body("未達滿等無法重生");
                }
            } else {
                return ResponseEntity.status(404).body("未找到相关的Chick记录");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(500).body("服务器错误");
        }
    }
}

    

