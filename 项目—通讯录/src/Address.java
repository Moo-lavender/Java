import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Address {

    private static Map<String,User> people = new HashMap<>();

    public void addPeople(String name, String remark, List<String> phoneNumber) {
        User user = new User(remark,phoneNumber);
        people.put(name,user);
    }

    public void updataPeopleRemark(String changeName, String newRemark) {
        User changePeople = people.get(changeName);
        changePeople.changeRemark(newRemark);
    }

    public void updataPeoplePhoneNumber(String changeName, int changeNumber, String newPhoneNumber) {
        User changePeople = people.get(changeName);
        changePeople.changePhoneNumber(changeNumber,newPhoneNumber);
    }

    public void removePeople(String removeName) {
        people.remove(removeName);
    }

    public User qurryPeople(String name) {
        User user = people.get(name);
        return user;
    }

    public static Map<String,User> qurryPeople(){
        return people;
    }
}
