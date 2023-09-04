package manager;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MemberDao {
	
	private Map<Integer, MemberVo> db = new HashMap<>();
	
	public void insertMember(MemberVo vo) {
		vo.setRegdate(new Date());
		db.put(vo.getNum(),vo);
	}
	
	public MemberVo selectMember(int num) {
		return db.get(num);
	}
	
	public List<MemberVo> selectMemberAll(){
		return new ArrayList<MemberVo>(db.values());
	}
	
	public void updateMember(MemberVo vo) {
		db.put(vo.getNum(), vo);
	}
	
	public void deleteMember(int num) {
		db.remove(num);
	}

}
