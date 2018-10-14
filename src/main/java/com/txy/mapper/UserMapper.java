package com.txy.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.txy.entity.Roll;
import com.txy.entity.User;
import com.txy.entity.Ztree;

public interface UserMapper {

	@Select("select * from a_user")
	List<User> findUserAll();

	List<Roll> findRollList(Roll roll);

	@Select("select * from a_user where username=#{username}")
	User findUserOneByUsername(@Param("username")String username);
	
	@Select("select * from a_sess")
	List<Roll> findSessList();

	@Select("select * from a_sess where sname = #{sname}")
	Roll findSessOneBySname(Roll roll);

	@Select("select * from a_roll where stuname = #{stuname} and sname = #{sname} and cname = #{cname}")
	Roll findRollByStuName(Roll roll);

	@Insert("insert into a_roll set sname = #{sname}, cname = #{cname}, rnum = #{rnum}, stuname = #{stuname}, stuborn = #{stuborn}, stusex = #{stusex}, states = #{states}, stunation = #{stunation}, stuphone = #{stuphone}, rdate = #{rdate}, deid = 0")                      
	void add(Roll roll);

	@Select("select * from a_roll where sname = #{sname}")
	List<Roll> findSessListBySname(Roll roll);

	@Insert("insert into a_sess set sname=#{sname},cname=#{cname}")
	void addSess(Roll roll);

	@Select("select * from a_roll where rid = #{rid}")
	Roll findRollBySid(Integer rid);

	@Update("update a_roll set sname = #{sname}, cname = #{cname}, rnum = #{rnum}, stuname = #{stuname}, stuborn = #{stuborn}, stusex = #{stusex}, states = #{states}, stunation = #{stunation}, stuphone = #{stuphone}, rdate = #{rdate} where rid = #{rid}")
	void update(Roll roll);

	@Update("update a_roll set deid = 1 where rid = #{rid}")
	void del(Integer rid);

	@Select("select * from a_roll")
	List<Roll> findRollAll();

	@Select("select * from a_ztree")
	List<Ztree> findZtreeAll();

}
