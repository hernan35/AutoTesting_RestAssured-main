package model.employee.Resquest.Builder;

import com.github.javafaker.Faker;
import model.User.Request.UserRequest;
import model.employee.Resquest.EmployeeRequest;

public class BuildNewEmployeeFake extends EmployeeRequestBuilder{


    private static final Faker faker = new Faker();

    public BuildNewEmployeeFake(){
        super.employee=new EmployeeRequest();
    }

    @Override
    public void Buildname() {
       employee.setName(faker.internet().emailAddress());
    }

    @Override
    public void Buildsalary()  {
        employee.setSalary("20000");
    }
    @Override
    public void Buildage() {
       employee.setAge(faker.number().digit().toString());
    }
}
