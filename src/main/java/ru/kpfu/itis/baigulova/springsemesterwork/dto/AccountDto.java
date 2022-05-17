package ru.kpfu.itis.baigulova.springsemesterwork.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.kpfu.itis.baigulova.springsemesterwork.model.Account;

import java.util.List;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AccountDto {

    private Long id;
    private String firstName;
    private String lastName;
    private String password;
    private String email;

    public static AccountDto fromModel(Account account) {
        return new AccountDto(account.getId(),account.getFirstName(), account.getLastName(), account.getEmail(), account.getPassword());
    }

    public static AccountDto from(Account account) {
        return AccountDto.builder()
                .id(account.getId())
                .firstName(account.getFirstName())
                .lastName(account.getLastName())
                .password(account.getPassword())
                .email(account.getEmail())
                .build();
    }

    public static List<AccountDto> from(List<Account> accounts) {
        return accounts.stream().map(AccountDto::from).collect(Collectors.toList());
    }

}
