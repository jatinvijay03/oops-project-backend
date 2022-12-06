package com.example.oopsprojectbackend.rm;

import com.example.oopsprojectbackend.user.User;
import com.example.oopsprojectbackend.user.UserPassUpdate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class RmController {

    private final RmService rmService;

    @Autowired
    public RmController(RmService rmService) {
        this.rmService = rmService;
    }

    @RequestMapping(path = "oops/api/requestm")
    @CrossOrigin("http://localhost:3000/")
    public List<Rm> getUsers(){
        return rmService.getRms();
    }


    @RequestMapping(path = "oops/api/requestm", method = RequestMethod.POST)
    @CrossOrigin("http://localhost:3000/")
    public void registerNewRm(@RequestBody Rm rm) {
        rmService.addNewRm(rm);
    }

    @RequestMapping(path = "oops/api/requestm/delete", method = RequestMethod.DELETE)
    @CrossOrigin("http://localhost:3000/")
    public void deleteRm(@RequestBody Rm rm) {
        rmService.deleteRm(rm.getUid());
    }


}
