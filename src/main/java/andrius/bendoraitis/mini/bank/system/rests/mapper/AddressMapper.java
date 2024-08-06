package andrius.bendoraitis.mini.bank.system.rests.mapper;

import andrius.bendoraitis.mini.bank.system.entities.Address;
import andrius.bendoraitis.mini.bank.system.rests.dto.AddressDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AddressMapper implements BaseMapper<Address, AddressDto> {

    public Address toEntity(AddressDto addressDto) {

        return Address.builder()
                .detailAddress(addressDto.detailAddress())
                .country(addressDto.country())
                .build();
    }

    @Override
    public AddressDto toDto(Address entity) {
        return AddressDto.builder()
                .id(entity.getId())
                .detailAddress(entity.getDetailAddress())
                .country(entity.getCountry())
                .build();
    }
}
