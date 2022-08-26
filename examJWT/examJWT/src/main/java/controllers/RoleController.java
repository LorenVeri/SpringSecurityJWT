package controllers;

import CustomResponse.ResponseObject;
import dtos.RoleDto;
import entity.Role;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import services.IRoleService;

import java.util.List;

@RestController
@RequestMapping(path = "/api/v1")
@RequiredArgsConstructor
public class RoleController {
    @Autowired
    private final IRoleService _roleService;

    @Autowired
    private final ModelMapper mapper;

    @GetMapping("/user/getAll")
    public ResponseEntity<ResponseObject> getAll() {
        List<Role> roles = _roleService.findAll();
        if(roles != null) {
            return ResponseEntity.status(HttpStatus.OK).body(
                    new ResponseObject("ok", "Query Role Success", roles)
            );
        }else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                    new ResponseObject("failed", "Query Role Fail", roles)
            );
        }
    }

    @PostMapping("/user/create")
    public ResponseEntity<ResponseObject> create(RoleDto entity) {
        return ResponseEntity.status(HttpStatus.OK).body(
                new ResponseObject("ok", "Create Role Success", _roleService.addUser(mapper.map(entity, Role.class)))
        );
    }

    @PutMapping("/user/update")
    public ResponseEntity<ResponseObject> update(RoleDto entity) {
        var existEntity = _roleService.findByID(entity.getID());

        if(existEntity != null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                    new ResponseObject("ok", "Update Role Success", _roleService.updateUser(mapper.map(entity, Role.class)))
            );
        }else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                    new ResponseObject("failed", "Update Role Faile", null)
            );
        }
    }

    @DeleteMapping("user/delete")
    public ResponseEntity<ResponseObject> delete(Long ID) {
        var existEntity = _roleService.findByID(ID);

        if(existEntity != null) {
            _roleService.deleteUser(ID);
            return ResponseEntity.status(HttpStatus.OK).body(
                    new ResponseObject("ok", "Update Role Success", existEntity)
            );
        }else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                    new ResponseObject("failed", "Update Role Faile", null)
            );
        }
    }
}
