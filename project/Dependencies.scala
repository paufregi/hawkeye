import sbt._

object Dependencies {

  def testDependencies(list: Seq[ModuleID]): Seq[ModuleID] = list.map(_ % "test,it")

  private object Version {
    lazy val typesafeConfig = "1.3.3"
    lazy val scalaLogging = "3.9.0"
    lazy val scalatest = "3.0.5"
    lazy val http4sVersion = "0.18.19"
  }

  val http4sDsl = "org.http4s" %% "http4s-dsl" % Version.http4sVersion
  val http4sBlazeServer = "org.http4s" %% "http4s-blaze-server" % Version.http4sVersion

  val typesafeConfig = "com.typesafe" % "config" % Version.typesafeConfig
  val scalaLogging = "com.typesafe.scala-logging" %% "scala-logging" % Version.scalaLogging
  val scalatest = "org.scalatest" %% "scalatest" % Version.scalatest
}
