package andrius.bendoraitis.mini.bank.system.rests.dto;

import lombok.Builder;

@Builder
public record AddressDto(
        Long id,
        String country,
        String detailAddress
) {
}
