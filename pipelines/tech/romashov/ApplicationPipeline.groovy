package tech.romashov

import tech.romashov.domain.ApplicationStand

BuildContext.script = this
ApplicationStand stand = new ApplicationStand()

node() {
    stage('Run tests on application stand') {
        stand.build()
    }
}
