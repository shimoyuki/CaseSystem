package com.sys.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.sys.entity.Menu;
import com.sys.entity.PoliceMan;
import com.sys.entity.PoliceStation;
import com.sys.entity.User;

@Repository("userDao")
public interface IUserDao {

	/**
	 * 通过用户名和密码获得用户
	 * 
	 * @param user
	 * @return
	 */
	public User getUserById(@Param("userID") int userID);

	/**
	 * 获取用户列表
	 * 
	 * @return
	 */
	public List<User> getUserList();

	/**
	 * 获取用户数量
	 * 
	 * @return
	 */
	public int getUserCount();

	/**
	 * 添加用户
	 * 
	 * @param user
	 */
	public void saveUser(User user);

	/**
	 * 编辑用户
	 * 
	 * @param user
	 */
	public void updateUser(User user);

	/**
	 * 删除用户
	 * 
	 * @param user
	 */
	public void deleteUser(User user);

	/**
	 * 检查是否存在该用户
	 * 
	 * @param user
	 * @return
	 */
	public User getUserByName(User user);

	
	/**
	 * 获取所有的菜单
	 * @return
	 */
	public List<String> getAllMenu();
	/**
	 * 通过用户ID获得警员信息
	 */
	List<PoliceMan> getPoliceInfor(int id);
	/**
	 * 通过用户ID获得派出所信息
	 */
	PoliceStation getPoliceStation(int id);
}
