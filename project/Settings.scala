package lab.acme.hawkeye

import sbt.Keys._
import sbt._

object Settings {

  private object Version {
    lazy val SCALA = "2.12.2"
  }

  lazy val general = Seq(
    scalaVersion := Version.SCALA,
    resolvers ++= Seq(
      Resolver.defaultLocal,
      Resolver.mavenLocal,
      Resolver.jcenterRepo
    )
  )

  lazy val directoryLayout = Seq(
    sourceDirectory in Compile := baseDirectory.value / "src",
    sourceDirectory in Test := baseDirectory.value / "test",
    sourceDirectory in IntegrationTest := baseDirectory.value / "it",
    scalaSource in Compile := baseDirectory.value / "src",
    scalaSource in Test := baseDirectory.value / "test",
    scalaSource in IntegrationTest := baseDirectory.value / "it",
    resourceDirectory in Compile := baseDirectory.value / "resources",
    resourceDirectory in Test := baseDirectory.value / "resources_test",
    resourceDirectory in IntegrationTest := baseDirectory.value / "resources_test",
    unmanagedSourceDirectories in Compile += baseDirectory.value / "src_generated",
    unmanagedResourceDirectories in Compile += baseDirectory.value / "resources_generated"
  )
}
