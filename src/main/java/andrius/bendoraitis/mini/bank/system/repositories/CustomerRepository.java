package andrius.bendoraitis.mini.bank.system.repositories;

import andrius.bendoraitis.mini.bank.system.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
