package com.example.demo.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.model.Chick;
import com.example.demo.model.ChickRepository;
import com.example.demo.model.Member;
import com.example.demo.model.MemberRepository;
import com.example.demo.model.Schedule3Repository;

@RestController
public class MemberController {
	@Autowired
	Schedule3Repository sReps;
	
    @Autowired
    MemberRepository memberRepository;

    @Autowired
    ChickRepository chickRepository;
////////////////////////////(用戶)註冊[同時生成member以及chick資料]////////////////////////
    @RequestMapping(value = "/membercreate", method = RequestMethod.POST)
    public ModelAndView add(@RequestBody Member member) {
        ModelAndView model = new ModelAndView("redirect:/index.html");
        
        // 新增 Member 資料
        member.setRegistrationDate(new Date());
        member.setLastLoginDate(new Date());
        Member savedMember = memberRepository.save(member);
        
        // 新增對應的 Chick 資料，設定預設值
        Chick chick = new Chick();
        chick.setMemberId(savedMember.getMemberId());
        chick.setUserName(savedMember.getUserName()); // 使用相同的使用者名稱
        chick.setChickStage("手無縛雞"); // 設定預設階段
        chick.setCurrentLevel(1); // 設定預設等級
        chick.setCurrentExp(0); // 設定預設經驗值
        chick.setLifecount(0); // 設定預設生命數量
        chickRepository.save(chick);
        
        return model;
    }
 ////////////////////////////(用戶)登入////////////////////////////////////   
    @PostMapping("/login")
    public ModelAndView login(@RequestParam String userName, @RequestParam String password, HttpSession session) {
        Member member = memberRepository.findByUserNameAndPassword(userName, password);

        if (member != null) {
            // 将会员信息存储在 HttpSession 中
            session.setAttribute("loggedInMember", member);
            // 更新登入時間
            member.setLastLoginDate(new Date());
            memberRepository.save(member);
            System.out.println(session.getAttribute("loggedInMember"));
            ModelAndView model = new ModelAndView("redirect:/home.html");
            return model;
        } else {
        	session.setAttribute("loginFailedMessage", "會員登入失敗，請確認您輸入的帳號與密碼是否正確"); // 儲存錯誤訊息到Session
            ModelAndView model = new ModelAndView("redirect:/memberLogin.html");
            return model;
        }
    }
    
    // 確認會員登入狀態
    @GetMapping("/checkLoginStatus")
    public ModelAndView checkLoginStatus(HttpSession session) {
    	ModelAndView modelAndView;
    	
    	// 取得session
    	Member loggedInMember = (Member) session.getAttribute("loggedInMember");
        
        if (loggedInMember != null) {
        	modelAndView = new ModelAndView("redirect:/home.html");
        } else {
        	modelAndView = new ModelAndView("redirect:/index.html");
        }
        
        return modelAndView;
    }


    
    // 登入錯誤訊息
    @GetMapping("/loginerror")
    @ResponseBody
    public String getErrorMessage(HttpSession session) {
        String errorMessage = (String) session.getAttribute("loginFailedMessage");
        if (errorMessage != null) {
            session.removeAttribute("loginFailedMessage"); // 清除錯誤訊息
            return errorMessage;
        } else {
            return ""; // 如果沒有錯誤訊息，回傳空字串
        }
    }
    
    // 登出
    @GetMapping("/logout")
    public ModelAndView logout(HttpSession session) {
        // 清除登入session
        session.removeAttribute("loggedInMember");
        ModelAndView model = new ModelAndView("redirect:/memberLogin.html");
        return model;
    }
    
    @RequestMapping(value="/session",method=RequestMethod.GET)
    public Member getSession(HttpSession session) {
   	 return (Member)session.getAttribute("loggedInMember");
    }
//////////////////////(管理員)頁面顯示會員資料//////////////////////////////////////////////   
    @GetMapping("/members")
    public List<Member> getAllMembers() {
        List<Member> members = memberRepository.findAll();

        // 創建新的列表，僅包含您要顯示的欄位
        List<Member> filteredMembers = new ArrayList<>();

        for (Member member : members) {
            Member filteredMember = new Member();
            filteredMember.setMemberId(member.getMemberId());
            filteredMember.setUserName(member.getUserName());
            filteredMember.setPassword(member.getPassword());
            filteredMember.setName(member.getName());
            filteredMember.setEmail(member.getEmail());

            filteredMembers.add(filteredMember);
        }

        return filteredMembers;
    }
//////////////////////(管理員)修改按鈕下的查詢按鈕功能//////////////////////
    @GetMapping("/members/{memberId}")
    public Member getMemberById(@PathVariable Integer memberId) {
        Member member = memberRepository.findById(memberId).orElse(null);

//        if (member == null) {
//            // 如果找不到會員，可以根據需求返回一個錯誤訊息或採取其他處理方式
//            return null; // 或者返回一個適當的錯誤回應
//        }
//
//        // 創建一個新的 Member 對象，僅包含您要顯示的欄位
//        Member filteredMember = new Member();
//        filteredMember.setMemberId(member.getMemberId());
//        filteredMember.setUserName(member.getUserName());
//        filteredMember.setPassword(member.getPassword());
//        filteredMember.setName(member.getName());
//        filteredMember.setEmail(member.getEmail());

        return member;//filteredMember;
    }
    

    
//////////////////////(管理員)更新會員資料//////////////////////////////////
    @PostMapping("/update")
    public Member updateMember(@RequestBody Member updatedMember) {
        // 通过 memberId 在数据库中查找会员
        Member existingMember = memberRepository.findById(updatedMember.getMemberId()).orElse(null);

        if (existingMember == null) {
            // 如果会员不存在，您可以相应地处理此情况，例如返回错误响应。
            return null; // 或返回错误响应
        }

        // 使用新提供的值更新会员详情
        existingMember.setUserName(updatedMember.getUserName());
        existingMember.setPassword(updatedMember.getPassword());
        existingMember.setName(updatedMember.getName());
        existingMember.setEmail(updatedMember.getEmail());

        // 将更新后的会员保存到数据库
        memberRepository.save(existingMember);

        // 如果需要，您可以返回更新后的会员对象
        return existingMember;
    }

 //////////////////////(管理員) 删除会员/////////////////////
    @Transactional
    @DeleteMapping("/delete/{memberId}")
    public boolean deleteMember(@PathVariable("memberId") Integer memberId) {
        // 首先删除 "chick" 表內的相關資料
        chickRepository.deleteByMemberId(memberId);
        
        // 再刪除"schedule3"表內的相關排程資料
        sReps.deleteByMid(memberId);
        
        // 接着删除 "member" 表內的會員資料
        memberRepository.deleteById(memberId);

        return true;
    }


}