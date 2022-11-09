package model.employee.Resquest.Builder;

import model.employee.Resquest.EmployeeRequest;

public class BuildNewEmployee extends EmployeeRequestBuilder{

    public BuildNewEmployee(){
        super.employee=new EmployeeRequest();
    }

    @Override
    public void Buildname() {
        employee.setName("hernan");
    }


    @Override
    public void Buildsalary() {
  employee.setSalary("340000");
    }

    @Override
    public void Buildage() {
employee.setAge("50 años");
    }
}
