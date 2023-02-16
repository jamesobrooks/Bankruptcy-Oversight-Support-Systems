package gov.doj;

import org.jboss.resteasy.reactive.server.spi.ServerRequestContext;

public interface Presenter {
    void onSuccess(Object content, ServerRequestContext context);

    void onFailure(Exception e, ServerRequestContext context);
}
