package ru.kpfu.itis.baigulova.springsemesterwork.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import ru.kpfu.itis.baigulova.springsemesterwork.model.Account;

import java.util.List;
import java.util.Optional;

public interface AccountRepository extends JpaRepository<Account, Long> {

    Optional<Account> findByEmail (String email);
    Account findAllByConfirmCode(String code);
    List<Account> findAllByState(Account.State state);

    @Query(value = "select * from account a WHERE a.email = :email", nativeQuery = true)
    Optional<Account> getAccountByEmail(@Param("email") String email);

    @Transactional
    @Modifying(clearAutomatically = true)
    @Query(value = "update account set first_name = :firstName, last_name = :lastName, password = :password where email = :email",  nativeQuery = true)
    void updateAccount(@Param("firstName") String firstName, @Param("lastName") String lastName, @Param("password") String password, @Param("email") String email);

    List<Account> getAllByEmailContains(String email);
}
