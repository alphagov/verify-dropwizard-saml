#!/bin/sh

./gradlew --daemon --parallel clean build test

tput setaf 3
tput sgr0
