package ru.kpfu.itis.baigulova.springsemesterwork.validation;

import lombok.RequiredArgsConstructor;
import ru.kpfu.itis.baigulova.springsemesterwork.repositories.AccountRepository;
import ru.kpfu.itis.baigulova.springsemesterwork.model.Account;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Optional;

@RequiredArgsConstructor
public class EmailValidator implements ConstraintValidator<ValidEmail, String> {

    private final AccountRepository accountRepository;

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        Optional<Account> account = accountRepository.findByEmail(value);
        return !account.isPresent();
    }
}
