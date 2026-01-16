package com.example.final_project.service;

import com.example.final_project.dto.UserModelDto;
import com.example.final_project.entity.Permission;
import com.example.final_project.entity.UserModel;
import com.example.final_project.mapper.UserMapper;
import com.example.final_project.repository.PermissionRepository;
import com.example.final_project.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class MyUserService implements UserDetailsService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final PermissionRepository permissionRepository;
    private final UserMapper userMapper;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        UserModel user = userRepository.findByEmail(email);

        if (user != null) {
            return user;
        }
        throw new UsernameNotFoundException("User Not Found with email:" + email);
    }
    public UserModelDto register(UserModel model){
        UserModel check = userRepository.findByEmail(model.getEmail());
        if (check == null){
            model.setPassword(passwordEncoder.encode(model.getPassword()));

            Permission userPermission = permissionRepository.findByName("ROLE_USER");
            if (userPermission == null) {
                userPermission = new Permission();
                userPermission.setName("ROLE_USER");
                permissionRepository.save(userPermission);
            }

            List<Permission> permissions = List.of(userPermission);
            model.setPermissions(permissions);
            userRepository.save(model);
        }
        return userMapper.toDto(model);
    }
}