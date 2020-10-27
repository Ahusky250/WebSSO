package cn.wolfcode.sso.util;

import cn.wolfcode.sso.vo.ClientInfoVo;

import java.util.*;

/**
 * 模拟数据库，保存子系统的session对象信息
 */
public class MockDatabaseUtil {
    public static Set<String> T_TOKEN = new HashSet<String>();
    public static Map<String,List<ClientInfoVo>> T_CLIENT_INFO =new HashMap<String,List<ClientInfoVo>>();
}