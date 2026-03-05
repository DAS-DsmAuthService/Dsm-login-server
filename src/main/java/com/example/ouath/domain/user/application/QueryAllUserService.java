package com.example.ouath.domain.user.application;

import com.example.ouath.domain.user.dao.UserRepository;
import com.example.ouath.domain.user.domain.enums.UserRole;
import com.example.ouath.domain.user.dto.response.UserAllResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class QueryAllUserService {

    private final UserRepository userRepository;

    @Transactional(readOnly = true)
    public List<UserAllResponse> queryAllUser() {

        return userRepository.findAll()
                .stream()
                .filter(user -> user.getRole().equals(UserRole.STU))
                .map(
                        it ->
                        UserAllResponse.builder()
                                .id(it.getId())
                                .name(it.getName())
                                .grade(it.getGrade())
                                .class_num(it.getClassNum())
                                .num(it.getNum())
                                .club(it.getClub())
                                .build()
                )
                .collect(Collectors.toList());
    }
}
