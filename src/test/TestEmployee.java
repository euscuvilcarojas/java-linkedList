//package test;

import com.assignment_01.Employee;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/// <summary>
/// IMPORTANT NOTE: DO NOT CHANGE THE TEST CODE!! EVER. :)
/// test.TestEmployee - A class for testing the Employee class
/// Employee - A class for representing an employee with a first name, last name and EmployeeID.
///            Must be comparable with itself based on the EmployeeID
///
/// Assignment:     #1
/// Course:         ADEV-3008
/// Date Created:   September. 13, 2019
///
/// @author: Scott Wachal
/// @version 1.1
/// </summary>
public class TestEmployee
{
    //region Constructor Test
    /// <summary>
    /// Test the constructor that takes an EmployeeID number to make sure EmployeeID is set, and the other values are default.
    /// </summary>
    @Test
    public void EmployeeId_Constructor_Test()
    {
        int employeeId = 32;
        Employee employee = new Employee(employeeId);

        assertNotNull(employee);
        assertEquals(employee.getEmployeeID(), employeeId);
        assertNull(employee.getFirstName());
        assertNull(employee.getLastName());
    }

    /// <summary>
    /// Test the constructor that takes all parameters to ensure the values are being set correctly.
    /// Because the properties are read-only, this test is implictly testing our getter methods as well.
    /// </summary>
    @Test
    public void FullEmployee_Constructor_Test()
    {
        int employeeId = 32;
        String firstName = "John";
        String lastName = "Smith";

        Employee employee = new Employee(employeeId, firstName, lastName);

        assertNotNull(employee);
        assertEquals(employee.getEmployeeID(), employeeId);
        assertEquals(employee.getFirstName(), firstName);
        assertEquals(employee.getLastName(), lastName);

    }

    //region Public Methods
    /// <summary>
    /// Test the compareTo with an object that should preceed the second object.
    /// </summary>
    @Test
    public void CompareTo_First_is_Lower_Test()
    {
        Comparable<Employee> employee1 = new Employee(1, "First", "Employee");
        Employee employee2 = new Employee(2, "Second", "Employee");

        assertTrue(employee1.compareTo(employee2) < 0);
    }
    /// <summary>
    /// Test the CompareTo with an object that should follow the second object.
    /// </summary>
    @Test
    public void CompareTo_First_is_Higher_Test()
    {
        Comparable<Employee> employee1 = new Employee(2, "First", "Employee");
        Employee employee2 = new Employee(1, "Second", "Employee");

        assertTrue(employee1.compareTo(employee2) > 0);

    }

    /// <summary>
    /// Test the CompareTo with two objects that are equal.
    /// </summary>
    @Test
    public void CompareTo_Equal_Test()
    {
        Comparable<Employee> e1 = new Employee(1, "First", "Employee");
        Employee e2 = new Employee(1, "Second", "Employee");

        assertTrue(e1.compareTo(e2) == 0);
    }

    /// <summary>
    /// Test the ToString method with a FirstName and LastName set to ensure the returned String is as expected.
    /// </summary>
    @Test
    public void ToString_Test()
    {
        int employeeId = 1;
        String firstName = "First";
        String lastName = "Employee";
        Employee employee = new Employee(employeeId, firstName, lastName);

        String expectedToString = String.format("%d %s %s", employeeId, firstName, lastName);
        assertEquals(employee.toString(), expectedToString);
    }

    /// <summary>
    /// Test the ToString method without a FirstName or LastName set, should display with the word null for the missing values
    /// </summary>
    @Test
    public void ToString_with_no_names_shows_Nulls_Test()
    {
        int employeeId = 1;
        Employee employee = new Employee(employeeId);

        String expectedToString =String.format("%d null null",employeeId);
        assertEquals(employee.toString(), expectedToString);
    }
    //endregion
}