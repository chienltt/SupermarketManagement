package src;

public class employee {
    private  String employeeid;
    private  String employeeusername;
    private String employeepassword;
    private String employeename;
    private  String employeeinfo;

    public employee(String employeeid, String employeeusername, String employeepassword, String employeename, String employeeinfo) {
        this.employeeid = employeeid;
        this.employeeusername = employeeusername;
        this.employeepassword = employeepassword;
        this.employeename = employeename;
        this.employeeinfo = employeeinfo;
    }

    public employee() {
    }

    public String getEmployeeid() {
        return employeeid;
    }

    public void setEmployeeid(String employeeid) {
        this.employeeid = employeeid;
    }

    public String getEmployeeusername() {
        return employeeusername;
    }

    public void setEmployeeusername(String employeeusername) {
        this.employeeusername = employeeusername;
    }

    public String getEmployeepassword() {
        return employeepassword;
    }

    public void setEmployeepassword(String employeepassword) {
        this.employeepassword = employeepassword;
    }

    public String getEmployeename() {
        return employeename;
    }

    public void setEmployeename(String employeename) {
        this.employeename = employeename;
    }

    public String getEmployeeinfo() {
        return employeeinfo;
    }

    public void setEmployeeinfo(String employeeinfo) {
        this.employeeinfo = employeeinfo;
    }
}

