package uz.pdp.employee.entity;

import jakarta.persistence.*;
import lombok.*;
import uz.pdp.employee.entity.enums.CalculationType;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "calculation_table")
public class CalculationTable {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", nullable = false)
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;

    private Integer amount;

    private Integer rate;

    private LocalDateTime date;

    @ManyToOne
    @JoinColumn(name = "organization_id")
    private Organization organization;

    @Enumerated(EnumType.STRING)
    private CalculationType calculationType;

}
