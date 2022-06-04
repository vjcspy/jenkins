def call(Map data = [:] as Map) {
    def scriptcontents = libraryResource "com/vjcspy/scripts/linux/${data.name}"
    writeFile file: "${data.name}", text: scriptcontents
    sh "chmod a+x ./${data.name}"
}