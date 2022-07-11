import org.testng.Assert;
import org.testng.annotations.Test;

public class EmployeeTest {
    @Test
    public void employeeNameTest(){
        Employee emp = new Employee();
        emp.setName("John");
        Assert.assertEquals(emp.getName(),"John");
    }
    @Test
    public void employeeSurnameTest(){
        Employee emp = new Employee();
        emp.setSurname("Lennon");
        Assert.assertEquals(emp.getSurname(),"Lennon");
    }
    @Test
    public void employeeYearTest(){
        Employee emp = new Employee();
        emp.setYear(1940);
        Assert.assertEquals(emp.getYear(),1940);
    }
    @Test
    public void employeeRoleTest(){
        Employee emp = new Employee();
        emp.setRole("Musician");
        Assert.assertEquals(emp.getRole(),"Musician");
    }
    @Test
    public void emlpoyeeAllArgsTest(){
        Employee emp = new Employee("John","Lennon", 1940, "Musician");
        Assert.assertEquals(emp.getName(),"John");
        Assert.assertEquals(emp.getSurname(),"Lennon");
        Assert.assertEquals(emp.getYear(),1940);
        Assert.assertEquals(emp.getRole(),"Musician");
    }

}
