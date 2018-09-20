import Dependencies._

lazy val root = (project in file("."))
  .configs(IntegrationTest)
  .settings(Defaults.itSettings : _*)
  .settings(Settings.general: _*)
  .settings(
    name := "hawkeye",
    organization := "lab.acme",
    version := "0.1.0-SNAPSHOT"
  )
  .settings(libraryDependencies ++= Seq (
    typesafeConfig,
    scalaLogging
  ))
  .settings(libraryDependencies ++= testDependencies(Seq(
    scalatest
  )))
