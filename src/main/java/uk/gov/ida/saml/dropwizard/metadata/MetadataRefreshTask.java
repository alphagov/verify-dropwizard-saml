package uk.gov.ida.saml.dropwizard.metadata;

import com.google.common.collect.ImmutableMultimap;
import com.google.inject.Inject;
import io.dropwizard.servlets.tasks.Task;
import org.opensaml.saml.metadata.resolver.MetadataResolver;
import org.opensaml.saml.metadata.resolver.impl.AbstractReloadingMetadataResolver;

import java.io.PrintWriter;

public class MetadataRefreshTask extends Task {
    private MetadataResolver metadataProvider;

    @Inject
    public MetadataRefreshTask(MetadataResolver metadataProvider) {
        super("metadata-refresh");
        this.metadataProvider = metadataProvider;
    }

    @Override
    public void execute(ImmutableMultimap<String, String> parameters, PrintWriter output) throws Exception {
        AbstractReloadingMetadataResolver abstractReloadingMetadataProvider = (AbstractReloadingMetadataResolver) metadataProvider;
        abstractReloadingMetadataProvider.refresh();
    }
}
