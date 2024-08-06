package andrius.bendoraitis.mini.bank.system.rests.dto;

import lombok.Builder;

import java.util.List;

@Builder
public record CustomerDto(
        Long id,
        String name,
        String surname,
        String phoneNum,
        String email,
        String accountNumber,
        String type,
        List<AddressDto> addressList
) {
}
