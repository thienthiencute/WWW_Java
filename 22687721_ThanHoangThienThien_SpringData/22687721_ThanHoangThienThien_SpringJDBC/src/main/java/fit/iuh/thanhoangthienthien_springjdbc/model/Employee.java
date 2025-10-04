package fit.iuh.thanhoangthienthien_springjdbc.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
@Table("Employee")
public class Employee {
    @Id
    @Column("empId")
    private String empId;

    @Column("empName")
    private String empName;

    private String email;

    private  int age;

    private int status;

    private  double salary;

    @Column("deptId")
    private String deptId;
}
