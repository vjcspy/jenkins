def call(Map data = [:] as Map) {
    loadLinuxScript(name: "hello-world.sh")
    sh "./hello-world.sh ${data.name}"
}