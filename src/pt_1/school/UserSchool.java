package pt_1.school;

public class UserSchool {
    private String name;
    private int age;
    private boolean rol;

    public UserSchool(String name, int age, boolean rol) {
        setName(name);
        setAge(age);
        setRol(rol);
    }
    public String getName() {
        return name;
    }
    public int getAge() {
        return age;
    }
    public boolean getRol() {
        return rol;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setRol(boolean rol) {
        this.rol = rol;
    }

    @Override
    public String toString() {
        return "User " + name + "\n" +
                "Age = " + age + "\n" +
                "Rol = " + (rol? "Profesor":"Alumno");
    }
}
