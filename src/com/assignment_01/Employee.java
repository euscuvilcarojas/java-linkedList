package com.assignment_01;

public class Employee implements Comparable<Employee>{
    private int employeeID;
    private String firstName;
    private String lastName;

    //Constructor
    public Employee(int employeeId){
        setEmployeeID(employeeId);
        setFirstName(null);
        setLastName(null);
    }
    // Constructor 02
    public Employee(int employeeId, String firstName, String lastName){
        setEmployeeID(employeeId);
        setFirstName(firstName);
        setLastName(lastName);
    }

    //Methods
    @Override
    public int compareTo(Employee o) {
        //return (this.employeeID < o.employeeID) ? -1 : ((this.employeeID == o.employeeID) ? 0 : 1);
        return Integer.compare(this.employeeID, o.employeeID);
    }

    @Override
    public String toString(){
        return String.format("%d %s %s", this.employeeID, this.firstName, this.lastName);
    }

    //Getter - Setters
    public int getEmployeeID() {
        return employeeID;
    }

    private void setEmployeeID(int employeeID) {
        this.employeeID = employeeID;
    }

    public String getFirstName() {
        return firstName;
    }

    private void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    private void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
