package andrius.bendoraitis.mini.bank.system.config;

import andrius.bendoraitis.mini.bank.system.entities.Account;
import andrius.bendoraitis.mini.bank.system.entities.Address;
import andrius.bendoraitis.mini.bank.system.entities.Customer;
import andrius.bendoraitis.mini.bank.system.enums.CustomerType;
import andrius.bendoraitis.mini.bank.system.repositories.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
@ConditionalOnProperty(value = "app.initial.data.create.enable", havingValue = "true")
public class DataLoader implements ApplicationRunner {

    private final AccountRepository accountRepository;

    @Override
    public void run(ApplicationArguments args) {

        Address address1 = Address.builder()
                .country("Lithuania")
                .detailAddress("Simple address 1")
                .build();

        Address address2 = Address.builder()
                .country("Lithuania")
                .detailAddress("Simple address 2")
                .build();

        Customer customer1 = Customer.builder()
                .name("Tom")
                .surname("Smith")
                .customerType(CustomerType.PRIVATE)
                .addressList(List.of(address1, address2))
                .build();

        Customer customer2 = Customer.builder()
                .name("Mark")
                .surname("Brown")
                .customerType(CustomerType.PUBLIC)
                .build();

        Account account1 = Account.builder()
                .accountNumber("account1")
                .customers(List.of(customer1, customer2))
                .build();

        Account account2 = Account.builder()
                .accountNumber("account2")
                .build();

        accountRepository.saveAll(List.of(account1, account2));
    }
}
