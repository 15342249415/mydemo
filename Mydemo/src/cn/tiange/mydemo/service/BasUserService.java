package cn.tiange.mydemo.service;

import cn.tiange.mydemo.pojo.BasUser;

public interface BasUserService {

	BasUser getUserByMobile(String mobile);

	void modifyMobile(String mobile, Integer userId);

}
