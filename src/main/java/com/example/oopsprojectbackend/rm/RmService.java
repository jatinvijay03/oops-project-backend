package com.example.oopsprojectbackend.rm;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Component
public class RmService {

    private final RmRepository rmRepository;

    @Autowired
    public RmService(RmRepository rmRepository) {
        this.rmRepository = rmRepository;
    }


    public List<Rm> getRms(){
        return rmRepository.findAll();
    }


    public void addNewRm(Rm rm) {
            Optional<Rm> rmOptional = rmRepository.findByUid(rm.getUid());
            if (rmOptional.isPresent()) {
                throw new IllegalStateException("rm exists");
            }
            rmRepository.save(rm);
    }

    public void deleteRm(Long uid){
        rmRepository.deleteByUid(uid);
    }
}
