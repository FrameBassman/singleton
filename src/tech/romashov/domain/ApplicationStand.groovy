package tech.romashov.domain

import tech.romashov.BuildContext

class ApplicationStand {
    private static final Script SCRIPT = BuildContext.script

    public ApplicationStand() {}

    void build() {
        SCRIPT.sh('I want to build Application')
    }
}
