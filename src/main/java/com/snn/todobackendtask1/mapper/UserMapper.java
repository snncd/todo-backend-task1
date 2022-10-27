package com.snn.todobackendtask1.mapper;

import com.snn.todobackendtask1.dto.UserDto;
import com.snn.todobackendtask1.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UserMapper {
    UserDto toDto(User user);

    User toEntity(UserDto userDto);
}
