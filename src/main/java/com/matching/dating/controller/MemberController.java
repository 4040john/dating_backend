package com.matching.dating.controller;

import com.matching.dating.domain.Idel;
import com.matching.dating.domain.Member;
import com.matching.dating.service.IdelService;
import com.matching.dating.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/members")
public class MemberController {

    @Autowired
    MemberService memberService;

    @Autowired
    IdelService idelService;

    @GetMapping
    public List<Member> getMembers(){
        return memberService.getMembers();
    }

    @GetMapping("{id}")
    public Member getMember(@PathVariable Long id){
        return memberService.getMember(id);
    }

    @PostMapping
    public Member saveMember(@RequestBody Member member){
        return memberService.saveMember(member);
    }

    @PutMapping("/{id}")
    public Member updateMember(@PathVariable Long id , @RequestBody Member req){
        Member member = memberService.getMember(id);
        member.setMember(req.getNickname(), req.getAge(),req.getHeight(),req.getJob(),req.getLocation(),req.getGender(),req.getImage());
        return memberService.saveMember(member);
    }

    @DeleteMapping("/{id}")
    public void deleteMember(@PathVariable Long id){
        memberService.deleteMember(id);
    }

    @GetMapping("/{id}/idel")
    public List<Idel> getIdels(@PathVariable Long id){
        return idelService.getMemberIdel(id);
    }

    @PostMapping("/{id}/idel")
    public List<Idel> saveIdels(@PathVariable Long id, @RequestBody List<Idel> idels){
        Member member = memberService.getMember(id);

        for (Idel idel : idels) {
            idel.setMember(member);
            idelService.saveMemberIdel(idel);
        }

        return idelService.getMemberIdel(id);
    }

    @PutMapping("/{id}/idel/{idelId}")
    public Idel updateIdel(@PathVariable Long id, @PathVariable Long idelId, @RequestBody Idel req) {
        Member member = memberService.getMember(id);
        req.setMember(member);
        return idelService.saveMemberIdel(req);
    }

    @DeleteMapping("/{id}/idel/{idelId}")
    public void deleterIdel(@PathVariable Long idelId){
        idelService.deleteMemberIdel(idelId);
    }


}
