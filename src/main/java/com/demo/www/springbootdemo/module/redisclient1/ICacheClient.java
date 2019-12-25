package com.demo.www.springbootdemo.module.redisclient1;

import com.demo.www.springbootdemo.module.redisclient1.command.ICacheCoreCommands;
import com.demo.www.springbootdemo.module.redisclient1.command.ICacheExtensionCommands;
import com.demo.www.springbootdemo.module.redisclient1.command.ICacheTokenCommands;
import com.demo.www.springbootdemo.module.redisclient1.local.ILocalCache;



/**
 * Created on 2019/12/23 14:28
 * author:crs
 * Description:ICacheClient
 * 接口直接可以多继承
 */
public interface ICacheClient extends ICacheCoreCommands, ICacheTokenCommands , ICacheExtensionCommands {
    ILocalCache local();
}
