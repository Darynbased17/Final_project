package com.example.final_project.mapper;

import com.example.final_project.dto.PermissionDto;
import com.example.final_project.entity.Permission;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PermissionMapper {

    @Mapping(target = "idDto", source = "id")
    @Mapping(target = "nameDto", source = "name")
    PermissionDto toDto(Permission permission);

    @Mapping(target = "id", source = "idDto")
    @Mapping(target = "name", source = "nameDto")
    Permission toEntity(PermissionDto permissionDto);

    List<PermissionDto> toDtoList(List<Permission> permissions);

}