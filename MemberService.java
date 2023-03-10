
import java.util.List;

public class MemberService { //DAO�� db�� ������ �������� ������� Ŭ�����̰�, Service�� ����ڰ� ��û�Ѱ� �����̳Ŀ� ����  �ű⿡ ���õ� ó���� ���ؼ� ������� Ŭ����
    private static MemberService instance;
    private MemberDao memberDao;

    public MemberService(MemberDao memberDao) {
        this.memberDao = memberDao;
    }

    public static MemberService getInstance() {
        synchronized (MemberService.class) {
            if (instance == null) {
                instance = new MemberService(MemberDao.getInstance());
            }
        }
        return instance;
    }
    //����ϱ�
    public boolean regist(MemberVo vo) { //����� �������θ� boolean���� ��ȯ�Ѵ�.
        int ret = memberDao.insertMember(vo); //memberDao�� ���ؼ� ȸ�����
        if(ret == 1) { //������ ȸ���� ������
            return true;
        }
        return false;
    }

    //��ȸ
    public MemberVo read(int num) {
        return memberDao.selectMember(num);
    }

    //��ü��ȸ
    public List<MemberVo> listAll(){
        return memberDao.selectMemberAll();
    }

    //����
    public boolean edit(MemberVo vo, String memberPwOld) {
        int result = -1;
        MemberVo searchMember = memberDao.selectMember(vo.getNum());
        if(searchMember.getMemberPw().equals(memberPwOld)) {
            result = memberDao.updateMember(vo);
        }
        return (result == 1) ? true : false;
    }


    //Ż��
    public boolean remove(int num) {
        int ret = memberDao.deleteMember(num);
        return (ret == 1) ? true : false;
    }
}