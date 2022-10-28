package com.snn.todobackendtask1.controller;

import com.snn.todobackendtask1.dto.UserDto;
import com.snn.todobackendtask1.service.IUserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")
@AllArgsConstructor
public class UserController {

    private final IUserService userService;

    @GetMapping("/{id}")
    public ResponseEntity<UserDto> getById(@PathVariable Long id){
        return ResponseEntity.ok(userService.getById(id));
    }

    @GetMapping
    public List<UserDto> getAll(){
        return userService.getAll();
    }

    @PostMapping
    public ResponseEntity add(@RequestBody UserDto userDto){
        userService.add(userDto);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping
    public void update(@RequestBody UserDto userDto){
        userService.update(userDto);
    }

    @DeleteMapping
    public void delete(@RequestParam Long id){
        userService.delete(id);
    }
}
