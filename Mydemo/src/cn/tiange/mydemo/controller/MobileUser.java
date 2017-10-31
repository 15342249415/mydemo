package cn.tiange.mydemo.controller;

import java.util.Date;

import cn.tiange.mydemo.pojo.BasUser;
import cn.tiange.mydemo.pojo.SysTempcode;
import cn.tiange.mydemo.service.BasUserService;
import cn.tiange.mydemo.service.SysTempcodeService;
import cn.tiange.mydemo.uitl.Constants;
import cn.tiange.mydemo.uitl.CrowdException;
import cn.tiange.mydemo.uitl.Message;




/**
 * 
 * @author pxh
 * Created by pxh on 17/10/31.
 */




public class MobileUser {
	
	private BasUserService userService;
	
	private SysTempcodeService tempcodeService;
	
	public Object modifyMobile(Integer userId,String mobile,String inputRandomCode,String jsCode,Long validPhoneExpiredTime){
        BasUser user=userService.getUserByMobile(mobile);
        //判断新手机是否存在
        if (null !=user) {
            throw new CrowdException("user.register.mobile_already_exists");
        }
        //判断验证码与手机是否匹配
        SysTempcode tempcode=tempcodeService.getByMobileAndCode(mobile, jsCode);
        if(tempcode==null){
            throw new CrowdException("user.register.randomCode.error");
        }
        if (validPhoneExpiredTime == null){
            throw new CrowdException("user.register.randomCode.timeout");
        }
        //短信校验
        Date now = new Date();
        long between = (now.getTime() - validPhoneExpiredTime) / 1000;

        if (!(jsCode.equals(inputRandomCode))) {
            throw new CrowdException("user.register.randomCode.error");
        }
        if (between > Constants.VALIDATETIME) {
            throw new CrowdException("user.register.randomCode.timeout");
        }
        //修改手机号码
        userService.modifyMobile(mobile, userId);
        return Message.OK;
    }
}
