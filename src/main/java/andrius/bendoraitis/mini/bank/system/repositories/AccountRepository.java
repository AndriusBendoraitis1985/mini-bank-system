package andrius.bendoraitis.mini.bank.system.repositories;

import andrius.bendoraitis.mini.bank.system.entities.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface AccountRepository extends JpaRepository<Account, Long> {

    @Query(value = """
            SELECT a
            FROM Account a
            LEFT JOIN FETCH a.customers c
            WHERE a.accountNumber = :accountNumber
            AND c.name = :customerName
            AND c.surname = :customerSurname
            AND c.phoneNum = :customerPhoneNum
            AND c.email = :customerEmail
            """)
    Optional<Account> findByAccountNumberAndCustomerData(String accountNumber,
                                                         String customerName,
                                                         String customerSurname,
                                                         String customerPhoneNum,
                                                         String customerEmail);

    @Query(value = """
            SELECT a
            FROM Account a
            LEFT JOIN FETCH a.customers c
            WHERE c.id = :customerId
            """)
    Account findCustomerId(Long customerId);

    Optional<Account> findByAccountNumber(String accountNumber);
}
