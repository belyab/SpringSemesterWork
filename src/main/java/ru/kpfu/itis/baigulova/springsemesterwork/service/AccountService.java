package ru.kpfu.itis.baigulova.springsemesterwork.service;

import org.springframework.web.multipart.MultipartFile;
import ru.kpfu.itis.baigulova.springsemesterwork.dto.AccountDto;
import ru.kpfu.itis.baigulova.springsemesterwork.dto.SignUpForm;
import ru.kpfu.itis.baigulova.springsemesterwork.model.Account;

import java.util.List;
import java.util.Optional;

public interface AccountService {

    void signUp(SignUpForm form);
    void updateState(String confirmCode);
    List<AccountDto> getAllAccounts();
    List<AccountDto> getAccountsByEmailLike(String email);
    AccountDto getAccountById(Long userId);
    Account getRawAccountByEmail(String email);
    Optional<Account> getAccountByEmail(String email);
    void update(AccountDto accountDto, String email);
}
