package andrius.bendoraitis.mini.bank.system.rests.mapper;

import andrius.bendoraitis.mini.bank.system.entities.Account;
import andrius.bendoraitis.mini.bank.system.entities.Customer;
import andrius.bendoraitis.mini.bank.system.enums.CustomerType;
import andrius.bendoraitis.mini.bank.system.repositories.AccountRepository;
import andrius.bendoraitis.mini.bank.system.rests.dto.CustomerDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class CustomerMapper implements BaseMapper<Customer, CustomerDto> {

    private final AccountRepository accountRepository;
    private final AddressMapper addressMapper;

    public Customer toEntity(CustomerDto customerDto) {
        return Customer.builder()
                .name(customerDto.name())
                .surname(customerDto.surname())
                .phoneNum(customerDto.phoneNum())
                .email(customerDto.email())
                .customerType(Optional.ofNullable(customerDto.type()).map(CustomerType::valueOf).orElse(null))
                .addressList(Optional.ofNullable(customerDto.addressList()).map(addressMapper::toEntities).orElse(Collections.emptyList()))
                .build();
    }

    @Override
    public CustomerDto toDto(Customer entity) {
        return CustomerDto.builder()
                .id(entity.getId())
                .name(entity.getName())
                .surname(entity.getSurname())
                .phoneNum(entity.getPhoneNum())
                .email(entity.getEmail())
                .accountNumber(Optional.ofNullable(accountRepository.findCustomerId(entity.getId())).map(Account::getAccountNumber).orElse(null))
                .type(Optional.ofNullable(entity.getCustomerType()).map(Enum::name).orElse(null))
                .addressList(Optional.ofNullable(entity.getAddressList()).map(addressMapper::toDtos).orElse(Collections.emptyList()))
                .build();
    }
}
