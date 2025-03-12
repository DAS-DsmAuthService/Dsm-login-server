package com.example.ouath.domain.user.api;

import com.example.ouath.domain.user.application.AccountIdDuplicatedCheckService;
import com.example.ouath.domain.user.application.ClassNumberDuplicatedCheckService;
import com.example.ouath.domain.user.application.ModifyPasswordService;
import com.example.ouath.domain.user.application.ModifyProfileService;
import com.example.ouath.domain.user.application.QueryAllUserService;
import com.example.ouath.domain.user.application.QueryUserDataService;
import com.example.ouath.domain.user.application.SignupService;
import com.example.ouath.domain.user.dto.request.AuthRequest;
import com.example.ouath.domain.user.dto.request.SignupRequest;
import com.example.ouath.domain.user.dto.request.UserDataRequest;
import com.example.ouath.domain.user.dto.response.DuplicateResponse;
import com.example.ouath.domain.user.dto.response.UserAllResponse;
import com.example.ouath.domain.user.dto.response.UserDataResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {

    private final SignupService signupService;

    private final ClassNumberDuplicatedCheckService classNumberDuplicatedCheckService;

    private final AccountIdDuplicatedCheckService accountIdDuplicatedCheckService;

    private final QueryUserDataService queryUserDataService;

    private final QueryAllUserService queryAllUserService;

    private final ModifyProfileService modifyProfileService;

    private final ModifyPasswordService modifyPasswordService;

//    @ResponseStatus(HttpStatus.CREATED)
//    @PostMapping("/signup")
//    public void signup(@RequestBody @Valid SignupRequest request) {
//        signupService.signup(request);
//    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/class-number-check/{classNumber}")
    public DuplicateResponse classNumberDuplicatedCheck(@PathVariable Integer classNumber) {
        return classNumberDuplicatedCheckService.classNumberDuplicatedCheck(classNumber);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/account-id-check/{accountId}")
    public DuplicateResponse accountIdDuplicatedCheck(@PathVariable String accountId) {
        return accountIdDuplicatedCheckService.accountIdDuplicatedCheck(accountId);
    }

    @ResponseStatus(HttpStatus.OK)
    @PostMapping("/user-data")
    public UserDataResponse queryUserData(@RequestBody UserDataRequest request) {
        return queryUserDataService.queryUserDate(request);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/user-all")
    public List<UserAllResponse> queryAllUser(@RequestParam("secret_key") String secretKey) {
        return queryAllUserService.queryAllUser(secretKey);
    }

    @ResponseStatus(HttpStatus.OK)
    @PatchMapping("/modify-profile")
    public void modifyProfile(@RequestParam("account_id") String accountId, @RequestParam("profile_img_url") String profileImgUrl) {
        modifyProfileService.modifyProfile(accountId, profileImgUrl);
    }

//    @ResponseStatus(HttpStatus.OK)
//    @PatchMapping("/modify-password")
//    public void modifyPassword(@RequestBody AuthRequest request) {
//        modifyPasswordService.modifyPassword(request);
//    }
}
