package com.pacific.web.tool;

import com.pacific.common.web.RequestContext;
import com.pacific.common.web.xuser.XUser;
import com.pacific.common.web.xuser.XUserSessionManager;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Fe on 16/6/7.
 */
public class PacificWebTool {

    public static final Map<String,String> uriDescriptionMapping = new HashMap<String,String>();

    static {
        uriDescriptionMapping.put("/home.htm","首页");
        uriDescriptionMapping.put("/user/userList.htm","用户列表");
    }

    public String getDescriptionByUri() {
        String requestUri = RequestContext.getRequest().getRequestURI();
        return uriDescriptionMapping.get(requestUri);
    }

    public String getLoginUserName() {
        String userName = null;
        if (XUserSessionManager.getCurrent() != null) {
           XUser xUser = XUserSessionManager.getCurrent().getXUser();
            if (xUser != null) {
                userName = xUser.getUserName();
            }
        }
        return userName;
    }
}
