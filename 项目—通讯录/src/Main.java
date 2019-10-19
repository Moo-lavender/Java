import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Address address = new Address();
        Scanner scanner = new Scanner(System.in);
        boolean quit = false;
        while (!quit){
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
                    quit = true;
                    break;
                case 1://添加
                    System.out.println("输入联系人的姓名：");
                    String name = scanner.nextLine();
                    System.out.println("输入联系人的备注：");
                    String remark = scanner.nextLine();
                    System.out.println("输入联系人的电话：");
                    String phoneNumber = scanner.nextLine();
                    address.addPeople(name, remark, phoneNumber);
                    break;
                case 2://修改
                    System.out.println("输入要修改的联系人的姓名：");
                    String changeName = scanner.nextLine();
                    System.out.println("选择要修改的联系人的信息：");
                    System.out.println("1.备注");
                    System.out.println("2.电话");
                    int select = scanner.nextInt();
                    scanner.nextLine();
                    switch (select) {
                        case 1:
                            System.out.println("输入新的备注：");
                            String newRemark = scanner.nextLine();
                            address.updataPeopleRemark(changeName, newRemark);
                            break;
                        case 2:
                            System.out.println("输入新的电话：");
                            String newPhoneNumber = scanner.nextLine();
                            address.updataPeoplePhoneNumber(changeName, newPhoneNumber);
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
                    System.out.println("输入要查找的联系人的姓名");
                    String getName = scanner.nextLine();
                    user = address.qurryPeople(getName);
                    System.out.printf("姓名：%s  备注：%s  电话：%s %n", getName, user.getRemark(), user.getPhoneNumber());
                    break;
            }
        }
    }
}
