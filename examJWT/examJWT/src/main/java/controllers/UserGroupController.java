package controllers;

import CustomResponse.ResponseObject;
import dtos.UserGroupDto;
import entity.UserGroup;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import services.IUserGroupService;

import java.util.List;

@RestController
@RequestMapping(path = "/api/v1")
@RequiredArgsConstructor
public class UserGroupController {
    @Autowired
    private final IUserGroupService _userGroupService;
    @Autowired
    private final ModelMapper mapper;

    @GetMapping("/user/getAll")
    public ResponseEntity<ResponseObject> getAll() {
        List<UserGroup> userGroups = _userGroupService.findAll();
        if(userGroups != null) {
            return ResponseEntity.status(HttpStatus.OK).body(
                    new ResponseObject("ok", "Query Role Success", userGroups)
            );
        }else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                    new ResponseObject("failed", "Query Role Fail", userGroups)
            );
        }
    }

    @PostMapping("/user/create")
    public ResponseEntity<ResponseObject> create(UserGroupDto entity) {
        return ResponseEntity.status(HttpStatus.OK).body(
                new ResponseObject("ok", "Create Role Success", _userGroupService.addUser(mapper.map(entity, UserGroup.class)))
        );
    }

    @PutMapping("/user/update")
    public ResponseEntity<ResponseObject> update(UserGroupDto entity) {
        var existEntity = _userGroupService.findByID(entity.getID());

        if(existEntity != null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                    new ResponseObject("ok", "Update Role Success", _userGroupService.updateUser(mapper.map(entity, UserGroup.class)))
            );
        }else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                    new ResponseObject("failed", "Update Role Faile", null)
            );
        }
    }

    @DeleteMapping("user/delete")
    public ResponseEntity<ResponseObject> delete(Long ID) {
        var existEntity = _userGroupService.findByID(ID);

        if(existEntity != null) {
            _userGroupService.deleteUser(ID);
            return ResponseEntity.status(HttpStatus.OK).body(
                    new ResponseObject("ok", "Update User Group Success", existEntity)
            );
        }else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                    new ResponseObject("failed", "Update User Group Faile", null)
            );
        }
    }
}
