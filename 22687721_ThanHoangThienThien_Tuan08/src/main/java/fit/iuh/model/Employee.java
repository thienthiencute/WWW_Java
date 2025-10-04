package fit.iuh.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "Employee")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Employee {

    @Id
    @Column(name = "empId")
    private String empId;

    @Column(name = "empName")
    private String empName;

    @Column(name = "email")
    private String email;

    @Column(name = "age")
    private int age;

    @Column(name = "salary")
    private double salary;

    @ManyToOne
    @JoinColumn(name = "deptId")
    private Department department;
}
