public class AnotherPerson {

    private String firstName;
    @XmlName("Отчество")
    private String parentName;
    @XmlName("Фамилия")
    private String secondName;

    protected int age;

    @XmlIgnore
    public boolean hasFamily;

    public AnotherPerson() {
        this("Иван","Иваныч","Иванов", age:27, false);
    }

    public AnotherPerson(String firstName, String parentName, String secondName, int age, boolean hasFamily) {
        this.firstName = firstName;
        this.parentName = parentName;
        this.secondName = secondName;
        this.age = age;
        this.hasFamily = hasFamily;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getParentName() {
        return parentName;
    }

    public void setParentName(String parentName) {
        this.parentName = parentName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isHasFamily() {
        return hasFamily;
    }

    public void setHasFamily(boolean hasFamily) {
        this.hasFamily = hasFamily;
    }

    @Override
    public String toString() {
        return "AnotherPerson{" +
                "firstName='" + firstName + '\'' +
                ", parentName='" + parentName + '\'' +
                ", secondName='" + secondName + '\'' +
                ", age=" + age +
                ", hasFamily=" + hasFamily +
                '}';
    }
}