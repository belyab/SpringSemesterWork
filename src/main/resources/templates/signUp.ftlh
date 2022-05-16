<!DOCTYPE html>
<#import "spring.ftl" as spring/>
<html lang="en">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Register Account</title>
    <link href="css/styleReg.css" rel="stylesheet" type="text/css"/>
    <link rel="stylesheet" href="css/styleHome.css">
</head>
<body>
<#include 'top_nav.ftlh'>
<div class="wrapper">
    <div class="registration_form">
        <div class="title">
            Registration Form
        </div>
        <form action="/signUp" method="post">
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
            <@spring.bind path="signUpForm"/>
            <div class="form_wrap">
                <div class="input_grp">
                    <div class="input_wrap">
                        <p class="error">${spring.status.errorMessage}</p>
                        <label for="firstName"><@spring.message 'signUp.form.label.enterFirstName'/></label>
                        <#assign i18Tooltip><@spring.message code="signUp.form.placeholder.firstName"/></#assign>
                        <@spring.formInput "signUpForm.firstName" "placeholder=${i18Tooltip}"/>
                        <@spring.showErrors "<br>" "error"/>

                    </div>
                    <div class="input_wrap">
                        <label for="lastName"><@spring.message 'signUp.form.label.enterLastName'/></label>
                        <#assign i18Tooltip><@spring.message code="signUp.form.placeholder.lastName"/></#assign>
                        <@spring.formInput "signUpForm.lastName" "placeholder=${i18Tooltip}"/>
                        <@spring.showErrors "<br>" "error"/>
                    </div>
                </div>
                <div class="input_wrap">
                    <label for="email"><@spring.message 'signUp.form.label.enterEmail'/></label>
                    <#assign i18Tooltip><@spring.message code="signUp.form.placeholder.email"/></#assign>
                    <@spring.formInput "signUpForm.email" "placeholder=${i18Tooltip}"/>
                    <@spring.showErrors "<br>" "error"/>
                </div>

                <div class="input_wrap">
                    <label for="password"><@spring.message 'signUp.form.label.enterPassword'/></label>
                    <#assign i18Tooltip><@spring.message code="signUp.form.placeholder.password"/></#assign>
                    <@spring.formPasswordInput "signUpForm.password" "placeholder=${i18Tooltip}"/>
                    <@spring.showErrors "<br>" "error"/>
                </div>

                <div class="input_wrap">
                    <input type="submit" value="Sign Up" class="submit_btn">
                </div>
                <a href="/signIn">Already have Account?</a>
            </div>
        </form>
    </div>
</div>
</body>
</html>

