import com.assignment_01.Employee;
import com.assignment_01.Node;
import com.assignment_01.LinkedList;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

/// <summary>
/// IMPORTANT NOTE: DO NOT CHANGE THE TEST CODE!! EVER. :)
/// EmployeeTest - A class for testing the Employee class
/// Employee - A class for representing an employee with a first name, last name and EmployeeID.
///            Must be comparable with itself based on the EmployeeID
///
/// Assignment:     #1
/// Course:         ADEV-3008
/// Date Created:   September. 11, 2020
///
/// @author: Scott Wachal
/// @version 1.1
/// </summary>
public class TestLinkedList
{
       //region Milestone 1

        //region Constructor Tests, (requires .getHead(), .getTail(), .getSize(), IsEmpty())
        /// <summary>
        /// Test the constructor to ensure the default values are set properly.
        /// </summary>

    @Test
    public void new_constructor_has_size_of_zero_Test()
    {
        LinkedList<Employee> list = new LinkedList<Employee>();

        assertEquals(list.getSize(), 0);
    }

    @Test
    /// <summary>
    /// Test GetHead returns null when a new constructor is called.
    /// </summary>
    public void GetHead_is_null_on_new_constructor_Test()
    {
        LinkedList<Employee> list = new LinkedList<Employee>();

        assertNull(list.getHead());
    }

    @Test
    /// <summary>
    /// Test GetTail returns null when a new constructor is called.
    /// </summary>
    public void GetTail_is_null_on_new_constructor_Test()
    {
        LinkedList<Employee> list = new LinkedList<Employee>();

        assertNull(list.getTail());
    }

    /// <summary>
    /// Test IsEmpty() should return true on an empty list.
    /// </summary>
    @Test
    public void IsEmpty_is_true_on_new_constructor_Test()
    {
        LinkedList<Employee> list = new LinkedList<Employee>();

        assertTrue(list.isEmpty());
    }
        //endregion

        //region AddFirst(), requires: .getSize() / GetHead() / GetTail()
    /// <summary>
    /// Test AddFirst() to ensure node is added to list.
    /// </summary>
    @Test
    public void AddFirst_on_emptylist_count_increases_from_0_to_1_Test()
    {
        Employee addedEmployee = new Employee(1);
        LinkedList<Employee> list = new LinkedList<Employee>();

        assertEquals(list.getSize(), 0);

        list.addFirst(addedEmployee);

        assertEquals(list.getSize(), 1);
    }

    /// <summary>
    /// Test AddFirst() method to ensure the head pointer is updated when first object is inserted.
    /// </summary>
    @Test
    public void AddFirst_on_emptylist_Head_Updated_Test()
    {
        Employee employee1 = new Employee(1);

        LinkedList<Employee> list = new LinkedList<Employee>();

        assertNull(list.getHead());

        list.addFirst(employee1);

        assertEquals(list.getHead().getElement(), employee1);
    }

    /// <summary>
    /// Test AddFirst() method to ensure the tail pointer is updated when first object is inserted.
    /// </summary>
    @Test
    public void AddFirst_on_emptylist_Tail_Updated_Test()
    {
        Employee employee1 = new Employee(1);

        LinkedList<Employee> list = new LinkedList<Employee>();

        assertNull(list.getTail());

        list.addFirst(employee1);

        assertEquals(list.getTail().getElement(), employee1);
    }

    /// <summary>
    /// Test AddFirst() to ensure it can handle null being added to list.
    /// </summary>
    @Test
    public void AddFirst_null_element_is_allowed_Test() throws Exception {
        LinkedList<Employee> list = new LinkedList<Employee>();

        list.addFirst(null);

        assertEquals(list.getSize(), 1);
        assertNull(list.getFirst());
    }

    /// <summary>
    /// Test AddFirst() method to ensure the head pointer is updated when many objects are inserted.
    /// </summary>
    @Test
    public void AddFirst_on_larger_Existing_list_Head_tail_and_size_Updated_Test()
    {
        Employee employee1 = new Employee(1);
        Employee employee2 = new Employee(2);
        Employee employee3 = new Employee(3);

        LinkedList<Employee> list = new LinkedList<Employee>();

        assertNull(list.getHead());

        list.addFirst(employee3);
        Node<Employee> third = list.getHead();

        list.addFirst(employee2);
        Node<Employee> second = list.getHead();

        list.addFirst(employee1);
        Node<Employee> first = list.getHead();

        assertEquals(list.getHead().getElement(), employee1); // 1 , 2, 3, head should be 1
        assertEquals(list.getTail().getElement(), employee3); // 1 , 2, 3, tail should be 3

        assertTrue(CheckIntegrityBetweenListOfThreeNodes(list.getHead(), first, second, third, list.getTail(), list.getSize()));
    }

        //endregion

        //region .getSize()
    /// <summary>
    /// Test .getSize() to make sure it returns the proper size; mostly for fun here. :)
    /// </summary>
    @Test
    public void GetSize_returns_correct_value_after_random_adds_Test()
    {
        Random rnd = new Random();
        int numberOfElements = rnd.nextInt(50);

        Employee employee = new Employee(1);
        LinkedList<Employee> list = new LinkedList<Employee>();

        for (int i = 0; i < numberOfElements; i++)
        {
            list.addFirst(employee);
        }

        assertEquals(list.getSize(), numberOfElements);
    }
        //endregion

        //region GetFirst() and GetLast()

        /// <summary>
        /// Test that GetFirst throws an exception when called on an empty list, because Null.Element doesn't exist!
        /// </summary>
    @Test
    public void GetFirst_on_emptylist_throws_exception_Test()
    {

        LinkedList<Employee> list = new LinkedList<Employee>();
        assertThrows(NoSuchElementException.class, () -> list.getFirst());
    }

    /// <summary>
    /// Test that GetFirst returns the head's element
    /// </summary>
    @Test
    public void GetFirst_on_existinglist_returns_head_element_Test() throws Exception {
        LinkedList<Employee> list = new LinkedList<Employee>();
        list.addFirst(new Employee(1));

        assertEquals(list.getHead().getElement(), list.getFirst());
    }

    /// <summary>
    /// Test that GetLast throws an exception when called on an empty list, because Null.Element doesn't exist!
    /// </summary>
    @Test
    public void GetLast_on_emptylist_throws_exception_Test()
    {
        LinkedList<Employee> list = new LinkedList<Employee>();
        System.out.println("Wabc");


        //assertThrows(NoSuchElementException.class, () -> list.getLast() );
    }

    /// <summary>
    /// Test that GetLast returns the tail's element
    /// </summary>
    @Test
    public void GetLast_on_existinglist_returns_tail_element_Test() throws Exception {
        LinkedList<Employee> list = new LinkedList<Employee>();
        list.addFirst(new Employee(1));

        assertEquals(list.getTail().getElement(), list.getLast());
    }
        //endregion

        //region IsEmpty()
    /// <summary>
    /// Test IsEmpty() should return false on a list containing nodes.
    /// </summary>
    @Test
    public void IsEmpty_returns_false_on_existinglist_Test()
    {
        Employee employee = new Employee(1);

        LinkedList<Employee> list = new LinkedList<Employee>();
        list.addFirst(employee);

        assertFalse(list.isEmpty());
    }
    /// <summary>
    /// Test IsEmpty() should return true on a list containing no nodes.
    /// </summary>
    @Test
    public void IsEmpty_returns_true_on_empty_list_Test()
    {
        Employee employee = new Employee(1);

        LinkedList<Employee> list = new LinkedList<Employee>();

        assertTrue(list.isEmpty());
    }
        //endregion

        //region Clear()
    /// <summary>
    /// Test that Clear() empties a list.
    /// </summary>
    @Test
    public void ClearTest()
    {
        Employee employee1 = new Employee(1);
        Employee employee2 = new Employee(2);
        Employee employee3 = new Employee(3);

        LinkedList<Employee> list = new LinkedList<Employee>();

        list.addFirst(employee3);
        list.addFirst(employee2);
        list.addFirst(employee1);

        assertEquals(list.getSize(), 3);

        list.clear();

        assertTrue(list.isEmpty());
        assertTrue(list.getHead() == null);
        assertTrue(list.getTail() == null);
    }

    /// <summary>
    /// Test that calling Clear() on an empty list doesn't throw an exception.
    /// </summary>
    @Test
    public void ClearEmptyListTest()
    {
        LinkedList<Employee> list = new LinkedList<Employee>();

        try
        {
            list.clear();
        }
        catch (Exception e)
        {
            fail("Clear() should not have thrown exception.");
        }
    }
        //endregion

        //region SetFirst(element)
    /// <summary>
    /// Test SetFirst() on an empty list raises an exception.
    /// </summary>
    @Test
    public void SetFirst_on_emptyList_throws_exception_Test()
    {
        Employee employee1 = new Employee(1);

        LinkedList<Employee> list = new LinkedList<Employee>();

        assertThrows(NoSuchElementException.class, () -> list.setFirst(employee1));
    }

    /// <summary>
    /// Test SetFirst() replaces element on the head node on list of 1
    /// </summary>
    @Test
    public void SetFirst_on_list_of_1_replaces_head_element_Test() throws Exception {
        Employee employee1 = new Employee(1);
        Employee employee2 = new Employee(2);

        LinkedList<Employee> list = new LinkedList<Employee>();
        list.addFirst(employee1);

        list.setFirst(employee2);

        assertEquals(list.getFirst(), employee2);
        assertEquals(list.getSize(),1); //ensure size doesn't change!
    }

    /// <summary>
    /// Test SetFirst() returns the element that has been replaced.
    /// </summary>
    @Test
    public void SetFirst_Returns_ReplacedElement_Test() throws Exception {
        Employee employee1 = new Employee(1);
        Employee employee2 = new Employee(2);

        LinkedList<Employee> list = new LinkedList<Employee>();
        list.addFirst(employee1);

        var returnedData = list.setFirst(employee2);

        assertEquals(returnedData, employee1);
    }


    /// <summary>
    /// Test SetFirst() does_not_impact_an_existing_list (head/tail/size/pointers)
    /// </summary>
    @Test
    public void SetFirst_does_not_impact_an_existing_list_Test() throws Exception {
        Employee employee1 = new Employee(1);
        Employee employee2 = new Employee(2);
        Employee employee3 = new Employee(3);
        Employee employee4 = new Employee(4);

        LinkedList<Employee> list = new LinkedList<Employee>();
        list.addFirst(employee3);
        Node<Employee> third = list.getHead();

        list.addFirst(employee2);
        Node<Employee> second = list.getHead();

        list.addFirst(employee1);
        Node<Employee> first = list.getHead();

        var returnedData = list.setFirst(employee4);

        assertEquals(returnedData, employee1);

        assertTrue(CheckIntegrityBetweenListOfThreeNodes(list.getHead(), first, second, third, list.getTail(), list.getSize()));
    }

        //endregion

        //region setLast(element)

    /// <summary>
    /// Test setLast() on an empty list raises an exception.
    /// </summary>
    @Test
    public void setLast_on_emptyList_throws_exception_Test()
    {
        Employee employee1 = new Employee(1);

        LinkedList<Employee> list = new LinkedList<Employee>();

        assertThrows(NoSuchElementException.class, () -> list.setLast(employee1));
    }

    /// <summary>
    /// Test setLast() replaces element on the tail node.
    /// </summary>
    @Test
    public void setLast_on_existingList_updates_tail_element_Test() throws Exception {
        Employee employee1 = new Employee(1);
        Employee employee2 = new Employee(2);
        Employee employee3 = new Employee(3);

        LinkedList<Employee> list = new LinkedList<Employee>();
        list.addFirst(employee1);
        list.addFirst(employee2);

        list.setLast(employee3);

        assertEquals(list.getLast(), employee3);
    }

    /// <summary>
    /// Test setLast() returns the element that has been replaced.
    /// </summary>
    @Test
    public void setLast_returns_replaced_element_Test() throws Exception {
        Employee employee1 = new Employee(1);
        Employee employee2 = new Employee(2);
        Employee employee3 = new Employee(3);

        LinkedList<Employee> list = new LinkedList<Employee>();
        list.addFirst(employee1);
        list.addFirst(employee2);

        var returnedData = list.setLast(employee3);

        assertEquals(returnedData, employee1);
    }


    /// <summary>
    /// Test setLast() does_not_impact_an_existing_list (head/tail/size/pointers)
    /// </summary>
    @Test
    public void setLast_does_not_impact_an_existing_list_Test() throws Exception {
        Employee employee1 = new Employee(1);
        Employee employee2 = new Employee(2);
        Employee employee3 = new Employee(3);
        Employee employee4 = new Employee(4);

        LinkedList<Employee> list = new LinkedList<Employee>();
        list.addFirst(employee3);
        Node<Employee> third = list.getHead();

        list.addFirst(employee2);
        Node<Employee> second = list.getHead();

        list.addFirst(employee1);
        Node<Employee> first = list.getHead();

        var returnedData = list.setLast(employee4);

        assertEquals(returnedData, employee3);

        assertTrue(CheckIntegrityBetweenListOfThreeNodes(list.getHead(), first, second, third, list.getTail(), list.getSize()));
    }

    //endregion
    //region addLast()
    /// <summary>
    /// Test addLast() to ensure node is added to list.
    /// </summary>
    @Test
    public void addLast_to_emptyList_count_increases_Test()
    {
        Employee addedEmployee = new Employee(1);
        LinkedList<Employee> list = new LinkedList<Employee>();
        list.addLast(addedEmployee);

        assertEquals(list.getSize(), 1);
    }

    /// <summary>
    /// Test addLast() to ensure node is added to list.
    /// </summary>
    @Test
    public void addLast_to_emptyList_tail_updated_Test() throws Exception {
        Employee addedEmployee = new Employee(1);
        LinkedList<Employee> list = new LinkedList<Employee>();
        list.addLast(addedEmployee);

        assertEquals(list.getLast(), addedEmployee);
    }
    /// <summary>
    /// Test addLast() to ensure node is added to list.
    /// </summary>
    @Test
    public void addLast_to_emptyList_head_updated_Test() throws Exception {
        Employee addedEmployee = new Employee(1);
        LinkedList<Employee> list = new LinkedList<Employee>();
        list.addLast(addedEmployee);

        assertEquals(list.getFirst(), addedEmployee);
    }

    /// <summary>
    /// Test addLast() to ensure it can handle null being added to list.
    /// </summary>
    @Test
    public void addLast_Null_element_is_allowed_Test() throws Exception {
        LinkedList<Employee> list = new LinkedList<Employee>();
        list.addLast(null);

        assertEquals(list.getSize(), 1);
        assertNull(list.getFirst());
        assertNull(list.getLast());
    }


    /// <summary>
    /// Test addLast() method to ensure the head pointer is updated when many objects are inserted.
    /// </summary>
    @Test
    public void addLast_on_larger_Existing_list_Head_tail_and_size_Updated_Test()
    {
        Employee employee1 = new Employee(1);
        Employee employee2 = new Employee(2);
        Employee employee3 = new Employee(3);

        LinkedList<Employee> list = new LinkedList<Employee>();

        assertNull(list.getHead());

        list.addLast(employee1);
        Node<Employee> first = list.getTail();

        list.addLast(employee2);
        Node<Employee> second = list.getTail();

        list.addLast(employee3);
        Node<Employee> third = list.getTail();

        assertEquals(list.getHead().getElement(), employee1); // 1 , 2, 3, head should be 1
        assertEquals(list.getTail().getElement(), employee3); // 1 , 2, 3, tail should be 3

        assertTrue(CheckIntegrityBetweenListOfThreeNodes(list.getHead(), first, second, third, list.getTail(), list.getSize()));
    }

    //endregion

    //endregion



    //region Milestone 2


    //region removeFirst()
    /// <summary>
    /// Test calling removeFirst() on an empty list causes an exception.
    /// </summary>
    @Test
    public void removeFirst_on_EmptyList_throws_exception_test()
    {
        LinkedList<Employee> list = new LinkedList<Employee>();

        assertThrows(NoSuchElementException.class, () -> list.removeFirst());
    }

    /// <summary>
    /// Test removeFirst() returns reduced count by 1
    /// </summary>
    @Test
    public void removeFirst_decreases_count_by_1_Test() throws Exception {
        Employee employee1 = new Employee(1);

        LinkedList<Employee> list = new LinkedList<Employee>();
        list.addFirst(employee1);
        assertEquals(list.getSize(), 1);
        list.removeFirst();
        assertEquals(list.getSize(), 0);
    }

    /// <summary>
    /// Test removeFirst() returns the element removed.
    /// </summary>
    @Test
    public void removeFirst_Returns_first_Element_Test() throws Exception {
        Employee employee1 = new Employee(1);

        LinkedList<Employee> list = new LinkedList<Employee>();

        list.addFirst(employee1);
        var firstElement = list.getFirst();
        var returnedElement = list.removeFirst();

        assertEquals(returnedElement, firstElement);
    }

    /// <summary>
    /// Test removeFirst() removes the head and tail on size 1 list
    /// </summary>
    @Test
    public void removeFirst_on_list_of_size_1_removes_head_and_tail_Test() throws Exception {
        Employee employee1 = new Employee(1);

        LinkedList<Employee> list = new LinkedList<Employee>();
        list.addFirst(employee1);
        list.removeFirst();

        assertTrue(list.isEmpty());
        assertNull(list.getHead());
        assertNull(list.getTail());
    }

    /// <summary>
    /// removeFirst_on_larger_existingList_updates_head_pointers_size_Test
    /// </summary>
    @Test
    public void removeFirst_on_larger_existingList_updates_head_pointers_size_Test() throws Exception {
        Employee employee1 = new Employee(1);
        Employee employee2 = new Employee(2);
        Employee employee3 = new Employee(3);

        LinkedList<Employee> list = new LinkedList<Employee>();

        list.addFirst(employee3);
        Node<Employee> third = list.getHead();

        list.addFirst(employee2);
        Node<Employee> second = list.getHead();

        list.addFirst(employee1);
        Node<Employee> first = list.getHead();

        var returnedElement = list.removeFirst();

        assertEquals(returnedElement, employee1);

        assertTrue(CheckIntegrityBetweenListOfTwoNodes(list.getHead(), second, third, list.getTail(), list.getSize()));
    }

        //endregion

        //region removeLast()
    /// <summary>
    /// Test calling removeLast() on an empty list causes an exception.
    /// </summary>
    @Test
    public void removeLast_on_EmptyList_throws_exception_test()
    {
        LinkedList<Employee> list = new LinkedList<Employee>();

        assertThrows(NoSuchElementException.class, () -> list.removeLast());
    }

    /// <summary>
    /// Test removeLast() decreases count by 1.
    /// </summary>
    @Test
    public void removeLast_decreases_count_by_1_Test() throws Exception {
        Employee employee1 = new Employee(1);

        LinkedList<Employee> list = new LinkedList<Employee>();
        list.addFirst(employee1);
        assertEquals(list.getSize(), 1);
        list.removeLast();

        assertEquals(list.getSize(), 0);
    }

    /// <summary>
    /// Test removeLast() returns the element removed.
    /// </summary>
    @Test
    public void removeLast_Returns_last_Element_Test() throws Exception {
        Employee employee1 = new Employee(1);

        LinkedList<Employee> list = new LinkedList<Employee>();
        list.addFirst(employee1);
        var lastElement = list.getLast();
        var returnedElement = list.removeLast();

        assertEquals(returnedElement, lastElement);
    }

    /// <summary>
    /// Test removeLast() removes head and tail on size 1 list
    /// </summary>
    @Test
    public void removeLast_on_list_of_size_1_removes_head_and_tail_Test() throws Exception {
        Employee employee1 = new Employee(1);

        LinkedList<Employee> list = new LinkedList<Employee>();
        list.addFirst(employee1);

        list.removeLast();

        assertTrue(list.isEmpty());
        assertNull(list.getHead());
        assertNull(list.getTail());
    }

    /// <summary>
    /// removeLast_on_larger_existingList_updates_tail_pointers_size_Test
    /// </summary>
    @Test
    public void removeLast_on_larger_existingList_updates_tail_pointers_size_Test() throws Exception {
        Employee employee1 = new Employee(1);
        Employee employee2 = new Employee(2);
        Employee employee3 = new Employee(3);

        LinkedList<Employee> list = new LinkedList<Employee>();

        list.addFirst(employee3);
        Node<Employee> third = list.getHead();

        list.addFirst(employee2);
        Node<Employee> second = list.getHead();

        list.addFirst(employee1);
        Node<Employee> first = list.getHead();

        var returnedElement = list.removeLast();

        assertEquals(returnedElement, employee3);

        assertTrue(CheckIntegrityBetweenListOfTwoNodes(list.getHead(), first, second, list.getTail(), list.getSize()));
    }


        //endregion

        //region Get(position)

    /// <summary>
    /// Make sure that calling Get(position) on an empty list results in an exception.
    /// </summary>
    @Test
    public void Get_By_Position_On_EmptyList_throws_exception_Test()
    {
        LinkedList<Employee> list = new LinkedList<Employee>();

        assertThrows(NoSuchElementException.class, () -> list.get(1));
    }

    /// <summary>
    /// Make sure at calling Get(position) with a negative number results in an exception.
    /// </summary>
    @Test
    public void Get_By_number_less_than_1_on_existingList_throws_exception_Test()
    {
        Employee employee1 = new Employee(1);
        Employee employee2 = new Employee(2);

        LinkedList<Employee> list = new LinkedList<Employee>();

        list.addFirst(employee2);
        list.addFirst(employee1);

        assertThrows(NoSuchElementException.class, () -> list.get(-1));
    }

    /// <summary>
    /// Ensure that calling Get(positoin) with a value larger than the size of the list results in an exception.
    /// </summary>
    @Test
    public void Get_By_Position_larger_than_list_size_throws_exception_Test()
    {
        Employee employee1 = new Employee(1);
        Employee employee2 = new Employee(2);

        LinkedList<Employee> list = new LinkedList<Employee>();

        list.addFirst(employee2);
        list.addFirst(employee1);

        assertThrows(NoSuchElementException.class, () -> list.get(list.getSize() + 1));
    }

    /// <summary>
    /// Ensure that Get(position) returns the element at the correct position.
    /// </summary>
    @Test
    public void Get_By_Position_1_on_existingList_returns_head_element_Test() throws Exception {
        Employee employee1 = new Employee(1);
        Employee employee2 = new Employee(2);

        LinkedList<Employee> list = new LinkedList<Employee>();

        list.addFirst(employee1);

        assertEquals(list.get(1), list.getFirst());
    }

    /// <summary>
    /// Ensure that Get(position) returns the element at the correct position.
    /// </summary>
    @Test
    public void Get_By_Position_2_on_list_of_size_2_returns_last_element_Test() throws Exception {
        Employee employee1 = new Employee(1);
        Employee employee2 = new Employee(2);

        LinkedList<Employee> list = new LinkedList<Employee>();

        list.addFirst(employee2);
        list.addFirst(employee1);

        assertEquals(list.get(2), list.getLast());
    }


    /// <summary>
    /// Get_By_Position_2_on_list_of_size_3_returns_last_element_does_not_impact_tail_head_size_pointers_Test
    /// </summary>
    @Test
    public void Get_By_Position_2_on_list_of_size_3_returns_last_element_does_not_impact_tail_head_size_pointers_Test() throws Exception {
        Employee employee1 = new Employee(1);
        Employee employee2 = new Employee(2);
        Employee employee3 = new Employee(3);

        LinkedList<Employee> list = new LinkedList<Employee>();

        list.addFirst(employee3);
        Node<Employee> third = list.getHead();

        list.addFirst(employee2);
        Node<Employee> second = list.getHead();

        list.addFirst(employee1);
        Node<Employee> first = list.getHead();

        assertEquals(list.getHead().getElement(), employee1); // 1 , 2, 3, head should be 1
        assertEquals(list.getTail().getElement(), employee3); // 1 , 2, 3, tail should be 3

        assertEquals(list.get(2), second.getElement());

        assertTrue(CheckIntegrityBetweenListOfThreeNodes(list.getHead(), first, second, third, list.getTail(), list.getSize()));
    }

        //endregion

        //region addAfter(element, position)
    /// <summary>
    /// Ensure that calling addAfter() on an empty list will result in an exception.
    /// </summary>
    @Test
    public void addAfterPosition_on_EmptyList_throws_exception_test()
    {
        Employee employee = new Employee(1);

        LinkedList<Employee> list = new LinkedList<Employee>();

        assertThrows(NoSuchElementException.class, () -> list.addAfter(employee, 1));
    }

    /// <summary>
    /// Ensure that passing a negative position value to addAfter(element, position) results in an exception.
    /// </summary>
    @Test
    public void addAfterPosition_Negative_Position_throws_exception_Test()
    {
        Employee employee = new Employee(1);
        Employee addEmployee = new Employee(2);

        LinkedList<Employee> list = new LinkedList<Employee>();
        list.addFirst(employee);

        assertThrows(NoSuchElementException.class, () -> list.addAfter(addEmployee, -1));
    }

    /// <summary>
    /// Ensure that passing a position value larger than size to addAfter(element, position) results in an exception.
    /// </summary>
    @Test
    public void addAfterPosition_getsize_plus_1_throws_exception_Test()
    {
        Employee employee = new Employee(1);
        Employee addEmployee = new Employee(2);

        LinkedList<Employee> list = new LinkedList<Employee>();
        list.addFirst(employee);

        assertThrows(NoSuchElementException.class, () -> list.addAfter(addEmployee, list.getSize() + 1));
    }


    /// <summary>
    /// Checking edge case; Ensure that passing the size as the position will append to the end of the list without error.
    /// </summary>
    @Test
    public void addAfterPosition_using_GetSize_on_existingList_updates_tail_Test() throws Exception {
        Employee employee1 = new Employee(1);
        Employee employee2 = new Employee(2);
        Employee employee3 = new Employee(3);

        LinkedList<Employee> list = new LinkedList<Employee>();

        list.addFirst(employee2);
        Node<Employee> second = list.getHead();

        list.addFirst(employee1);
        Node<Employee> first = list.getHead();

        list.addAfter(employee3, list.getSize()); // 1, 2, 3... should add to tail, after 2

        Node<Employee> third = list.getTail();

        assertEquals(list.get(1), employee1);
        assertEquals(list.get(2), employee2);
        assertEquals(list.get(3), employee3);

        assertTrue(CheckIntegrityBetweenListOfThreeNodes(list.getHead(), first, second, third, list.getTail(), list.getSize()));
    }

    /// <summary>
    /// Make sure element is inserted into proper position.
    /// </summary>
    @Test
    public void addAfter_Position_1_on_existingList_inserts_after_head_pointers_updatedTest() throws Exception {
        Employee employee1 = new Employee(1);
        Employee employee2 = new Employee(2);
        Employee employee3 = new Employee(3);

        LinkedList<Employee> list = new LinkedList<Employee>();

        list.addFirst(employee3);
        Node<Employee> third = list.getHead();

        list.addFirst(employee1);
        Node<Employee> first = list.getHead();

        list.addAfter(employee2, 1); // 1, 2, 3 after this add
        Node<Employee> second = first.getNext();

        assertEquals(list.get(1), employee1);
        assertEquals(list.get(2), employee2);
        assertEquals(list.get(3), employee3);

        assertTrue(CheckIntegrityBetweenListOfThreeNodes(list.getHead(), first, second, third, list.getTail(), list.getSize()));
    }

        //endregion

        //region addBefore(element, positon)
    /// <summary>
    /// Ensure that calling addBefore() on an empty list will result in an exception.
    /// </summary>
    @Test
    public void addBeforePosition_on_EmptyList_throws_exception_test()
    {
        Employee employee = new Employee(1);

        LinkedList<Employee> list = new LinkedList<Employee>();

        assertThrows(NoSuchElementException.class, () -> list.addAfter(employee, 1));
    }

    /// <summary>
    /// Ensure that passing a negative position value to addBefore(element, position) results in an exception.
    /// </summary>
    @Test
    public void addBeforePosition_Negative_Position_throws_exception_Test()
    {
        Employee employee = new Employee(1);
        Employee addEmployee = new Employee(2);

        LinkedList<Employee> list = new LinkedList<Employee>();
        list.addFirst(employee);

        assertThrows(NoSuchElementException.class, () -> list.addBefore(addEmployee, -1));
    }

    /// <summary>
    /// Ensure that passing a position value larger than size to addBefore(element, position) results in an exception.
    /// </summary>
    @Test
    public void addBeforePosition_getsize_plus_1_throws_exception_Test()
    {
        Employee employee = new Employee(1);
        Employee addEmployee = new Employee(2);

        LinkedList<Employee> list = new LinkedList<Employee>();
        list.addFirst(employee);

        assertThrows(NoSuchElementException.class, () -> list.addBefore(addEmployee, list.getSize() + 1));
    }



    /// <summary>
    /// add before anything else is an add between nodes
    /// </summary>
    @Test
    public void addBeforePosition_using_GetSize_on_existingList_Test() throws Exception {
        Employee employee1 = new Employee(1);
        Employee employee2 = new Employee(2);
        Employee employee3 = new Employee(3);

        LinkedList<Employee> list = new LinkedList<Employee>();

        list.addFirst(employee3);
        Node<Employee> third = list.getHead();

        list.addFirst(employee1);
        Node<Employee> first = list.getHead();

        list.addBefore(employee2, list.getSize()); // 1, 2, 3... should add before 3

        //Se cae
        Node<Employee> second = list.getTail().getPrevious();

        assertEquals(list.get(1), employee1);
        assertEquals(list.get(2), employee2);
        assertEquals(list.get(3), employee3);

        assertTrue(CheckIntegrityBetweenListOfThreeNodes(list.getHead(), first, second, third, list.getTail(), list.getSize()));
    }

    /// <summary>
    /// Checking edge case; Ensure that passing position 1 will prepepend to the begining of the list without error.
    /// </summary>
    @Test
    public void addBefore_Position_1_on_existingList_updates_head_and_pointers_Test() throws Exception {
        Employee employee1 = new Employee(1);
        Employee employee2 = new Employee(2);
        Employee employee3 = new Employee(3);

        LinkedList<Employee> list = new LinkedList<Employee>();

        list.addFirst(employee3);
        Node<Employee> third = list.getHead();

        list.addFirst(employee2);
        Node<Employee> second = list.getHead();

        list.addBefore(employee1, 1); // 1, 2, 3 after this add
        Node<Employee> first = list.getHead();

        assertEquals(list.get(1), employee1);
        assertEquals(list.get(2), employee2);
        assertEquals(list.get(3), employee3);

        assertTrue(CheckIntegrityBetweenListOfThreeNodes(list.getHead(), first, second, third, list.getTail(), list.getSize()));
    }
        //endregion

        //region remove(position)
    /// <summary>
    /// Make sure that calling remove(position) on an empty list results in an exception.
    /// </summary>
    @Test
    public void RemoveByPosition_On_EmptyList_throw_exception_Test()
    {
        LinkedList<Employee> list = new LinkedList<Employee>();

        assertThrows(NoSuchElementException.class, () -> list.remove(1));
    }

    /// <summary>
    /// Make sure at calling remove(position) with a negative number results in an exception.
    /// </summary>
    @Test
    public void RemoveByPosition_Negative_number_throws_exception_Test()
    {
        Employee employee1 = new Employee(1);
        Employee employee2 = new Employee(2);

        LinkedList<Employee> list = new LinkedList<Employee>();

        list.addFirst(employee2);
        list.addFirst(employee1);

        assertThrows(NoSuchElementException.class, () -> list.remove(-1));
    }

    /// <summary>
    /// Ensure that calling remove(position) with a value of zero results in an exception.
    /// </summary>
    @Test
    public void RemoveByPosition_Zero_throws_exception_Test()
    {
        Employee employee1 = new Employee(1);
        Employee employee2 = new Employee(2);

        LinkedList<Employee> list = new LinkedList<Employee>();

        list.addFirst(employee2);
        list.addFirst(employee1);

        assertThrows(NoSuchElementException.class, () -> list.remove(0));
    }

    /// <summary>
    /// Ensure that calling remove(position) with a value larger than the size of the list results in an exception.
    /// </summary>
    @Test
    public void RemoveByPosition_getsize_plus_one_throws_exception_Test()
    {
        Employee employee1 = new Employee(1);
        Employee employee2 = new Employee(2);

        LinkedList<Employee> list = new LinkedList<Employee>();

        list.addFirst(employee2);
        list.addFirst(employee1);

        assertThrows(NoSuchElementException.class, () -> list.remove(100));
    }

    /// <summary>
    /// Ensure that remove() returns the element removed.
    /// </summary>
    @Test
    public void RemoveByPosition_Returns_an_Element_Test() throws Exception {
        Employee employee1 = new Employee(1);

        LinkedList<Employee> list = new LinkedList<Employee>();

        list.addFirst(employee1);

        var returnedElement = list.remove(1);

        assertEquals(returnedElement, employee1);
    }

    /// <summary>
    /// Ensure that remove() decreases count and clears the list
    /// </summary>
    @Test
    public void RemoveByPosition_decreases_count_by_one_updates_head_tail_Test() throws Exception {
        Employee employee1 = new Employee(1);

        LinkedList<Employee> list = new LinkedList<Employee>();

        list.addFirst(employee1);

        assertEquals(list.getSize(), 1);

        var returnedElement = list.remove(1);

        assertEquals(list.getSize(), 0);
        assertNull(list.getHead());
        assertNull(list.getTail());
    }


    /// <summary>
    /// RemoveByPosition_list_of_size_2_updates_tail_when_size_1_Test
    /// </summary>
    @Test
    public void RemoveByPosition_list_of_size_2_updates_tail_when_size_1_Test() throws Exception {
        Employee employee1 = new Employee(1);
        Employee employee2 = new Employee(2);

        LinkedList<Employee> list = new LinkedList<Employee>();

        list.addFirst(employee2);
        Node<Employee> last = list.getHead();

        list.addFirst(employee1);
        Node<Employee> first = list.getHead();

        var returnedElement = list.remove(list.getSize()); // removes employee 2

        assertEquals(returnedElement, employee2);

        // check employee 1 is the only one left and is the head and tail, with a list size of 1
        assertTrue(CheckIntegrityBetweenListOfOneNode(list.getHead(), first, list.getTail(), list.getSize()));
    }


    /// <summary>
    /// RemoveByPosition_last_position_on_list_of_size_3_updates_tail_Test
    /// </summary>
    @Test
    public void RemoveByPosition_last_position_on_list_of_size_3_updates_tail_Test() throws Exception {
        Employee employee1 = new Employee(1);
        Employee employee2 = new Employee(2);
        Employee employee3 = new Employee(3);

        LinkedList<Employee> list = new LinkedList<Employee>();

        list.addFirst(employee3);
        Node<Employee> last = list.getHead();

        list.addFirst(employee2);
        Node<Employee> second = list.getHead();

        list.addFirst(employee1);
        Node<Employee> first = list.getHead();

        var returnedElement = list.remove(list.getSize()); // removes employee 3

        assertEquals(returnedElement, employee3);

        // check employee 1 is the head amd employee2 is the tail, with a list size of 2
        assertTrue(CheckIntegrityBetweenListOfTwoNodes(list.getHead(), first, second, list.getTail(), list.getSize()));
    }

    /// <summary>
    /// Ensure that remove() removes the element at the correct position.
    /// </summary>
    @Test
    public void RemoveByPosition_2_in_list_of_size_3_removes_the_right_node_Test() throws Exception {
        Employee employee1 = new Employee(1);
        Employee employee2 = new Employee(2);
        Employee employee3 = new Employee(3);

        LinkedList<Employee> list = new LinkedList<Employee>();

        list.addFirst(employee3);
        Node<Employee> last = list.getHead();

        list.addFirst(employee2);
        Node<Employee> second = list.getHead();

        list.addFirst(employee1);
        Node<Employee> first = list.getHead();

        var returnedElement = list.remove(2); // removes employee2

        assertEquals(returnedElement, employee2);

        // check employee 1 is the head amd employee3 is the tail, with a list size of 2
        assertTrue(CheckIntegrityBetweenListOfTwoNodes(list.getHead(), first, last, list.getTail(), list.getSize()));
    }


    /// <summary>
    /// Test remove(position) properly updated the head when removing from position 1.
    /// </summary>
    @Test
    public void RemoveByPosition_Head_Updated_Test() throws Exception {
        Employee employee1 = new Employee(1);
        Employee employee2 = new Employee(2);
        Employee employee3 = new Employee(3);

        LinkedList<Employee> list = new LinkedList<Employee>();

        list.addFirst(employee3);
        Node<Employee> last = list.getHead();

        list.addFirst(employee2);
        Node<Employee> second = list.getHead();

        list.addFirst(employee1);
        Node<Employee> first = list.getHead();

        var returnedElement = list.remove(1); // removes employee 1

        assertEquals(returnedElement, employee1);

        // check employee2 is the head amd employee3 is the tail, with a list size of 2
        assertTrue(CheckIntegrityBetweenListOfTwoNodes(list.getHead(), second, last, list.getTail(), list.getSize()));
    }

        //endregion

        //region Set(element, position)
    /// <summary>
    /// Test Set(position) on an empty list results in an exception.
    /// </summary>
    @Test
    public void SetByPosition_On_EmptyList_throws_exception_Test()
    {
        Employee employee1 = new Employee(1);

        LinkedList<Employee> list = new LinkedList<Employee>();

        assertThrows(NoSuchElementException.class, () -> list.set(employee1, 1));
    }

    /// <summary>
    /// Test Set(position) with a negative number results in an exception.
    /// </summary>
    @Test
    public void SetByPosition_Negative_Value_throws_exception_Test()
    {
        Employee employee1 = new Employee(1);
        Employee employee2 = new Employee(2);

        LinkedList<Employee> list = new LinkedList<Employee>();

        list.addFirst(employee1);

        assertThrows(NoSuchElementException.class, () -> list.set(employee2, -1));
    }

    /// <summary>
    /// Test Set(position) with a value of zero results in an exception.
    /// </summary>
    @Test
    public void SetByPosition_Zero_throws_exception_Test()
    {
        Employee employee1 = new Employee(1);
        Employee employee2 = new Employee(2);

        LinkedList<Employee> list = new LinkedList<Employee>();

        list.addFirst(employee1);

        assertThrows(NoSuchElementException.class, () -> list.set(employee2, 0));
    }

    /// <summary>
    /// Test Set(position) with a value larger than the size of the list results in an exception.
    /// </summary>
    @Test
    public void SetByPositionLargerThanSizeTest()
    {
        Employee employee1 = new Employee(1);
        Employee employee2 = new Employee(2);

        LinkedList<Employee> list = new LinkedList<Employee>();

        list.addFirst(employee1);

        assertThrows(NoSuchElementException.class, () -> list.set(employee2, 100));
    }

    /// <summary>
    /// Ensure that Set(position) sets the element at the correct position.
    /// </summary>
    @Test
    public void SetByPosition_1_on_list_of_1_updates_element_Test() throws Exception {
        Employee employee1 = new Employee(1);
        Employee employee2 = new Employee(2);

        LinkedList<Employee> list = new LinkedList<Employee>();

        list.addFirst(employee1);
        Node<Employee> first = list.getHead();

        assertEquals(list.get(1), employee1);

        list.set(employee2, 1);

        assertEquals(list.get(1), employee2);

        // check that pointers are still correct and head/tail has not changed:
        assertTrue(CheckIntegrityBetweenListOfOneNode(list.getHead(),first,list.getTail(),list.getSize()));
    }

    /// <summary>
    /// Test Set(position) returns the replaced element.
    /// </summary>
    @Test
    public void SetByPosition_Returns_old_Element_Test() throws Exception {
        Employee employee1 = new Employee(1);
        Employee employee2 = new Employee(2);

        LinkedList<Employee> list = new LinkedList<Employee>();
        list.addFirst(employee1);

        var returnedData = list.set(employee2, 1);

        assertEquals(returnedData, employee1);
    }

    /// <summary>
    /// Ensure that Set(position) sets the element at the correct position.
    /// </summary>
    @Test
    public void SetByPosition_3_on_list_of_3_updates_element_Test() throws Exception {

        Employee employee1 = new Employee(1);
        Employee employee2 = new Employee(2);
        Employee employee3 = new Employee(3);
        Employee employee4 = new Employee(4);

        LinkedList<Employee> list = new LinkedList<Employee>();

        list.addFirst(employee3);
        Node<Employee> last = list.getHead();

        list.addFirst(employee2);
        Node<Employee> second = list.getHead();

        list.addFirst(employee1);
        Node<Employee> first = list.getHead();

        var returnedElement = list.set(employee4,list.getSize()); // replaces employee3 with employee4

        assertEquals(returnedElement, employee3);

        // check employee 1 is the head amd employee4 is the tail, with a list size of 3
        assertTrue(CheckIntegrityBetweenListOfThreeNodes(list.getHead(), first, second, last, list.getTail(), list.getSize()));
    }
        //endregion
        //endregion

        //region Milestone 3

        //region Get(element)


    /// <summary>
    /// Make sure that Get(element) on an empty list results in an exception.
    /// </summary>
    @Test
    public void GetByElement_On_EmptyList_throw_exception_Test()
    {
        Employee employee = new Employee(1);

        LinkedList<Employee> list = new LinkedList<Employee>();

        assertThrows(NoSuchElementException.class, () -> list.get(employee));
    }

    /// <summary>
    /// Ensure that calling Get(element) with element that is not in the list results in an exception.
    /// </summary>
    @Test
    public void GetByElement_no_match_found_throws_exception_Test()
    {
        Employee employee = new Employee(1);
        Employee missingEmployee = new Employee(2);

        LinkedList<Employee> list = new LinkedList<Employee>();
        list.addFirst(employee);

        assertThrows(NoSuchElementException.class, () -> list.get(missingEmployee));
    }


    /// <summary>
    /// Ensure that Get by element returns the element at the correct element.
    /// </summary>
    @Test
    public void GetByElement_returns_the_element_Test() throws Exception {
        Employee employee1 = new Employee(1);
        Employee employee2 = new Employee(2);

        LinkedList<Employee> list = new LinkedList<Employee>();

        list.addFirst(employee2);
        list.addFirst(employee1);

        assertTrue(list.get(employee1).compareTo(employee1) == 0);
        assertTrue(list.get(employee2).compareTo(employee2) == 0);
    }

    /// <summary>
    /// Ensure that calling Get(element) with element that matches multiple list elements returns only one result.
    /// </summary>
    @Test
    public void GetByElement_Multiple_matches_found_returns_first_match_test() throws Exception {
        Employee employee = new Employee(1);
        Employee employee2 = new Employee(2);

        LinkedList<Employee> list = new LinkedList<Employee>();
        list.addLast(employee);
        list.addLast(employee2);
        list.addLast(employee);

        assertTrue(list.get(employee).compareTo(employee) == 0);
    }
        //endregion

        //region addAfter(element, oldElement)
    /// <summary>
    /// Ensure that calling addAfter(element) on an empty list will result in an exception.
    /// </summary>
    @Test
    public void addAfterByElement_on_EmptyList_throws_exception_test()
    {
        Employee employee = new Employee(1);
        LinkedList<Employee> list = new LinkedList<Employee>();
        assertThrows(NoSuchElementException.class, () -> list.addAfter(employee, employee));
    }

    /// <summary>
    /// Ensure that passing element that is not in the list to addAfter(element) results in an exception.
    /// </summary>
    @Test
    public void addAfterByElement_no_match_found_throws_exception_Test()
    {
        Employee employee = new Employee(1);
        Employee addEmployee = new Employee(2);
        Employee nonListEmployee = new Employee(3);

        LinkedList<Employee> list = new LinkedList<Employee>();
        list.addFirst(employee);

        assertThrows(NoSuchElementException.class, () -> list.addAfter(addEmployee, nonListEmployee));
    }

    /// <summary>
    /// Ensure that passing null value to addAfter(element, position) results in an exception.
    /// </summary>
    @Test
    public void addAfterByElement_when_element_is_null_throws_exception_Test()
    {
        Employee employee = new Employee(1);
        Employee addEmployee = new Employee(2);

        LinkedList<Employee> list = new LinkedList<Employee>();
        list.addFirst(employee);

        assertThrows(NullPointerException.class, () -> list.addAfter(addEmployee, null));
    }


    /// <summary>
    /// Checking edge case; Ensure that passing the tail element will append to the end of the list without error.
    /// </summary>
    @Test
    public void addAfterByElement_using_last_element_on_existingList_updates_tail_Test() throws Exception {
        Employee employee1 = new Employee(1);
        Employee employee2 = new Employee(2);
        Employee employee3 = new Employee(3);

        LinkedList<Employee> list = new LinkedList<Employee>();

        list.addFirst(employee2);
        Node<Employee> second = list.getHead();

        list.addFirst(employee1);
        Node<Employee> first = list.getHead();

        list.addAfter(employee3, list.getTail().getElement()); // 1, 2, 3... should add to tail, after 2

        Node<Employee> third = list.getTail();

        assertEquals(list.get(1), employee1);
        assertEquals(list.get(2), employee2);
        assertEquals(list.get(3), employee3);

        assertTrue(CheckIntegrityBetweenListOfThreeNodes(list.getHead(), first, second, third, list.getTail(), list.getSize()));
    }

    /// <summary>
    /// Make sure element is inserted into proper position.
    /// </summary>
    @Test
    public void addAfterByElement_using_head_element_on_existing_list_inserts_between_nodes_Test() throws Exception {
        Employee employee1 = new Employee(1);
        Employee employee2 = new Employee(2);
        Employee employee3 = new Employee(3);

        LinkedList<Employee> list = new LinkedList<Employee>();

        list.addFirst(employee3);
        Node<Employee> third = list.getHead();

        list.addFirst(employee1);
        Node<Employee> first = list.getHead();

        list.addAfter(employee2, list.getHead().getElement()); // 1, 2, 3, will add 2 after 1

        Node<Employee> second = list.getHead().getNext();

        assertEquals(list.get(1), employee1);
        assertEquals(list.get(2), employee2);
        assertEquals(list.get(3), employee3);

        assertTrue(CheckIntegrityBetweenListOfThreeNodes(list.getHead(), first, second, third, list.getTail(), list.getSize()));

    }
    /// <summary>
    /// Ensure that passing a element that appears multiple times in the list to addAfter(element, oldElement) element is inserted after first instance.
    /// </summary>
    @Test
    public void addAfterByElement_multiple_match_found_adds_after_first_instance_Test() throws Exception {
        Employee employee = new Employee(1);
        Employee employee2 = new Employee(2);
        Employee addEmployee = new Employee(3);

        LinkedList<Employee> list = new LinkedList<Employee>();
        list.addFirst(employee);
        Node<Employee> fourth = list.getHead();

        list.addFirst(employee2);
        Node<Employee> third = list.getHead();

        list.addFirst(employee); // order will be: 1, 2, 1
        Node<Employee> first = list.getHead();

        list.addAfter(addEmployee, employee); // order should be: 1, 3, 2, 1
        Node<Employee> second = list.getHead().getNext();

        assertEquals(list.get(1), first.getElement());
        assertEquals(list.get(2), second.getElement());
        assertEquals(list.get(3), third.getElement());
        assertEquals(list.get(4), fourth.getElement());

        assertTrue(CheckIntegrityBetweenListOfFourNodes(list.getHead(), first, second, third, fourth, list.getTail(), list.getSize()));
    }
        //endregion

        //region addBefore(element, oldElement)
    /// <summary>
    /// Ensure that calling addBefore(element) on an empty list will result in an exception.
    /// </summary>
    @Test
    public void addBeforeByElement_on_EmptyList_throws_exception_test()
    {
        Employee employee = new Employee(1);
        LinkedList<Employee> list = new LinkedList<Employee>();
        assertThrows(NoSuchElementException.class, () -> list.addBefore(employee, employee));
    }

    /// <summary>
    /// Ensure that passing element that is not in the list to addBefore(element) results in an exception.
    /// </summary>
    @Test
    public void addBeforeByElement_no_match_found_throws_exception_Test()
    {
        Employee employee = new Employee(1);
        Employee addEmployee = new Employee(2);
        Employee nonListEmployee = new Employee(3);

        LinkedList<Employee> list = new LinkedList<Employee>();
        list.addFirst(employee);

        assertThrows(NoSuchElementException.class, () -> list.addBefore(addEmployee, nonListEmployee));
    }

    /// <summary>
    /// Ensure that passing null value to addBefore(element, position) results in an exception.
    /// </summary>
    @Test
    public void addBeforeByElement_when_element_is_null_throws_exception_Test()
    {
        Employee employee = new Employee(1);
        Employee addEmployee = new Employee(2);

        LinkedList<Employee> list = new LinkedList<Employee>();
        list.addFirst(employee);

        assertThrows(NullPointerException.class, () -> list.addBefore(addEmployee, null));
    }

    /// <summary>
    /// Checking edge case; Ensure that passing the head element will prepend to the beginning of the list without error.
    /// </summary>
    @Test
    public void addBeforeByElement_using_head_element_on_existingList_updates_head_Test() throws Exception {
        Employee employee1 = new Employee(1);
        Employee employee2 = new Employee(2);
        Employee employee3 = new Employee(3);

        LinkedList<Employee> list = new LinkedList<Employee>();

        list.addFirst(employee3);
        Node<Employee> third = list.getHead();

        list.addFirst(employee1);
        Node<Employee> second = list.getHead();

        list.addBefore(employee3, list.getHead().getElement()); // 1, 2, 3... should add to head, before 2

        Node<Employee> first = list.getHead();

        assertEquals(list.get(1), first.getElement());
        assertEquals(list.get(2), second.getElement());
        assertEquals(list.get(3), third.getElement());

        assertTrue(CheckIntegrityBetweenListOfThreeNodes(list.getHead(), first, second, third, list.getTail(), list.getSize()));
    }

    /// <summary>
    /// Make sure element is inserted into proper position.
    /// </summary>
    @Test
    public void addBeforeByElement_using_tail_element_on_existing_list_inserts_between_nodes_Test() throws Exception {
        Employee employee1 = new Employee(1);
        Employee employee2 = new Employee(2);
        Employee employee3 = new Employee(3);

        LinkedList<Employee> list = new LinkedList<Employee>();

        list.addFirst(employee3);
        Node<Employee> third = list.getHead();

        list.addFirst(employee2);
        Node<Employee> second = list.getHead();

        list.addBefore(employee1, list.getHead().getElement()); // 1, 2, 3, will add 1 before 2

        Node<Employee> first = list.getHead();

        assertEquals(list.get(1), first.getElement());
        assertEquals(list.get(2), second.getElement());
        assertEquals(list.get(3), third.getElement());

        assertTrue(CheckIntegrityBetweenListOfThreeNodes(list.getHead(), first, second, third, list.getTail(), list.getSize()));

    }
    /// <summary>
    /// Ensure that passing a element that appears multiple times in the list to addBefore(element, oldElement) element is before the first instance.
    /// </summary>
    @Test
    public void addBeforeByElement_multiple_match_found_adds_before_first_instance_Test() throws Exception {
        Employee employee = new Employee(1);
        Employee employee2 = new Employee(2);
        Employee addEmployee = new Employee(3);

        LinkedList<Employee> list = new LinkedList<Employee>();
        list.addFirst(employee);
        Node<Employee> fourth = list.getHead();

        list.addFirst(employee2);
        Node<Employee> third = list.getHead();

        list.addFirst(employee); // order will be: 1, 2, 1
        Node<Employee> second = list.getHead();

        list.addBefore(addEmployee, employee); // order should be: 3, 1, 2, 1
        Node<Employee> first = list.getHead();

        assertEquals(list.get(1), first.getElement());
        assertEquals(list.get(2), second.getElement());
        assertEquals(list.get(3), third.getElement());
        assertEquals(list.get(4), fourth.getElement());

        assertTrue(CheckIntegrityBetweenListOfFourNodes(list.getHead(), first, second, third, fourth, list.getTail(), list.getSize()));
    }
        //endregion

        //region remove(element)
    /// <summary>
    /// Make sure that calling remove(element) on an empty list results in an exception.
    /// </summary>
    @Test
    public void RemoveByElement_On_EmptyList_throws_exception_Test()
    {
        Employee employee = new Employee(1);

        LinkedList<Employee> list = new LinkedList<Employee>();

        assertThrows(NoSuchElementException.class, () -> list.remove(employee));
    }

    /// <summary>
    /// Ensure that calling remove(element) with element that is not in the list results in an exception.
    /// </summary>
    @Test
    public void RemoveByElement_Not_In_List_throws_exception_Test()
    {
        Employee employee = new Employee(1);
        Employee missingEmployee = new Employee(2);

        LinkedList<Employee> list = new LinkedList<Employee>();
        list.addFirst(employee);

        assertThrows(NoSuchElementException.class, () -> list.remove(missingEmployee));
    }

    /// <summary>
    /// Test remove(element) on list of one, removes the first node, reduces size and adjusts head/tail.
    /// </summary>
    @Test
    public void RemoveByElement_on_list_of_1_decreases_size_sets_nulls_head_and_tail_Test() throws Exception {
        Employee employee1 = new Employee(1);
        LinkedList<Employee> list = new LinkedList<Employee>();
        list.addFirst(employee1);
        list.remove(employee1);
        assertEquals(list.getSize(), 0);
        assertNull(list.getHead());
        assertNull(list.getTail());
    }


    /// <summary>
    /// RemoveByElementn_list_of_size_2_updates_tail_when_size_1_Test
    /// </summary>
    @Test
    public void RemoveByElement_list_of_size_2_updates_tail_when_size_1_Test() throws Exception {
        Employee employee1 = new Employee(1);
        Employee employee2 = new Employee(2);

        LinkedList<Employee> list = new LinkedList<Employee>();

        list.addFirst(employee2);
        Node<Employee> second = list.getHead();

        list.addFirst(employee1);
        Node<Employee> first = list.getHead();

        var returnedElement = list.remove(list.getTail().getElement()); // removes employee 2

        assertEquals(returnedElement, employee2);

        assertEquals(list.get(1), first.getElement());

        // check employee 1 is the only one left and is the head and tail, with a list size of 1
        assertTrue(CheckIntegrityBetweenListOfOneNode(list.getHead(), first, list.getTail(), list.getSize()));
    }


    /// <summary>
    /// RemoveByPosition_last_position_on_list_of_size_3_updates_tail_Test
    /// </summary>
    @Test
    public void RemoveByElement_tail_on_list_of_size_3_updates_tail_Test() throws Exception {
        Employee employee1 = new Employee(1);
        Employee employee2 = new Employee(2);
        Employee employee3 = new Employee(3);

        LinkedList<Employee> list = new LinkedList<Employee>();

        list.addFirst(employee3);
        Node<Employee> last = list.getHead();

        list.addFirst(employee2);
        Node<Employee> second = list.getHead();

        list.addFirst(employee1);
        Node<Employee> first = list.getHead();

        var returnedElement = list.remove(list.getTail().getElement()); // removes employee 3

        assertEquals(returnedElement, employee3);

        // check employee 1 is the head amd employee2 is the tail, with a list size of 2
        assertTrue(CheckIntegrityBetweenListOfTwoNodes(list.getHead(), first, second, list.getTail(), list.getSize()));
    }

    /// <summary>
    /// Ensure that remove() removes the element at the correct position.
    /// </summary>
    @Test
    public void RemoveByElement_middle_in_list_of_size_3_updates_pointers_Test() throws Exception {
        Employee employee1 = new Employee(1);
        Employee employee2 = new Employee(2);
        Employee employee3 = new Employee(3);

        LinkedList<Employee> list = new LinkedList<Employee>();

        list.addFirst(employee3);
        Node<Employee> last = list.getHead();

        list.addFirst(employee2);
        Node<Employee> second = list.getHead();

        list.addFirst(employee1);
        Node<Employee> first = list.getHead(); // order: 1, 2, 3

        var returnedElement = list.remove(list.get(2)); // removes employee2

        assertEquals(returnedElement, employee2);

        // check employee1 is the head amd employee3 is the tail, with a list size of 2
        assertTrue(CheckIntegrityBetweenListOfTwoNodes(list.getHead(), first, last, list.getTail(), list.getSize()));
    }


    /// <summary>
    /// Test remove(Element) properly updated the head when removing from head
    /// </summary>
    @Test
    public void RemoveByElement_Head_Updated_Test() throws Exception {
        Employee employee1 = new Employee(1);
        Employee employee2 = new Employee(2);
        Employee employee3 = new Employee(3);

        LinkedList<Employee> list = new LinkedList<Employee>();

        list.addFirst(employee3);
        Node<Employee> last = list.getHead();

        list.addFirst(employee2);
        Node<Employee> second = list.getHead();

        list.addFirst(employee1);
        Node<Employee> first = list.getHead(); //order: 1,2,3

        var returnedElement = list.remove(list.getHead().getElement()); // removes employee 1

        assertEquals(returnedElement, employee1);

        // check employee2 is the head amd employee3 is the tail, with a list size of 2
        assertTrue(CheckIntegrityBetweenListOfTwoNodes(list.getHead(), second, last, list.getTail(), list.getSize()));
    }

    /// <summary>
    /// Ensure that calling remove(element) with element that matches multiple list elements returns only one result.
    /// </summary>
    @Test
    public void RemoveByElement_multiple_matches_removes_first_match_test() throws Exception {
        Employee employee1 = new Employee(1);
        Employee employee2 = new Employee(2);

        LinkedList<Employee> list = new LinkedList<Employee>();

        list.addFirst(employee1);
        Node<Employee> last = list.getHead();

        list.addFirst(employee2);
        Node<Employee> second = list.getHead();

        list.addFirst(employee1);
        Node<Employee> first = list.getHead();  // order is: 1, 2, 1

        var returnedElement = list.remove(employee1); // removes first employee 1

        assertEquals(returnedElement, employee1);

        // check employee2 is the head amd employee1 is the tail, with a list size of 2
        assertTrue(CheckIntegrityBetweenListOfTwoNodes(list.getHead(), second, last, list.getTail(), list.getSize()));
    }
        //endregion

        //region Set(element, oldElement)
    /// <summary>
    /// Ensure that calling Set(element, oldElement) on an empty list will result in an exception.
    /// </summary>
    @Test
    public void SetByElement_on_EmptyList_throws_Exception_test()
    {
        Employee employee = new Employee(1);

        LinkedList<Employee> list = new LinkedList<Employee>();

        assertThrows(NoSuchElementException.class, () -> list.set(employee, employee));
    }

    /// <summary>
    /// Ensure that passing element that is not in the list to Set(element, oldElement) results in an exception.
    /// </summary>
    @Test
    public void SetByElement_no_match_throws_exception_Test()
    {
        Employee employee = new Employee(1);
        Employee updatedEmployee = new Employee(2);
        Employee nonListEmployee = new Employee(3);

        LinkedList<Employee> list = new LinkedList<Employee>();
        list.addFirst(employee);

        assertThrows(NoSuchElementException.class, () -> list.set(updatedEmployee, nonListEmployee));
    }

    /// <summary>
    /// Ensure that passing null value to Set(element, oldElement) results in an exception.
    /// </summary>
    @Test
    public void SetByElement_Null_element_throws_exception_Test()
    {
        Employee employee = new Employee(1);
        Employee updatedEmployee = new Employee(2);

        LinkedList<Employee> list = new LinkedList<Employee>();
        list.addFirst(employee);

        assertThrows(NullPointerException.class, () -> list.set(updatedEmployee, null));
    }

    /// <summary>
    /// Test Set(element, oldElement) updates first element on list of one.
    /// </summary>
    @Test
    public void SetByElement_updates_element_returns_old_value_maintains_pointers_change_Test() throws Exception {
        Employee employee1 = new Employee(1);
        Employee employee2 = new Employee(2);

        LinkedList<Employee> list = new LinkedList<Employee>();

        list.addFirst(employee1);
        Node<Employee> first = list.getHead();

        var returnedElement = list.set(employee2,employee1); // set first to employee 2

        assertEquals(returnedElement, employee1);

        assertEquals(list.get(1), first.getElement());

        // check employee2 is the head amd employee2 is the tail, with a list size of 1
        assertTrue(CheckIntegrityBetweenListOfOneNode(list.getHead(), first, list.getTail(), list.getSize()));
    }

    /// <summary>
    /// Ensure that passing a element that appears multiple times in the list to Set(element, oldElement) only first instance is replaced.
    /// </summary>
    @Test
    public void SetByElement_Multiple_Matching_changes_first_instance_only_Test() throws Exception {
        Employee employee1 = new Employee(1);
        Employee employee2 = new Employee(2);
        Employee employee3 = new Employee(3);

        LinkedList<Employee> list = new LinkedList<Employee>();

        list.addFirst(employee1);
        Node<Employee> third = list.getHead();

        list.addFirst(employee2);
        Node<Employee> second = list.getHead();

        list.addFirst(employee1);
        Node<Employee> first = list.getHead();  // order is: 1, 2, 1

        var returnedElement = list.set(employee3, employee1); // sets head to employee3

        assertEquals(list.get(1), first.getElement());
        assertEquals(list.get(2), second.getElement());
        assertEquals(list.get(3), third.getElement());

        assertEquals(returnedElement, employee1);

        // check employee3 is the head amd employee1 is the tail, with a list size of 2
        assertTrue(CheckIntegrityBetweenListOfThreeNodes(list.getHead(),first, second, third, list.getTail(), list.getSize()));
    }
        //endregion


        //region insert()
    /// <summary>
    /// Test that insert() can insert into an empty list and update the head/tail
    /// </summary>
    @Test
    public void Insert_EmptyList_increases_size_updates_head_and_tail_Test() throws Exception {
        Employee employee1 = new Employee(1);
        LinkedList<Employee> list = new LinkedList<Employee>();

        assertEquals(list.getSize(), 0);

        list.insert(employee1);
        Node<Employee> first = list.getHead();  // order is: 1

        assertEquals(list.get(1), first.getElement());

        // check employee1 is the head amd employee1 is the tail, with a list size of 1
        assertTrue(CheckIntegrityBetweenListOfOneNode(list.getHead(), first, list.getTail(), list.getSize()));
    }

    /// <summary>
    /// Test that insert() adds an element to the list in ascending order spot
    /// </summary>
    @Test
    public void Insert_Adds_inbetween_head_and_tail_when_value_between_Test() throws Exception {
        Employee employee1 = new Employee(1);
        Employee employee2 = new Employee(2);
        Employee employee3 = new Employee(3);

        LinkedList<Employee> list = new LinkedList<Employee>();

        list.addFirst(employee3);
        Node<Employee> third = list.getHead();

        list.addFirst(employee1);
        Node<Employee> first = list.getHead();  // order is: 1, 3

        list.insert(employee2);
        Node<Employee> second = list.getHead().getNext();  // order is: 1,2,3

        assertEquals(list.get(1), first.getElement());
        assertEquals(list.get(2), second.getElement());
        assertEquals(list.get(3), third.getElement());

        // check employee3 is the head amd employee1 is the tail, with a list size of 3
        assertTrue(CheckIntegrityBetweenListOfThreeNodes(list.getHead(), first, second, third, list.getTail(), list.getSize()));
    }

    /// <summary>
    /// Edge case; check that insert() will insert into the head position without error.
    /// </summary>
    @Test
    public void Insert_at_Head_Position_when_smallest_list_value_Test() throws Exception {

        Employee employee1 = new Employee(1);
        Employee employee2 = new Employee(2);
        Employee employee3 = new Employee(3);

        LinkedList<Employee> list = new LinkedList<Employee>();

        list.addFirst(employee3);
        Node<Employee> third = list.getHead();

        list.addFirst(employee2);
        Node<Employee> second = list.getHead();  // order is: 2, 3

        list.insert(employee1);
        Node<Employee> first = list.getHead();  // order is: 1,2,3

        assertEquals(list.get(1), first.getElement());
        assertEquals(list.get(2), second.getElement());
        assertEquals(list.get(3), third.getElement());

        // check employee1 is the head amd employee3 is the tail, with a list size of 3
        assertTrue(CheckIntegrityBetweenListOfThreeNodes(list.getHead(), first, second, third, list.getTail(), list.getSize()));
    }

    /// <summary>
    /// Edge case; check that insert() will insert into the tail position without error.
    /// </summary>
    @Test
    public void InsertTailPositionTest() throws Exception {
        Employee employee1 = new Employee(1);
        Employee employee2 = new Employee(2);
        Employee employee3 = new Employee(3);

        LinkedList<Employee> list = new LinkedList<Employee>();

        list.addFirst(employee2);
        Node<Employee> second = list.getHead();

        list.addFirst(employee1);
        Node<Employee> first = list.getHead();   // order is: 1, 2

        list.insert(employee3);
        Node<Employee> third = list.getTail();// order is: 1,2,3

        assertEquals(list.get(1), first.getElement());
        assertEquals(list.get(2), second.getElement());
        assertEquals(list.get(3), third.getElement());

        // check employee1 is the head amd employee3 is the tail, with a list size of 3
        assertTrue(CheckIntegrityBetweenListOfThreeNodes(list.getHead(), first, second, third, list.getTail(), list.getSize()));
    }

    /// <summary>
    /// Test that insert() can handle inserting when duplicates exist in the list already.
    /// </summary>
    @Test
    public void Insert_duplicate_values_in_list_still_maintain_order_test() throws Exception {
        Employee employee1 = new Employee(1);
        Employee employee2 = new Employee(2);
        Employee employee3 = new Employee(3);

        LinkedList<Employee> list = new LinkedList<Employee>();

        list.addFirst(employee3);
        Node<Employee> fourth = list.getHead();

        list.addFirst(employee3);
        Node<Employee> third = list.getHead();

        list.addFirst(employee1);
        Node<Employee> first = list.getHead();   // order is: 1, 3, 3

        list.insert(employee2);
        Node<Employee> second = list.getHead().getNext();   // order is: 1, 2, 3, 3

        assertEquals(list.get(1), first.getElement());
        assertEquals(list.get(2), second.getElement());
        assertEquals(list.get(3), third.getElement());
        assertEquals(list.get(4), fourth.getElement());

        // check employee1 is the head amd employee3 is the tail, with a list size of 4
        assertTrue(CheckIntegrityBetweenListOfFourNodes(list.getHead(), first, second, third, fourth, list.getTail(), list.getSize()));
    }

    /// <summary>
    /// Test that insert() can handle inserting when value to add exists in the list already.
    /// </summary>
    @Test
    public void Insert_new_value_exists_in_list_adds_in_order_test() throws Exception {
        Employee employee1 = new Employee(1);
        Employee employee2 = new Employee(2);
        Employee employee3 = new Employee(3);

        LinkedList<Employee> list = new LinkedList<Employee>();

        list.addFirst(employee3);
        Node<Employee> fourth = list.getHead();

        list.addFirst(employee2);
        Node<Employee> third = list.getHead();

        list.addFirst(employee1);
        Node<Employee> first = list.getHead();   // order is: 1, 2, 3

        list.insert(employee2);
        Node<Employee> second = list.getHead().getNext();   // order is: 1, 2, 2, 3,

        assertEquals(list.get(1), first.getElement());
        assertEquals(list.get(2), second.getElement());
        assertEquals(list.get(3), third.getElement());
        assertEquals(list.get(4), fourth.getElement());

        // check employee1 is the head amd employee3 is the tail, with a list size of 4
        assertTrue(CheckIntegrityBetweenListOfFourNodes(list.getHead(), first, second, third, fourth, list.getTail(), list.getSize()));
    }

    /// <summary>
    ///Test that insert() can handle inserting when list is not ordered
    /// </summary>
    @Test
    public void Insert_new_value_in_non_ordered_list_assigns_in_natural_order_test() throws Exception {
        Employee employee1 = new Employee(1);
        Employee employee2 = new Employee(2);
        Employee employee3 = new Employee(3);

        LinkedList<Employee> list = new LinkedList<Employee>();

        list.addFirst(employee1);
        Node<Employee> fourth = list.getHead();

        list.addFirst(employee3);
        Node<Employee> third = list.getHead();

        list.addFirst(employee1);
        Node<Employee> first = list.getHead();   // order is: 1, 3, 1

        list.insert(employee2);
        Node<Employee> second = list.getHead().getNext();   // order is: 1, 2, 3, 1

        assertEquals(list.get(1), first.getElement());
        assertEquals(list.get(2), second.getElement());
        assertEquals(list.get(3), third.getElement());
        assertEquals(list.get(4), fourth.getElement());

        // check employee1 is the head amd employee1 is the tail, with a list size of 4
        assertTrue(CheckIntegrityBetweenListOfFourNodes(list.getHead(), first, second, third, fourth, list.getTail(), list.getSize()));
    }

    /// <summary>
    ///Test that insert() can handle inserting when list is not ordered, largest number is first
    /// </summary>
    @Test
    public void Insert_new_value_in_non_ordered_list_assigns_in_natural_order_largest_number_is_first_test() throws Exception {
        Employee employee1 = new Employee(1);
        Employee employee2 = new Employee(2);
        Employee employee3 = new Employee(3);

        LinkedList<Employee> list = new LinkedList<Employee>();

        list.addFirst(employee1);
        Node<Employee> third = list.getHead();

        list.addFirst(employee3);
        Node<Employee> second = list.getHead();   // order is: 3, 1

        list.insert(employee2);
        Node<Employee> first = list.getHead();   // order is: 2, 3, 1

        assertEquals(list.get(1), first.getElement());
        assertEquals(list.get(2), second.getElement());
        assertEquals(list.get(3), third.getElement());

        // check employee1 is the head amd employee1 is the tail, with a list size of 4
        assertTrue(CheckIntegrityBetweenListOfThreeNodes(list.getHead(), first, second, third, list.getTail(), list.getSize()));
    }
        //endregion


        //region sortAscending()
    /// <summary>
    /// We run sortAscending() on an empty list, no exceptions should be thrown.
    /// </summary>
    @Test
    public void SortAscending_on_EmptyList_does_not_throw_exception_test()
    {
        LinkedList<Employee> list = new LinkedList<Employee>();
        list.sortAscending();
        assertTrue(list.isEmpty());
        assertNull(list.getHead());
        assertNull(list.getTail());
    }

    /// <summary>
    /// We run sortAscending() on a list of 1, no changes should be made.
    /// </summary>
    @Test
    public void SortAscending_on_list_of_1_does_not_change_anything_test() throws Exception {
        Employee employee1 = new Employee(1);
        LinkedList<Employee> list = new LinkedList<Employee>();
        list.insert(employee1);
        list.sortAscending();
        assertEquals(list.getFirst(), employee1);

        Node<Employee> first = list.getHead();
        assertTrue(CheckIntegrityBetweenListOfOneNode(list.getHead(), first, list.getTail(), list.getSize()));
    }

    /// <summary>
    /// We run sortAscending() on a sorted list of 2, no changes should be made.
    /// </summary>
    @Test
    public void SortAscending_on_sorted_list_of_2_does_not_change_anything_test() throws Exception {
        Employee employee1 = new Employee(1);
        Employee employee2 = new Employee(2);

        LinkedList<Employee> list = new LinkedList<Employee>();

        list.insert(employee1);
        list.insert(employee2);
        list.sortAscending();

        assertEquals(list.getFirst(), employee1);
        assertEquals(list.getLast(), employee2);

        Node<Employee> first = list.getHead();
        Node<Employee> second = list.getHead().getNext();

        assertTrue(CheckIntegrityBetweenListOfTwoNodes(list.getHead(), first, second, list.getTail(), list.getSize()));
    }

    /// <summary>
    /// We run sortAscending() on a sorted list of 3, no changes should be made.
    /// </summary>
    @Test
    public void SortAscending_on_sorted_list_of_3_does_not_change_anything_test() throws Exception {
        Employee employee1 = new Employee(1);
        Employee employee2 = new Employee(2);
        Employee employee3 = new Employee(3);

        LinkedList<Employee> list = new LinkedList<Employee>();

        list.insert(employee1);
        list.insert(employee2);
        list.insert(employee3);

        list.sortAscending();

        assertEquals(list.getFirst(), employee1);
        assertEquals(list.get(2), employee2);
        assertEquals(list.getLast(), employee3);

        Node<Employee> first = list.getHead();
        Node<Employee> second = list.getHead().getNext();
        Node<Employee> third = list.getTail();

        assertTrue(CheckIntegrityBetweenListOfThreeNodes(list.getHead(), first, second, third, list.getTail(), list.getSize()));
    }

    /// <summary>
    /// We run sortAscending() on an unsorted list of 2, should sort the values
    /// </summary>
    @Test
    public void SortAscending_on_unsorted_list_of_2_sorts_ascending_test() throws Exception {
        Employee employee1 = new Employee(1);
        Employee employee2 = new Employee(2);

        LinkedList<Employee> list = new LinkedList<Employee>();

        list.addLast(employee1);
        list.addFirst(employee2);

        list.sortAscending();

        assertEquals(list.getFirst(), employee1);
        assertEquals(list.getLast(), employee2);

        Node<Employee> first = list.getHead();
        Node<Employee> second = list.getHead().getNext();

        assertTrue(CheckIntegrityBetweenListOfTwoNodes(list.getHead(), first, second, list.getTail(), list.getSize()));
    }

    /// <summary>
    /// We run sortAscending() on an unsorted list of 3, should sort the values
    /// </summary>
    @Test
    public void SortAscending_on_Unsorted_list_of_3_sorts_ascending_test() throws Exception {
        Employee employee1 = new Employee(1);
        Employee employee2 = new Employee(2);
        Employee employee3 = new Employee(3);

        LinkedList<Employee> list = new LinkedList<Employee>();

        list.addLast(employee1);
        list.addFirst(employee3);
        list.addFirst(employee2);
        list.sortAscending();

        assertEquals(list.getFirst(), employee1);
        assertEquals(list.get(2), employee2);
        assertEquals(list.getLast(), employee3);

        Node<Employee> first = list.getHead();
        Node<Employee> second = list.getHead().getNext();
        Node<Employee> third = list.getTail();

        assertTrue(CheckIntegrityBetweenListOfThreeNodes(list.getHead(), first, second, third, list.getTail(), list.getSize()));

    }

    /// <summary>
    /// We run sortAscending() on a large unsorted list with duplicates, should sort the values
    /// </summary>
    @Test
    public void SortAscending_on_large_Unsorted_list_with_duplicates_sorts_ascending_test() throws Exception {

        Employee employee1 = new Employee(1);
        Employee employee2 = new Employee(2);
        Employee employee3 = new Employee(3);

        LinkedList<Employee> list = new LinkedList<Employee>();

        list.addLast(employee1);
        list.addFirst(employee3);
        list.addFirst(employee2);
        list.addFirst(employee3);// order was: 3, 2, 3, 1

        list.sortAscending();

        Node<Employee> first = list.getHead();
        Node<Employee> second = list.getHead().getNext();
        Node<Employee> third = list.getTail().getPrevious();
        Node<Employee> fourth = list.getTail();

        assertEquals(list.getFirst(), employee1); // 1, 2, 3, 3
        assertEquals(list.get(2), employee2);
        assertEquals(list.get(3), employee3);
        assertEquals(list.getLast(), employee3);

        assertTrue(CheckIntegrityBetweenListOfFourNodes(list.getHead(), first, second, third, fourth, list.getTail(), list.getSize()));

    }
        //endregion

        //endregion


    /* HELPER METHODS */
    private boolean CheckIntegrityBetweenListOfOneNode(Node<Employee> head, Node<Employee> node1, Node<Employee> tail, int size)
    {
        return head == node1 && node1.getPrevious() == null && node1.getNext() == null && tail == node1 && size == 1;
    }

    private boolean CheckIntegrityBetweenListOfTwoNodes(Node<Employee> head, Node<Employee> node1, Node<Employee> node2, Node<Employee> tail, int size)
    {
        return head == node1 && node1.getPrevious() == null && node1.getNext() == node2 &&
                node2.getPrevious() == node1 && node2.getNext() == null && tail == node2 && size == 2;
    }

    private boolean CheckIntegrityBetweenListOfThreeNodes(Node<Employee> head,
                                                          Node<Employee> node1,
                                                          Node<Employee> node2,
                                                          Node<Employee> node3,
                                                          Node<Employee> tail,
                                                          int size)
    {
        return head == node1 && node1.getPrevious() == null && node1.getNext() == node2 &&
                node2.getPrevious() == node1 && node2.getNext() == node3 &&
                node3.getPrevious() == node2 && node3.getNext() == null && tail == node3 && size == 3;
    }

    private boolean CheckIntegrityBetweenListOfFourNodes(Node<Employee> head, Node<Employee> node1, Node<Employee> node2, Node<Employee> node3, Node<Employee> node4, Node<Employee> tail, int size)
    {
        return head == node1 && node1.getPrevious() == null && node1.getNext() == node2 &&
                node2.getPrevious() == node1 && node2.getNext() == node3 &&
                node3.getPrevious() == node2 && node3.getNext() == node4 &&
                node4.getPrevious() == node3 && node4.getNext() == null && tail == node4 && size == 4;
    }
}
