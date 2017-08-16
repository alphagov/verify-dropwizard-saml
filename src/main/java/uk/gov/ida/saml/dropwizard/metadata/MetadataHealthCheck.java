package uk.gov.ida.saml.dropwizard.metadata;

import com.codahale.metrics.health.HealthCheck;
import net.shibboleth.utilities.java.support.resolver.CriteriaSet;
import org.opensaml.core.criterion.EntityIdCriterion;
import org.opensaml.saml.metadata.resolver.MetadataResolver;
import org.opensaml.saml.saml2.metadata.EntityDescriptor;

import javax.inject.Inject;
import javax.inject.Named;

import static com.codahale.metrics.health.HealthCheck.Result.healthy;
import static com.codahale.metrics.health.HealthCheck.Result.unhealthy;

public class MetadataHealthCheck extends HealthCheck {

    private MetadataResolver metadataResolver;
    private String expectedEntityId;

    @Inject
    public MetadataHealthCheck(MetadataResolver metadataProvider,
                               @Named("expectedEntityId") String expectedEntityId) {
        this.metadataResolver = metadataProvider;
        this.expectedEntityId = expectedEntityId;
    }

    public String getName() {
        return "metadata";
    }

    @Override
    protected Result check() throws Exception {
        CriteriaSet criteria = new CriteriaSet(new EntityIdCriterion(expectedEntityId));
        EntityDescriptor entityDescriptor = metadataResolver.resolveSingle(criteria);
        if (entityDescriptor != null) {
            return healthy();
        }
        return unhealthy("Could not load the hub entity from the metadata provider");
    }
}
