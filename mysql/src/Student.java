public class Student {

    private Integer id;    //对于数据库属性，就不能使用基本数据类型，避免创建为0而混淆
    private Integer sn;
    private String name;
    private  String qqMail;
    private Integer classesId;

    public Classes getClasses() {
        return classes;
    }

    public void setClasses(Classes classes) {
        this.classes = classes;
    }

    private Classes classes;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getSn() {
        return sn;
    }

    public void setSn(Integer sn) {
        this.sn = sn;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getQqMail() {
        return qqMail;
    }

    public void setQqMail(String qqMail) {
        this.qqMail = qqMail;
    }

    public Integer getClassesId() {
        return classesId;
    }

    public void setClassesId(Integer classesId) {
        this.classesId = classesId;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", sn=" + sn +
                ", name='" + name + '\'' +
                ", qqMail='" + qqMail + '\'' +
                ", classesId=" + classesId +
                '}';
    }



}
