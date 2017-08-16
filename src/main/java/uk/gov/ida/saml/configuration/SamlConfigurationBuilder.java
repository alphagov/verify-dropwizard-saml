package uk.gov.ida.saml.configuration;

import java.net.URI;

public class SamlConfigurationBuilder {
    private String entityId = "entity-id";
    private URI expectedDestinationHost = URI.create("http://localhost");
    private String eidasEntityId = "eidas-entity-id";

    public static SamlConfigurationBuilder aSamlConfiguration() {
        return new SamlConfigurationBuilder();
    }

    public SamlConfigurationImpl build() {
        return new TestSamlConfiguration(entityId, expectedDestinationHost, eidasEntityId);
    }

    public SamlConfigurationBuilder withIssuerId(String issuerId) {
        this.entityId = issuerId;
        return this;
    }

    public SamlConfigurationBuilder withEidasEntityId(String eidasEntityId) {
        this.eidasEntityId = eidasEntityId;
        return this;
    }

    private static final class TestSamlConfiguration extends SamlConfigurationImpl {
        private TestSamlConfiguration(String issuerId, URI expectedDestination, String eidasEntityId) {
            this.entityId = issuerId;
            this.expectedDestination = expectedDestination;
            this.eidasEntityId = eidasEntityId;
        }
    }
}
