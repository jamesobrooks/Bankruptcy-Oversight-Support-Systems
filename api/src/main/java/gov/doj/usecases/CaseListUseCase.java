package gov.doj.usecases;

import gov.doj.ObjectFactory;
import gov.doj.Presenter;
import org.jboss.resteasy.reactive.server.spi.ServerRequestContext;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CaseListUseCase {

    public void getCases(String user, ServerRequestContext context) {
        PersistenceGateway persistenceGateway = ObjectFactory.getObjectByAbstractClass(PersistenceGateway.class);
        List<String> cases = persistenceGateway.getCases();

        Presenter presenter = ObjectFactory.getObjectByAbstractClass(Presenter.class);
        presenter.onSuccess(cases.toString(), context);
    }
}
