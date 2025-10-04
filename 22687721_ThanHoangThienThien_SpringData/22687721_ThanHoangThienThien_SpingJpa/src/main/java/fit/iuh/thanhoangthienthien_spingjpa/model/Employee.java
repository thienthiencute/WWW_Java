package fit.iuh.thanhoangthienthien_spingjpa.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "employees")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Employee {
    @Id
    private String id;
    private String name;
    private double salary;

    @ManyToOne
    @JoinColumn(name = "department_id")
    private Department department;
}
