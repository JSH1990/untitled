package EX1;

import java.util.List;

public class MemberService {
    private MemberDao memberDao;

    public MemberService (MemberDao memberDao){
        this.memberDao = memberDao;
    }

    //등록하기

    public boolean serviceInsert(MemberVo vo){
        if (memberDao.memberSelect(vo.getNo()) == null){
            memberDao.memberInsert(vo);
            return true;
        }return false;
    }

    //전체 조회하기

    public List<MemberVo> serviceAllSelect(){
        return memberDao.memberAllSelect();
    }

    //하나 조회하기
    public MemberVo serviceSelect(int no){
       return memberDao.memberSelect(no);
    }

    //변경하기
    public void serviceUpdate(MemberVo vo){
        MemberVo searchMember = memberDao.memberSelect(vo.getNo());
        if (searchMember.getPassword().equals(vo.getPassword())){
            memberDao.memberUpdate(vo);
        }
        }

    //삭제하기
    public void serviceDelete(int no){
        memberDao.memberDelete(no);
    }


    }





