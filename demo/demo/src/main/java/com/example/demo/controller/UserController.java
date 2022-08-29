package com.example.demo.controller;

import com.example.demo.dto.AppUserDto;
import com.example.demo.entities.AppUser;
import com.example.demo.services.IAppUserService;
import com.example.demo.entities.ResponseObject;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/v1")
@RequiredArgsConstructor
public class UserController {
    @Autowired
    private final IAppUserService _appUserService;

    @Autowired
    private final ModelMapper mapper;

    @GetMapping("/user/getAll")
    public ResponseEntity<ResponseObject> getAll() {
        List<AppUser> users = _appUserService.findAll();
        if(users != null) {
            return ResponseEntity.status(HttpStatus.OK).body(
                    new ResponseObject("ok", "Query User Success", users)
            );
        }else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                    new ResponseObject("failed", "Query User Fail", users)
            );
        }
    }

    @PostMapping("/user/create")
    public ResponseEntity<ResponseObject> create(AppUserDto entity) {
        return ResponseEntity.status(HttpStatus.OK).body(
                new ResponseObject("ok", "Create User Success", _appUserService.save(mapper.map(entity, AppUser.class)))
        );
    }

    @PutMapping("/user/update")
    public ResponseEntity<ResponseObject> update(AppUserDto entity) {
        var existEntity = _appUserService.findById(entity.getID());

        if(existEntity != null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                    new ResponseObject("ok", "Update User Success", _appUserService.save(mapper.map(entity, AppUser.class)))
            );
        }else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                    new ResponseObject("failed", "Update User Faile", null)
            );
        }
    }

    @DeleteMapping("user/delete")
    public ResponseEntity<ResponseObject> delete(Long ID) {
        var existEntity = _appUserService.findById(ID);

        if(existEntity != null) {
            _appUserService.delete(ID);
            return ResponseEntity.status(HttpStatus.OK).body(
                    new ResponseObject("ok", "Update User Success", existEntity)
            );
        }else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                    new ResponseObject("failed", "Update User Faile", null)
            );
        }
    }
}
