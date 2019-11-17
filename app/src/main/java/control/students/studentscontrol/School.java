package control.students.studentscontrol;

public class School {
    private String login;
    private String passwd;

    public School(String login, String passwd) {
        this.login = login;
        this.passwd = passwd;
    }

    public String getLogin() {
        return login;
    }

    public String getPasswd() {
        return passwd;
    }
}
