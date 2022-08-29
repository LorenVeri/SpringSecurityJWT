package com.example.demo.controller;

import com.example.demo.dto.AppUserDto;
import com.example.demo.entities.GroupUser;
import com.example.demo.services.IGroupUserService;
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
public class GroupUserController {
    @Autowired
    private final IGroupUserService _groupUserService;

    @Autowired
    private final ModelMapper mapper;

    @GetMapping("/groupUser/getAll")
    public ResponseEntity<ResponseObject> getAll() {
        List<GroupUser> groupUsers = _groupUserService.findAll();
        if(groupUsers != null) {
            return ResponseEntity.status(HttpStatus.OK).body(
                    new ResponseObject("ok", "Query User Success", groupUsers)
            );
        }else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                    new ResponseObject("failed", "Query User Fail", groupUsers)
            );
        }
    }

    @PostMapping("/groupUser/create")
    public ResponseEntity<ResponseObject> create(AppUserDto entity) {
        return ResponseEntity.status(HttpStatus.OK).body(
                new ResponseObject("ok", "Create User Success", _groupUserService.save(mapper.map(entity, GroupUser.class)))
        );
    }

    @PutMapping("/groupUser/update")
    public ResponseEntity<ResponseObject> update(AppUserDto entity) {
        var existEntity = _groupUserService.findById(entity.getID());

        if(existEntity != null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                    new ResponseObject("ok", "Update User Success", _groupUserService.save(mapper.map(entity, GroupUser.class)))
            );
        }else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                    new ResponseObject("failed", "Update User Faile", null)
            );
        }
    }

    @DeleteMapping("groupUser/delete")
    public ResponseEntity<ResponseObject> delete(Long ID) {
        var existEntity = _groupUserService.findById(ID);

        if(existEntity != null) {
            _groupUserService.delete(ID);
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
