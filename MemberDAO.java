package com.example.demo;


import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;

import java.lang.reflect.Member;


@Repository
public class MemberDAO {

    @Autowired
    private SqlSession sqlSession;

    public Member loginMember(String memberId, String memberPwd) {
        Member member = new Member() {
            @Override
            public Class<?> getDeclaringClass() {
                return null;
            }

            @Override
            public String getName() {
                return null;
            }

            @Override
            public int getModifiers() {
                return 0;
            }

            @Override
            public boolean isSynthetic() {
                return false;
            }
        };
        member.setMemberId(memberId);
        member.setMemberPwd(memberPwd);

        return sqlSession.selectOne("MemberMapper.loginMember", member);
    }
}
