package andrius.bendoraitis.mini.bank.system.services;

import andrius.bendoraitis.mini.bank.system.entities.Customer;
import andrius.bendoraitis.mini.bank.system.repositories.CustomerRepository;
import andrius.bendoraitis.mini.bank.system.rests.dto.CustomerDto;
import andrius.bendoraitis.mini.bank.system.rests.mapper.CustomerMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class CustomerService {

    private final CustomerRepository customerRepository;
    private final CustomerMapper customerMapper;
    private final AccountService accountService;

    @Transactional
    public CustomerDto saveCustomerAndAssignToAccount(CustomerDto customerDto) {

        Customer savedCustomer = customerRepository.save(customerMapper.toEntity(customerDto));
        accountService.registerCustomerForAccount(customerDto.accountNumber(), savedCustomer);

        return customerMapper.toDto(savedCustomer);
    }
}
