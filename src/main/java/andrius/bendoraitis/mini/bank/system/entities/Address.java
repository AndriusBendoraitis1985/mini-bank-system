package andrius.bendoraitis.mini.bank.system.entities;

import jakarta.persistence.AttributeOverride;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import org.hibernate.envers.Audited;

@Table(name = "addressList")
@Entity
@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AttributeOverride(name = "id", column = @Column(name = "adr_id", unique = true, nullable = false))
@AttributeOverride(name = "versionNum", column = @Column(name = "adr_version", nullable = false))
@AttributeOverride(name = "creationDate", column = @Column(name = "adr_creation_date", updatable = false, nullable = false))
@AttributeOverride(name = "lastModifiedBy", column = @Column(name = "adr_last_modified_by"))
@AttributeOverride(name = "lastModifiedDate", column = @Column(name = "adr_last_modified_date"))
@Audited
public class Address extends BaseEntity {

    @Column(name = "adr_country")
    private String country;

    @Column(name = "adr_detail_address")
    private String detailAddress;
}
