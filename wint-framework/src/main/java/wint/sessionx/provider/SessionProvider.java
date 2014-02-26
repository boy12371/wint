package wint.sessionx.provider;

import wint.lang.magic.MagicMap;

import javax.servlet.ServletContext;

/**
 * User: longyi
 * Date: 14-2-26
 * Time: 下午2:04
 */
public interface SessionProvider {

    void init(MagicMap initParamters, ServletContext servletContext);

    RequestParser getRequestParser();

    SessionStoreCreator getSessionStoreCreator();

}
