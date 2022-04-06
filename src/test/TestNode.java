import com.assignment_01.Employee;
import com.assignment_01.Node;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/// <summary>
/// IMPORTANT NOTE: DO NOT CHANGE THE TEST CODE!! EVER. :)
/// EmployeeTest - A class for testing the Employee class
/// Employee - A class for representing an employee with a first name, last name and EmployeeID.
///            Must be comparable with itself based on the EmployeeID
///
/// Assignment:     #1
/// Course:         ADEV-3008
/// Date Created:   September. 13, 2019
///
/// @author: Scott Wachal
/// @version 1.0
/// </summary>
public class TestNode
{
//region Constructor Tests
    /// <summary>
    /// Test the empty constructor to ensure the values are set to the proper defaults.
    /// </summary>
    @Test
    public void Empty_Constructor_Test()
    {
        Node<Employee> node = new Node<Employee>();
        assertNotNull(node);
        assertNull(node.getElement());
        assertNull(node.getNext());
        assertNull(node.getPrevious());
    }

    /// <summary>
    /// Test the parameter constructor to ensure the values are being set properly in the created instance.
    /// </summary>
    @Test
    public void AllParameters_Constructor_Test()
    {
        Employee employee1 = new Employee(1);
        Employee employee2 = new Employee(2);
        Employee employee3 = new Employee(3);

        Node<Employee> previousNode = new Node<Employee>(employee1, null, null);

        Node<Employee> nextNode = new Node<Employee>(employee2, null, null);

        Node<Employee> node = new Node<Employee>(employee3, previousNode, nextNode);

        assertNotNull(node);
        assertEquals(node.getElement(), employee3);

        assertEquals(node.getNext(), nextNode);
        assertEquals(node.getPrevious(), previousNode);

    }
        //endregion

        //region Properties Test
    /// <summary>
    /// Test the Element property to ensure that it is being set and retrieved properly.
    /// </summary>
    @Test
    public void Element_Test()
    {
        Employee employeeTest = new Employee(1);

        Node<Employee> node = new Node<Employee>();
        node.setElement(employeeTest);

        assertEquals(node.getElement(), employeeTest);

    }

    /// <summary>
    /// Test the Previous property to ensure it is being set and retrieved properly.
    /// </summary>
    @Test
    public void Previous_Test()
    {
        Employee employee1 = new Employee(1);
        Employee employee2 = new Employee(2);
        Node<Employee> previousNode = new Node<Employee>(employee1, null, null);
        Node<Employee> testNode = new Node<Employee>(employee2, null, null);

        testNode.setPrevious(previousNode);

        assertEquals(testNode.getPrevious(), previousNode);

    }

    /// <summary>
    /// Test the Next property to ensure it is being set and retrieved properly.
    /// </summary>
    @Test
    public void Next_Test()
    {
        Employee employee1 = new Employee(1);
        Employee employee2 = new Employee(2);
        Node<Employee> nextNode = new Node<Employee>(employee1, null, null);
        Node<Employee> testNode = new Node<Employee>(employee2, null, null);

        testNode.setNext(nextNode);

        assertEquals(testNode.getNext(), nextNode);

    }
        //endregion
}