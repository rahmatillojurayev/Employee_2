package uz.pdp.employee.entity;

import jakarta.persistence.*;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "organization")
public class Organization {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "name")
    private String name;

    @ManyToOne
    @JoinColumn(name = "region_id")
    private Region region;

    private Integer parent;
}
