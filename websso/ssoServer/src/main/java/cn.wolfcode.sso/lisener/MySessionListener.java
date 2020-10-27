package cn.wolfcode.sso.lisener;

import cn.wolfcode.sso.util.HttpUtil;
import cn.wolfcode.sso.util.MockDatabaseUtil;
import cn.wolfcode.sso.vo.ClientInfoVo;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import java.util.List;

/**
 * 监听session,用于退出所有客户端
 */
public class MySessionListener implements HttpSessionListener {
    @Override
    public void sessionCreated(HttpSessionEvent se) {

    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        HttpSession session = se.getSession();
        String token = (String) session.getAttribute("token");
        //删除t_token表中的数据
        MockDatabaseUtil.T_TOKEN.remove(token);
        List<ClientInfoVo> clientInfoVoList = MockDatabaseUtil.T_CLIENT_INFO.remove(token);
        try{
            if(clientInfoVoList !=null){
                for(ClientInfoVo vo:clientInfoVoList){
                    //获取出注册的子系统,依次调用子系统的登出的方法
                    HttpUtil.sendHttpRequest(vo.getClientUrl(),vo.getJsessionid());
                }
            }
        }catch(Exception e){
            e.printStackTrace();
        }

    }
}
