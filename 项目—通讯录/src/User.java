import java.util.*;

public class User {
    private String remark;
    private List<String> phoneNumber;

    public User(String remark, List<String> phoneNumber) {
        this.remark = remark;
        this.phoneNumber = phoneNumber;
    }

    public void changeRemark(String newRemark){
        this.remark = newRemark;
    }

    public void changePhoneNumber(int changeNumber , String newPhoneNumber) {
        phoneNumber.set(changeNumber-1,newPhoneNumber) ;

    }
    public String getRemark(){
        return remark;
    }

    public List<String> getPhoneNumber(){
        return phoneNumber;
    }

    public static boolean input() {
        Address address = new Address();
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入操作：");
        System.out.println("0.退出");
        System.out.println("1.添加联系人");
        System.out.println("2.修改联系人");
        System.out.println("3.删除联系人");
        System.out.println("4.查找联系人");
        int selected = scanner.nextInt();
        scanner.nextLine();
        switch (selected) {
            case 0:
                return false;
            case 1://添加
                System.out.println("输入联系人的姓名：");
                String name = scanner.nextLine();
                System.out.println("输入联系人的备注：");
                String remark = scanner.nextLine();
                List<String> phoneNumber = new ArrayList<>();
                System.out.println("输入联系人的电话 1：");
                String phoneNumber1 = scanner.nextLine();
                phoneNumber.add(phoneNumber1);
                System.out.println("输入联系人的电话 2：");
                String phoneNumber2 = scanner.nextLine();
                if(phoneNumber2 == "%n"){
                    phoneNumber2 = "Null";
                }
                phoneNumber.add(phoneNumber2);
                address.addPeople(name, remark, phoneNumber);
                break;
            case 2://修改
                System.out.println("输入要修改的联系人的姓名：");
                String changeName = scanner.nextLine();

                System.out.println("选择要修改的联系人的信息：");
                System.out.println("1.备注");
                System.out.println("2.电话");
                int select2 = scanner.nextInt();
                scanner.nextLine();
                switch (select2) {
                    case 1:
                        System.out.println("输入新的备注：");
                        String newRemark = scanner.nextLine();
                        address.updataPeopleRemark(changeName, newRemark);
                        break;
                    case 2:
                        System.out.println("选择要修改或添加的电话：");
                        System.out.println("1. 电话一");
                        System.out.println("2. 电话二");
                        int changeNumber = scanner.nextInt();
                        scanner.nextLine();
                        System.out.println("输入新的电话：");
                        String newPhoneNumber = scanner.nextLine();
                        address.updataPeoplePhoneNumber(changeName, changeNumber,newPhoneNumber);
                        break;
                }
                break;
            case 3://删除
                System.out.println("输入要删除的联系人的姓名：");
                String removeName = scanner.nextLine();
                address.removePeople(removeName);
                break;
            case 4://查找
                User user;
                System.out.println("选择查找的方式：");
                System.out.println("1.全查询");
                System.out.println("2.按姓名查询");
                int select4 = scanner.nextInt();
                scanner.nextLine();
                switch (select4) {
                    case 1:
                        Map<String,User> peopleList = new HashMap<>();
                        peopleList = address.qurryPeople();
                        System.out.println(peopleList);
                        break;
                    case 2:
                    System.out.println("输入要查找的联系人的姓名");
                    String getName = scanner.nextLine();
                    user = address.qurryPeople(getName);
                    System.out.printf("姓名：%s  备注：%s  电话：%s %n", getName, user.getRemark(), user.getPhoneNumber());
                    break;
                }
                break;
        }
        return true;
    }

    @Override
    public String toString() {
        return String.format("备注：%s  电话：%s",this.getRemark(),this.getPhoneNumber());
    }
}
