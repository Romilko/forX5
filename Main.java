import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Test> target_ = Arrays.asList(new Test(2, "", false), new Test(3, "", false), new Test(4, "", false));
        List<Test> source_ = Arrays.asList(new Test(2, "", true), new Test(3, "ha", false));
        HashMap<Integer,Test>target = (HashMap<Integer, Test>) target_.stream().collect(Collectors.toMap(Test::getAge, Function.identity()));
        HashMap<Integer,Test>source = (HashMap<Integer, Test>) source_.stream().collect(Collectors.toMap(Test::getAge, Function.identity()));
        source.forEach((key,value)->{
            if(target.containsKey(key)){
                if(value.deleted)target.remove(key);
                else target.get(key).setName(value.getName());
            }else target.put(key,value);
        });
        target.forEach((key,value)-> System.out.println(value));
    }
}
class Test{
    Integer age;
    String name;

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

    boolean deleted;

    public Test(int age, String name, boolean deleted) {
        this.age = age;
        this.name = name;
        this.deleted = deleted;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Test test = (Test) o;
        return age == test.age;
    }

    @Override
    public int hashCode() {
        return Objects.hash(age);
    }

    @Override
    public String toString() {
        return "Test{" +
                "age=" + age +
                ", name='" + name + '\'' +
                ", deleted=" + deleted +
                '}';
    }
}
