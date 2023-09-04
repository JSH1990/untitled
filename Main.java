package manager;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import oracle.jdbc.driver.DBConversion;

public class Main {
	public static void main(String[] args) {
		Map<Integer, MemberVo> db = new HashMap<>();
		
		MemberVo vo1 = new MemberVo(1, "test1", "1234", "nick1");
		vo1.setRegdate(new Date());

		MemberVo vo2 = new MemberVo(2, "test2", "1234", "nick2");
		vo2.setRegdate(new Date());
		
		MemberVo vo3 = new MemberVo(3, "test3", "1234", "nick3");
		vo3.setRegdate(new Date());
		
		db.put(1, vo1);
		db.put(2, vo2);
		db.put(3, vo3);
		System.out.println("저장완료");
		

		
		MemberVo vo = null;
		vo = db.get(1);
		System.out.println(vo);
		
		vo = db.get(4);
		System.out.println(vo);
		
		vo = db.get(1);
		System.out.println(vo);
		
		if(vo != null) {
			vo.setMemberPw("4321");
			vo.setMemberId("1nick");
			db.put(vo.getNum(), vo);
			System.out.println(vo);
			System.out.println("수정완료!");
		}
		
		db.remove(1);
		List<MemberVo> ls = new ArrayList<>(db.values());
		for(MemberVo tmp : ls) {
			System.out.println(tmp);
		}
		System.out.println("삭제 완료 완료");
	}
}
