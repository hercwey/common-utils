package allen.utils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;

/**
 * ResponseUtils
 * 
 * 
 * @version 1.0
 */
public class ResponseUtils {
    /**
     * 添加一个cookie
     * 
     * @param name
     * @param value
     */
    public static void addCookie(HttpServletResponse response, String name,
            String value) {
        if (StringUtils.isNotEmpty(name) && StringUtils.isNotEmpty(value)) {
            Cookie cookie = new Cookie(name, value);
            // cookie.setDomain(OptConfig.DOMAIN);
            cookie.setPath("/");
            cookie.setMaxAge(7 * 24 * 60 * 60);
            response.addCookie(cookie);
        }
    }

    /**
     * 删除一个cookie
     * 
     * @param name
     */
    public static void removeCookie(HttpServletResponse response, String name,String domain) {
        if (StringUtils.isNotEmpty(name)) {
            Cookie cookie = new Cookie(name, null);
            cookie.setMaxAge(0);
            if(StringUtils.isNotEmpty(domain)){
                cookie.setDomain(domain);
            }
            cookie.setPath("/");
            response.addCookie(cookie);
        }
    }

    /**
     * 给response里写入状态404
     * 
     * @param response
     */
    public static void send404(HttpServletResponse response) {
        try {
            response.sendError(404);
        } catch (Exception e) {
        }
    }
}
