package fit.iuh.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "Department")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Department {

    @Id
    @Column(name = "deptId")
    private String deptId;

    @Column(name = "deptName")
    private String deptName;

    @OneToMany(mappedBy = "department", cascade = CascadeType.ALL)
    private List<Employee> employees;
}
