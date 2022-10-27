package com.snn.todobackendtask1.controller;

import com.snn.todobackendtask1.dto.UserDto;
import com.snn.todobackendtask1.service.IUserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")
@AllArgsConstructor
public class UserController {

    private final IUserService userService;

    @GetMapping("/{id}")
    public UserDto getById(@PathVariable Long id){
        return userService.getById(id);
    }

    @GetMapping
    public List<UserDto> getAll(){
        return userService.getAll();
    }

    @PostMapping
    public void add(@RequestBody UserDto userDto){
        userService.add(userDto);
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
