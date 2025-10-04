package fit.iuh.thanhoangthienthien_springmongodb.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
@Document(collection = "departments")
public class Department {
    @Id
    private String deptId;

    @Field("deptName")
    private String deptName;

    @Field("employees")
    private List<Employee> employees;

}
