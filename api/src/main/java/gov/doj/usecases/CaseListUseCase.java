package gov.doj.usecases;

import gov.doj.ObjectFactory;
import gov.doj.Presenter;
import org.jboss.resteasy.reactive.server.spi.ServerRequestContext;

import java.util.List;

public class CaseListUseCase {

    public void getCases(String user, ServerRequestContext context) {
        PersistenceGateway persistenceGateway = ObjectFactory.getObjectByAbstractClass(PersistenceGateway.class);
        Presenter presenter = ObjectFactory.getObjectByAbstractClass(Presenter.class);
        List<String> cases = persistenceGateway.getCases();
        try {
            cases.addAll(persistenceGateway.getCases());
            presenter.onSuccess(cases.toString(), context);
        } catch (Exception e) {
            presenter.onFailure(e, context);
        }
    }
}
