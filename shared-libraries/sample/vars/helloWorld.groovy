def call() {
    sh "Hello World from sample shared library"
}

def testMapArg(Map config = [:]) {
    sh "echo Hello ${config.name}"
}