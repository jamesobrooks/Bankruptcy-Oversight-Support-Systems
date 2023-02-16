package gov.doj.adapters.controllers;

import gov.doj.RuntimeObjectFactory;
import gov.doj.usecases.CaseListUseCase;
import org.jboss.resteasy.reactive.server.spi.ServerRequestContext;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/cases")
public class CaseListController {
    CaseListController() {
        RuntimeObjectFactory.init();
    }

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public void getCases(ServerRequestContext context) {
        CaseListUseCase useCase = new CaseListUseCase();
        useCase.getCases("", context);
    }
}
