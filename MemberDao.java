package EX1;

import java.util.*;

public class MemberDao {
    private Map<Integer, MemberVo> db = new HashMap<>();

    //allSelect
    public List<MemberVo> memberAllSelect(){
        return new ArrayList<>(db.values());
    }

    //select
    public MemberVo memberSelect(int no){
        return db.get(no);
    }

    //insert
    public void memberInsert(MemberVo vo){
        vo.setRegdate(new Date());
        db.put(vo.getNo(),vo);
    }

    //update
    public void memberUpdate(MemberVo vo){
        db.put(vo.getNo(), vo);
    }

    //delete
    public void memberDelete(int no){
        db.remove(no);
    }

}
