import sbt._
import Keys._
import PlayProject._

object ApplicationBuild extends Build {

    val appName         = "howtoforge"
    val appVersion      = "1.0"

	val appDependencies = Seq(
      // Add your project dependencies here,
      "mysql" % "mysql-connector-java" % "5.1.18",
      "org.jsoup" % "jsoup" % "1.7.2"
    )

    val main = PlayProject(appName, appVersion, appDependencies, mainLang = JAVA).settings(
      // Add your own project settings here  
      resolvers += "JBoss repository" at "https://repository.jboss.org/nexus/content/repositories/",
      resolvers += "Scala-Tools Maven2 Snapshots Repository" at "http://scala-tools.org/repo-snapshots"    
    )
	
    

}
