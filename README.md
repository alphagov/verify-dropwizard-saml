
# Verify Dropwizard SAML

Library for configuring a metadata healthcheck and providing a SAML Configuration object.

### Building the project

`./gradlew clean build`

### Recreating the Jenkins build environment with docker

To reproduce exactly what the Jenkins build server does, with docker, use the commands below to build the package and run the tests inside it. This is useful for re-creating and debugging build failures.

docker run -it -v "$(pwd)":/app -w /app --rm build-container clean build test
Connect to the container to poke around with it run

'docker run --entrypoint="" build-container /bin/bash'

## Licence

[MIT Licence](LICENCE)

This code is provided for informational purposes only and is not yet intended for use outside GOV.UK Verify
