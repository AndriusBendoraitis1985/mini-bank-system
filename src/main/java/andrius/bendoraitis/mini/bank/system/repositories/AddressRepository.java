package andrius.bendoraitis.mini.bank.system.repositories;

import andrius.bendoraitis.mini.bank.system.entities.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Long> {
}
