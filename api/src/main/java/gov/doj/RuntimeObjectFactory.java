package gov.doj;

import gov.doj.adapters.gateways.AzureSqlGateway;
import gov.doj.adapters.gateways.LocalPersistenceGateway;
import gov.doj.adapters.presenters.JsonPresenter;
import gov.doj.usecases.PersistenceGateway;
import io.quarkus.runtime.configuration.ConfigUtils;
import io.quarkus.runtime.configuration.ProfileManager;

import java.util.List;

public class RuntimeObjectFactory extends ObjectFactory {
    public static void init() {
        registerObject(Presenter.class, new JsonPresenter());
        List<String> profiles = ConfigUtils.getProfiles();
        if (profiles.contains("dev")) {
            initLocal();
        } else if (profiles.contains("prod")) {
            initProd();
        }
    }

    private static void initLocal() {
        registerObject(PersistenceGateway.class, new LocalPersistenceGateway());
    }

    private static void initProd() {
        registerObject(PersistenceGateway.class, new AzureSqlGateway());
    }
}
