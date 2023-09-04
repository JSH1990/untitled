package manager;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import oracle.jdbc.driver.DBConversion;

public class Main2 {
	public static void main(String[] args) {
		MemberDao memberDao = new MemberDao();
		
		List<MemberVo> ls = memberDao.selectMemberAll();
		
		MemberVo vo1 = new MemberVo(1, "test1", "1234", "nick1");
		vo1.setRegdate(new Date());

		MemberVo vo2 = new MemberVo(2, "test2", "1234", "nick2");
		vo2.setRegdate(new Date());
		
		MemberVo vo3 = new MemberVo(3, "test3", "1234", "nick3");
		vo3.setRegdate(new Date());
		
		memberDao.insertMember(vo1);
		memberDao.insertMember(vo2);
		memberDao.insertMember(vo3);
		System.out.println("저장완료");
		

		
		MemberVo vo = null;
		vo = memberDao.selectMember(1);
		System.out.println(vo);
		
		vo = memberDao.selectMember(4);
		System.out.println(vo);
		
		vo = memberDao.selectMember(1);
		System.out.println(vo);
		
		if(vo != null) {
			vo.setMemberPw("4321");
			vo.setMemberId("1nick");
			memberDao.updateMember(vo);
			System.out.println(vo);
			System.out.println("수정완료!");
		}
		
		memberDao.deleteMember(1);
		ls = memberDao.selectMemberAll();
		for(MemberVo tmp : ls) {
			System.out.println(tmp);
		}
		System.out.println("삭제 완료 완료");
	}
}
