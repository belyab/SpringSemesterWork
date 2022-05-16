package ru.kpfu.itis.baigulova.springsemesterwork.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.kpfu.itis.baigulova.springsemesterwork.validation.ValidEmail;
import ru.kpfu.itis.baigulova.springsemesterwork.validation.ValidPassword;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SignUpForm {
    @Size(min = 4, max =  20)
    @NotBlank
    private String firstName;

    @Size(min = 4, max =  20)
    @NotBlank
    private String lastName;

    @NotBlank
    @ValidPassword
    private String password;

    @Email
    @ValidEmail
    @NotBlank
    private String email;
}
