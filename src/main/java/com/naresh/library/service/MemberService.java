package com.naresh.library.service;

import com.naresh.library.exceptions.EntityNotFoundException;
import com.naresh.library.model.Member;
import com.naresh.library.repositories.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class MemberService {

  @Autowired
  MemberRepository memberRepository;

  public Member register(Member member) throws Exception {

    if(findByEmail(member.getEmail()).isPresent()){
      throw new Exception("Member already exists: Email: " +  member.getEmail());
    }

    return memberRepository.save(member);
  }
  
  public Member findById(Long memberId) {
    return memberRepository.findById(memberId).orElseThrow(() -> new EntityNotFoundException("Member not found: Member Id: " + memberId));
  }

  public Optional<Member> findByEmail(String memberEmail) {
    return memberRepository.findByEmail(memberEmail);
  }

  public List<Member> findAll() {
    return StreamSupport.stream(memberRepository.findAll().spliterator(), false).collect(Collectors.toList());
  }

}
