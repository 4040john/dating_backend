package com.matching.dating.repository;

import com.matching.dating.domain.Idel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IdelRepository extends JpaRepository<Idel, Long> {


    List<Idel> findByMember_id(Long member_id);

}
