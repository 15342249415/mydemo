
package cn.tiange.mydemo.service;

import cn.tiange.mydemo.pojo.SysTempcode;

public interface SysTempcodeService {

	SysTempcode getByMobileAndCode(String mobile, String jsCode);

}
