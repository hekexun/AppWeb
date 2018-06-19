package example.pojo;

public class loginPojo {
    String name;
    String password;

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "loginPojo{" +
                "name='" + name + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
