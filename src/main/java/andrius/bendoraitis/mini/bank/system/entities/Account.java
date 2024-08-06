package andrius.bendoraitis.mini.bank.system.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import org.hibernate.envers.Audited;

import java.util.List;

@Table(name = "accounts")
@Entity
@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AttributeOverride(name = "id", column = @Column(name = "acc_id", unique = true, nullable = false))
@AttributeOverride(name = "versionNum", column = @Column(name = "acc_version", nullable = false))
@AttributeOverride(name = "creationDate", column = @Column(name = "acc_creation_date", updatable = false, nullable = false))
@AttributeOverride(name = "lastModifiedBy", column = @Column(name = "acc_last_modified_by"))
@AttributeOverride(name = "lastModifiedDate", column = @Column(name = "acc_last_modified_date"))
@Audited
public class Account extends BaseEntity {

    @Column(name = "acc_number")
    private String accountNumber;

    @Column(name = "acc_number_of_owners", nullable = false)
    private int numberOfOwners;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "acc_id")
    private List<Customer> customers;
}
