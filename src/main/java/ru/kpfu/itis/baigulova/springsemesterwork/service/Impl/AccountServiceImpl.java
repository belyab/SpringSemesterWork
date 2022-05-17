package ru.kpfu.itis.baigulova.springsemesterwork.service.Impl;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import ru.kpfu.itis.baigulova.springsemesterwork.dto.AccountDto;
import ru.kpfu.itis.baigulova.springsemesterwork.dto.SignUpForm;
import ru.kpfu.itis.baigulova.springsemesterwork.model.Account;
import ru.kpfu.itis.baigulova.springsemesterwork.repositories.AccountRepository;
import ru.kpfu.itis.baigulova.springsemesterwork.service.AccountService;
import ru.kpfu.itis.baigulova.springsemesterwork.util.EmailUtil;

import org.springframework.transaction.annotation.Transactional;

import java.io.File;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

import static ru.kpfu.itis.baigulova.springsemesterwork.dto.AccountDto.from;

@Service
@RequiredArgsConstructor
@Log4j2
public class AccountServiceImpl implements AccountService {

    @Autowired
    private final AccountRepository accountRepository;

    private final PasswordEncoder passwordEncoder;

    @Autowired
    private EmailUtil emailUtil;

    @Value("${server.port}")
    String accountDto;

    @Transactional
    @Override
    public void signUp(SignUpForm signUpForm) {
        Account newUser = Account.builder()
                .firstName(signUpForm.getFirstName())
                .lastName(signUpForm.getLastName())
                .email(signUpForm.getEmail().toLowerCase(Locale.ROOT))
                .password(passwordEncoder.encode(signUpForm.getPassword()))
                .confirmCode(UUID.randomUUID().toString())
                .state(Account.State.NOT_CONFIRMED)
                .role(Account.Role.USER)
                .build();
        accountRepository.save(newUser);

        HashMap<String, String> data = new HashMap<>();
        data.put("confirm_code", newUser.getConfirmCode());
        data.put("first_name", newUser.getFirstName());
        data.put("port", accountDto);
        emailUtil.sendMail(newUser.getEmail(), "confirm", "mails/confirm_mail.ftlh",
                data);
    }

    @Override
    public void updateState(String confirmCode) {
        Account account = accountRepository.findAllByConfirmCode(confirmCode);
        account.setState(Account.State.CONFIRMED);
        accountRepository.save(account);
    }

    @Override
    public void update(AccountDto accountDto, String email) {
        accountRepository.updateAccount(accountDto.getFirstName(), accountDto.getLastName(), passwordEncoder.encode(accountDto.getPassword()), email);
    }

    @Override
    public Optional<Account> getAccountByEmail(String email) {
        return accountRepository.getAccountByEmail(email);
    }

    @Override
    public List<AccountDto> getAllAccounts() {
        List<Account> allUsers = accountRepository.findAll();

        return allUsers.stream()
                .map(AccountDto::fromModel)
                .collect(Collectors.toList());
    }

    @Override
    public List<AccountDto> getAccountsByEmailLike(String email) {
        List<Account> allUsers;

        if (email.isEmpty() || email == null) {
            allUsers = accountRepository.findAll();
        } else {
            allUsers = accountRepository.getAllByEmailContains(email);
        }

        return allUsers.stream()
                .map(AccountDto::fromModel)
                .collect(Collectors.toList());
    }

    @Override
    public AccountDto getAccountById(Long userId) {
        return AccountDto.fromModel(accountRepository.getById(userId));
    }


    @Override
    public Account getRawAccountByEmail(String email) {
        Optional<Account> user = accountRepository.getAccountByEmail(email);

        return user.get();
    }

}
