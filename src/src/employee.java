package src;

public class employee {
    private String employeeId;
    private String employeeUserName;
    private String employeePassWord;
    private String employeeName;
    private String employeeInfo;

    public employee(String employeeId,String employeeUserName,String employeePassWord,String employeeName,String employeeInfo)
    {
        this.employeeId=employeeId;
        this.employeeUserName=employeeUserName;
        this.employeePassWord=employeePassWord;
        this.employeeName=employeeName;
        this.employeeInfo=employeeInfo;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public String getEmployeeInfo() {
        return employeeInfo;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public String getEmployeePassWord() {
        return employeePassWord;
    }

    public String getEmployeeUserName() {
        return employeeUserName;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public void setEmployeeInfo(String employeeInfo) {
        this.employeeInfo = employeeInfo;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public void setEmployeePassWord(String employeePassWord) {
        this.employeePassWord = employeePassWord;
    }

    public void setEmployeeUserName(String employeeUserName) {
        this.employeeUserName = employeeUserName;
    }
    
}
