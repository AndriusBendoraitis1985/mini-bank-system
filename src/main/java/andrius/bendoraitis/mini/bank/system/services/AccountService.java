package andrius.bendoraitis.mini.bank.system.services;

import andrius.bendoraitis.mini.bank.system.entities.Account;
import andrius.bendoraitis.mini.bank.system.entities.Customer;
import andrius.bendoraitis.mini.bank.system.repositories.AccountRepository;
import andrius.bendoraitis.mini.bank.system.rests.dto.CustomerDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AccountService {

    private final AccountRepository accountRepository;

    // Todo: prepared check for update customer endpoint
    public boolean isAccountExistByCustomerData(CustomerDto customer) {
        return accountRepository.findByAccountNumberAndCustomerData(
                customer.accountNumber(),
                customer.name(),
                customer.surname(),
                customer.phoneNum(),
                customer.email()).isPresent();

    }

    public void registerCustomerForAccount(String accountNumber, Customer savedCustomer) {
        accountRepository.findByAccountNumber(accountNumber).ifPresentOrElse(account -> {
            addCustomerToCustomersList(account, savedCustomer);
            accountRepository.save(account);
        }, () -> accountRepository.save(createAccountForCustomer(accountNumber, savedCustomer)));
    }

    private void addCustomerToCustomersList(Account account, Customer customer) {
        List<Customer> customerOfAccount = account.getCustomers();
        customerOfAccount.add(customer);
        account.setCustomers(customerOfAccount);
        account.setNumberOfOwners(customerOfAccount.size());
    }

    private Account createAccountForCustomer(String accountNumber, Customer customer) {
        return Account.builder()
                .accountNumber(accountNumber)
                .customers(List.of(customer))
                .numberOfOwners(1).build();
    }
}
