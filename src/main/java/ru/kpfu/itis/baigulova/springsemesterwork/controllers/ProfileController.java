package ru.kpfu.itis.baigulova.springsemesterwork.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import ru.kpfu.itis.baigulova.springsemesterwork.dto.AccountDto;
import ru.kpfu.itis.baigulova.springsemesterwork.model.Account;
import ru.kpfu.itis.baigulova.springsemesterwork.security.details.AccountUserDetails;
import ru.kpfu.itis.baigulova.springsemesterwork.service.AccountService;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.Optional;

@Controller
@RequiredArgsConstructor
public class ProfileController {

    private final AccountService accountService;

    @PreAuthorize("isAuthenticated()")
    @GetMapping("/profile")
    public String getProfilePage(@AuthenticationPrincipal AccountUserDetails userDetails, Model model) {
        Optional<Account> accountByEmail = accountService.getAccountByEmail(userDetails.getUsername());
        if (accountByEmail.isPresent()) {
            Account account = accountByEmail.get();
            model.addAttribute("account", account);
        }
        return "profile";
    }




}

