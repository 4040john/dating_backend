package com.matching.dating.service;

import com.matching.dating.domain.Idel;
import com.matching.dating.domain.Member;
import com.matching.dating.repository.IdelRepository;
import com.matching.dating.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IdelService {

        @Autowired
        IdelRepository idelRepository;

        public List<Idel> getMemberIdel(Long memberId){
                return idelRepository.findByMember_id(memberId);
        }

        public Idel saveMemberIdel(Idel idel){
                return idelRepository.save(idel);
        }

        public void deleteMemberIdel(Long id){
                idelRepository.deleteById(id);
        }

}
