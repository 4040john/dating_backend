package com.matching.dating.repository;

import com.matching.dating.domain.Dating;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DatingRepository extends JpaRepository<Dating, Long> {

    List<Dating> findByFromMember_Id(Long memberId);

}
