package model;

public class Department {
    private int dept_id;
    private String deptName;

    public Department() {
    }

    public Department(int dept_id, String deptName) {
        this.dept_id = dept_id;
        this.deptName = deptName;
    }
    public Department(String deptName) {
        this.deptName = deptName;
    }

    public int getDept_id() {
        return dept_id;
    }

    public void setDept_id(int dept_id) {
        this.dept_id = dept_id;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    @Override
    public String toString() {
        return "Department{" +
                "dept_id=" + dept_id +
                ", deptName='" + deptName + '\'' +
                '}';
    }
}
