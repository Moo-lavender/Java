public class User {
    private String remark;
    private String phoneNumber;

    public User(String remark, String phoneNumber) {
        this.remark = remark;
        this.phoneNumber = phoneNumber;
    }

    public void changeRemark(String newRemark){
        this.remark = newRemark;
    }

    public void changePhoneNumber(String newPhoneNumber) {
        this.phoneNumber = newPhoneNumber;
    }
    public String getRemark(){
        return remark;
    }

    public String getPhoneNumber(){
        return phoneNumber;
    }
}
