import java.util.Properties

include(":library")

val properties = Properties()
val propertiesFile = File("library/gradle.properties")
if (propertiesFile.exists()) {
    properties.load(propertiesFile.inputStream())
}
val PUBLISH_NAME = properties.getProperty("PUBLISH_NAME")

rootProject.name = PUBLISH_NAME
rootProject.children.forEach {
    it.name = PUBLISH_NAME
}