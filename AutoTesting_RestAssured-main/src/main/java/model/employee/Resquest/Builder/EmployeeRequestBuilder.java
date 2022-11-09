package model.employee.Resquest.Builder;

import model.User.Request.UserRequest;
import model.employee.Resquest.EmployeeRequest;

public abstract class EmployeeRequestBuilder {

    protected EmployeeRequest employee;

    public EmployeeRequest getEmployee (){
        return employee;
    }

    public abstract  void Buildname();
    public abstract  void Buildsalary();
    public abstract  void Buildage();


}
