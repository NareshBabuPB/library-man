package com.naresh.library.repositories;

import com.naresh.library.model.Member;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.Optional;

public interface MemberRepository extends PagingAndSortingRepository<Member, Long> {
  Optional<Member> findByEmail(String email);
}
