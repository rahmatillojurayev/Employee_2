package uz.pdp.employee.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "employee")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", nullable = false)
    private UUID id;

    private String firstName;

    private String lastName;

    private String prinfl;

    private LocalDateTime hireDate;

    @ManyToOne
    @JoinColumn(name = "organization_id")
    private Organization organization;
}
