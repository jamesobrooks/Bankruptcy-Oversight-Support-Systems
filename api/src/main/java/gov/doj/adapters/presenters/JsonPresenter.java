package gov.doj.adapters.presenters;

import gov.doj.Presenter;
import org.jboss.resteasy.reactive.server.spi.ServerRequestContext;

import javax.ws.rs.core.HttpHeaders;

public class JsonPresenter implements Presenter {
    @Override
    public void onSuccess(Object content, ServerRequestContext context) {
        System.out.println(content);
        byte[] bytes = content.toString().getBytes();
        context.serverResponse().addResponseHeader(HttpHeaders.CONTENT_LENGTH, String.valueOf(bytes.length)).write(bytes);
    }

    @Override
    public void onFailure(Exception e, ServerRequestContext context) {
        System.out.println(e);
    }
}
