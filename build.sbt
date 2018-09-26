import Dependencies._

lazy val root = (project in file("."))
  .configs(IntegrationTest)
  .settings(Defaults.itSettings : _*)
  .settings(Settings.general: _*)
  .settings(
    name := "hawkeye",
    organization := "lab.acme",
  )
  .settings(
    mainClass in assembly := Some("lab.acme.Main"),
    test in assembly := {},
    assemblyJarName in assembly := "hawkeye.jar"
  )
  .settings(libraryDependencies ++= Seq (
    typesafeConfig,
    scalaLogging
  ))
  .settings(libraryDependencies ++= testDependencies(Seq(
    scalatest
  )))
