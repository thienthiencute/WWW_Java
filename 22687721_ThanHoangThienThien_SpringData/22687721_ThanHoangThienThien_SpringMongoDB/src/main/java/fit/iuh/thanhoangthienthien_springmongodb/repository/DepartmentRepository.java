package fit.iuh.thanhoangthienthien_springmongodb.repository;

import fit.iuh.thanhoangthienthien_springmongodb.model.Department;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface DepartmentRepository extends MongoRepository<Department, String> {

    Department findByDeptId(String deptId);
}
