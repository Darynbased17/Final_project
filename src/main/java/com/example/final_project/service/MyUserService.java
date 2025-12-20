package com.example.final_project.service;

import com.example.final_project.dto.UserModelDto;
import com.example.final_project.entity.Permission;
import com.example.final_project.entity.UserModel;
import com.example.final_project.mapper.UserMapper;
import com.example.final_project.repository.PermissionRepository;
import com.example.final_project.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private PermissionRepository permissionRep;

    private final UserMapper userMapper;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        UserModel user = userRepository.findByEmail(email);

        if(Objects.nonNull(user)) {
            return user;
        }
        throw new UsernameNotFoundException("User Not Found");
    }

    public UserModelDto register(UserModel model){
        UserModel check = userRepository.findByEmail(model.getEmail());
        if (check == null){
            model.setPassword(passwordEncoder.encode(model.getPassword()));
            List<Permission> permissions = List.of(permissionRep.findByName("ROLE_USER"));

            model.setPermissions(permissions);
            userRepository.save(model);
        }

        return userMapper.toDto(model);
    }


}