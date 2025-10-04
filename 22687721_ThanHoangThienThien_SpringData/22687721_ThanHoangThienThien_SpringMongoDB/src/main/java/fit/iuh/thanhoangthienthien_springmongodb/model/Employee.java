package fit.iuh.thanhoangthienthien_springmongodb.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
@Document(collection = "employees")
public class Employee {
    @Field("empId")
    private String empId;

    @Field("empName")
    private String empName;

    @Field("email")
    private String email;

    @Field("age")
    private  int age;

    @Field("status")
    private int status;

    @Field("deptId")
    private String deptId;

    @Field("salary")
    private  double salary;
}
