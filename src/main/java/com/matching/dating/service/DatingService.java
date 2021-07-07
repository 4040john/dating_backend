package com.matching.dating.service;

import com.matching.dating.domain.Dating;
import com.matching.dating.repository.DatingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DatingService {

        @Autowired
        DatingRepository datingRepository;

        public List<Dating> getDating(Long memberId){
            return datingRepository.findByFromMember_Id(memberId);
        }

        public Dating saveDating(Dating dating){
            return datingRepository.save(dating);
        }

        public void deleteDating(Long id){
            datingRepository.deleteById(id);
        }
}
