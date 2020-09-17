package entities;
public class Student {
    String rollno, fullname, email, birthday, address;

    public Student() {
    }

    public Student(String rollno, String fullname, String email, String birthday, String address) {
        this.rollno = rollno;
        this.fullname = fullname;
        this.email = email;
        this.birthday = birthday;
        this.address = address;
    }

    public String getRollno() {
        return rollno;
    }

    public void setRollno(String rollno) {
        this.rollno = rollno;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }


}