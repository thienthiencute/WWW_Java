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
@Table("Department")
public class Department {
    @Id
    @Column("deptId")
    private String deptId;

    @Column("deptName")
    private String deptName;

}
