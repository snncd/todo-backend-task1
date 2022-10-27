package com.snn.todobackendtask1.service;

import com.snn.todobackendtask1.dto.UserDto;

import java.util.List;

public interface IUserService {

    void add(UserDto dto);

    UserDto getById(Long id);

    List<UserDto> getAll();

    void update(UserDto dto);

    void delete(Long id);
}
