package com.snn.todobackendtask1.service;

import com.snn.todobackendtask1.dto.UserDto;
import com.snn.todobackendtask1.entity.User;
import com.snn.todobackendtask1.mapper.UserMapper;
import com.snn.todobackendtask1.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.time.LocalDateTime;
import java.util.List;

import static java.util.stream.Collectors.toList;

@Service
@AllArgsConstructor
public class UserServiceImpl implements IUserService {

    private final UserRepository userRepository;

    private final UserMapper userMapper;

    @Override
    public void add(UserDto dto) {
        userRepository.save(userMapper.toEntity(dto));
    }

    @Override
    public UserDto getById(Long id) {
        return userMapper.toDto(findById(id));
    }

    public User findById(Long id) {
        return userRepository.findById(id).orElseThrow(() -> new EntityNotFoundException());
    }

    @Override
    public List<UserDto> getAll() {
        return userRepository.findAll().stream().map(p -> userMapper.toDto(p)).collect(toList());
    }

    @Override
    public void update(UserDto dto) {
        User user = findById(dto.getId());
        user.setName(dto.getName());
        user.setEmail(dto.getEmail());
        user.setUpdatedAt(LocalDateTime.now());
        userRepository.save(user);
    }

    @Override
    public void delete(Long id) {
        User user = findById(id);

        userRepository.deleteById(id);
    }
}
