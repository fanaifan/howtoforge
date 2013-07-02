import sbt._
import Keys._
import PlayProject._

object ApplicationBuild extends Build {

    val appName         = "howtoforge"
    val appVersion      = "1.0-SNAPSHOT"

    val appDependencies = Seq(
      // Add your project dependencies here,
      libraryDependencies += "org.jsoup" % "jsoup" % "1.7.2",
      "mysql" % "mysql-connector-java" % "5.1.18"
    )

    val main = PlayProject(appName, appVersion, appDependencies, mainLang = JAVA).settings(
      // Add your own project settings here      
    )

}
