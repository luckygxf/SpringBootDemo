package com.gxf.how_tomcat.chapter5;

import org.apache.catalina.Contained;
import org.apache.catalina.Container;
import org.apache.catalina.Valve;
import org.apache.catalina.connector.Request;
import org.apache.catalina.connector.Response;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import java.io.IOException;

/**
 * Created by 58 on 2018/4/9.
 */
public class ClientIPLoggerValve implements Valve, Contained {
    protected Container container;

    @Override
    public Container getContainer() {
        return container;
    }

    @Override
    public void setContainer(Container container) {
        this.container = container;
    }

    @Override
    public Valve getNext() {
        return null;
    }

    @Override
    public void setNext(Valve valve) {

    }

    @Override
    public void backgroundProcess() {

    }

    @Override
    public void invoke(Request request, Response response) throws IOException, ServletException {
        System.out.println("client ip logger valve");
        ServletRequest sreq = request.getRequest();
        System.out.println(sreq.getRemoteAddr());
        System.out.println("------------------");
        getNext().invoke(request, response);
    }

    @Override
    public boolean isAsyncSupported() {
        return false;
    }
}
