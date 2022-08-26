package controllers;

import CustomResponse.ResponseObject;
import dtos.UserDto;
import entity.User;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import services.IUserService;

import java.util.List;

@RestController
@RequestMapping(path = "/api/v1")
@RequiredArgsConstructor
public class UserController {
    @Autowired
    private final IUserService _userService;

    @Autowired
    private final ModelMapper mapper;

    @GetMapping("/user/getAll")
    public ResponseEntity<ResponseObject> getAll() {
        List<User> users = _userService.findAll();
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
    public ResponseEntity<ResponseObject> create(UserDto entity) {
        return ResponseEntity.status(HttpStatus.OK).body(
                new ResponseObject("ok", "Create User Success", _userService.addUser(mapper.map(entity, User.class)))
        );
    }

    @PutMapping("/user/update")
    public ResponseEntity<ResponseObject> update(UserDto entity) {
        var existEntity = _userService.findByID(entity.getID());

        if(existEntity != null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                    new ResponseObject("ok", "Update User Success", _userService.updateUser(mapper.map(entity, User.class)))
            );
        }else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                    new ResponseObject("failed", "Update User Faile", null)
            );
        }
    }

    @DeleteMapping("user/delete")
    public ResponseEntity<ResponseObject> delete(Long ID) {
        var existEntity = _userService.findByID(ID);

        if(existEntity != null) {
            _userService.deleteUser(ID);
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
