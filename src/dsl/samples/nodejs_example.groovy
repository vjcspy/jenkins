job('nodejs-example') {
    scm {
        git('https://github.com/vjcspy/jenkins.git') {  node -> // is hudson.plugins.git.GitSCM
            node / gitConfigName('DSL User')
            node / gitConfigEmail('jenkins-dsl@newtech.academy')
        }
    }
    triggers {
        scm('H/5 * * * *')
    }
    wrappers {
        nodejs('nodejs16') // this is the name of the NodeJS installation in
    // Manage Jenkins -> Configure Tools -> NodeJS Installations -> Name
    }
    steps {
        shell('echo Hello World!')
        shell('pwd')
        shell('cd src/dsl/temp/')
        shell('pwd')
    }
}
