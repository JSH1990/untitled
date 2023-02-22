package EX1;

import java.util.Date;

public class MemberVo {
    private int no;
    private String id;
    private String password;
    private Date regdate;

    public MemberVo(int no, String id, String password) {
        this.no = no;
        this.id = id;
        this.password = password;
    }
    SELECT * FROM MEMBER;
    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getRegdate() {
        return regdate;
    }

    public void setRegdate(Date regdate) {
        this.regdate = regdate;
    }

    @Override
    public String toString() {
        return "MemberVo{" +
                "no=" + no +
                ", id='" + id + '\'' +
                ", password='" + password + '\'' +
                ", regdate=" + regdate +
                '}';
    }
}
