package examsurvey;

public class FoodTypeVo {
    private int no;
    private String typename;
    private int vote;

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getTypename() {
        return typename;
    }

    public void setTypename(String typename) {
        this.typename = typename;
    }

    public int getVote() {
        return vote;
    }

    public void setVote(int vote) {
        this.vote = vote;
    }

    public FoodTypeVo(int no, String typename, int vote) {
        this.no = no;
        this.typename = typename;
        this.vote = vote;
    }

    @Override
    public String toString() {
        return "FoodTypeVo{" +
                "no=" + no +
                ", typename='" + typename + '\'' +
                ", vote=" + vote +
                '}';
    }
}
