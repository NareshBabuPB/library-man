package com.naresh.library.controller;

import com.naresh.library.model.Member;
import com.naresh.library.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MemberController {
  
  @Autowired
  MemberService memberService;

  @PostMapping(path = "/api/member")
  public ResponseEntity<Object> register(@RequestBody Member p) throws Exception {
    return ResponseEntity.ok(memberService.register(p));
  }
  
  @GetMapping(path = "/api/member")
  public ResponseEntity<List<Member>> getAll() {
    return ResponseEntity.ok(memberService.findAll());
  }
  
  @GetMapping(path = "/api/member/{member-id}")
  public ResponseEntity<Member> getMemberById(@PathVariable(name="member-id", required=true)Long memberId) {
    return ResponseEntity.ok(memberService.findById(memberId));
  }
}
