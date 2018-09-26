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
    target in assembly := file("target"),
    assemblyJarName in assembly := s"${name.value}.jar",
  )
  .settings(libraryDependencies ++= Seq (
    typesafeConfig,
    scalaLogging
  ))
  .settings(libraryDependencies ++= testDependencies(Seq(
    scalatest
  )))
