package com.example.ouath.domain.user.dao;

import com.example.ouath.domain.user.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;
import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> {
    @Query(value = "SELECT u.id, u.account_id, u.birth_day, u.class_num, u.club, u.device_token, " +
            "u.entrance_year, u.grade, u.name, u.num, u.password, u.profile_file_name, u.role, u.state " +
            "FROM tbl_user u WHERE u.account_id = :accountId", nativeQuery = true)
    Optional<User> findByAccountId(@Param("accountId") String accountId);
    Boolean existsByGradeAndClassNumAndNum(Integer grade, Integer classNum, Integer num);
    Boolean existsByAccountId(String accountId);
}
