package 암호체크;

public class PwdCheckClass {
    boolean validLength(String pwd){
        if (pwd.length() >= 10 && pwd.length() <= 30) return true;
        return false;
    }
}
