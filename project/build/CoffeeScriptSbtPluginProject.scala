import sbt._

class CoffeeScriptSbtPluginProject(info: ProjectInfo) extends PluginProject(info) with test.ScalaScripted {
  val jcoffeescript = "org.jcoffeescript" % "jcoffeescript" % "1.0" from "http://cloud.github.com/downloads/vspy/jcoffeescript/jcoffeescript-1.0.jar"
  val rhinoYui = "rhino" % "js" % "1.6R7yui" from "http://cloud.github.com/downloads/vspy/rhino1.6R7-yui/js.jar"

  override def scriptedSbt = "0.7.4"
  override def scriptedBufferLog = false

  override def testAction = testNoScripted
  lazy val default = scripted dependsOn(publishLocal) describedAs("Publishes locally and tests against example projects")

  val publishTo = Resolver.file("local-s3-repo.coderlukes.com-mirror",
                                new java.io.File(Path.userHome.toString, "code/repo.coderlukes.com"))
}
