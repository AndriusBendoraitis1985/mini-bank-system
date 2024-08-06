package andrius.bendoraitis.mini.bank.system.entities;

import andrius.bendoraitis.mini.bank.system.enums.CustomerType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import org.hibernate.envers.Audited;

import java.util.List;

@Table(name = "customers", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"cus_name", "cus_surname", "cus_phone_num", "cus_email"})})
@Entity
@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AttributeOverride(name = "id", column = @Column(name = "cus_id", unique = true, nullable = false))
@AttributeOverride(name = "versionNum", column = @Column(name = "cus_version", nullable = false))
@AttributeOverride(name = "creationDate", column = @Column(name = "cus_creation_date", updatable = false, nullable = false))
@AttributeOverride(name = "lastModifiedBy", column = @Column(name = "cus_last_modified_by"))
@AttributeOverride(name = "lastModifiedDate", column = @Column(name = "cus_last_modified_date"))
@Audited
public class Customer extends BaseEntity {

    @Column(name = "cus_name")
    private String name;

    @Column(name = "cus_surname")
    private String surname;

    @Column(name = "cus_phone_num")
    private String phoneNum;

    @Column(name = "cus_email")
    private String email;

    @Column(name = "cus_type", nullable = false)
    private CustomerType customerType;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "cus_id")
    private List<Address> addressList;
}
