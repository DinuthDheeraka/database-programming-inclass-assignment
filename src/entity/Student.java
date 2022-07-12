/**
 * @author :  Dinuth Dheeraka
 * Project :  Database-Programming
 * Created : 7/12/2022 10:39 AM
 */
package entity;

public class Student {

    private String studentId;
    private String name;
    private String email;
    private String contact;
    private String address;
    private String nic;

    public Student() {
    }

    public Student(String studentId, String name, String email, String contact, String address, String nic) {
        this.studentId = studentId;
        this.name = name;
        this.email = email;
        this.contact = contact;
        this.address = address;
        this.nic = nic;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setNic(String nic) {
        this.nic = nic;
    }

    public String getStudentId() {
        return studentId;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getContact() {
        return contact;
    }

    public String getAddress() {
        return address;
    }

    public String getNic() {
        return nic;
    }
}
