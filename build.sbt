import Dependencies._

lazy val arrow = (project in file("katana"))
  .configs(IntegrationTest)
  .settings(Defaults.itSettings : _*)
  .settings(Settings.general: _*)
  .settings(
    name := "katana",
    organization := "lab.acme",
  )
  .settings(
    test in assembly := {},
    target in assembly := file("target"),
    assemblyJarName in assembly := s"${name.value}.jar",
    mainClass in assembly := Some("lab.acme.Main"),
  )
  .settings(libraryDependencies ++= Seq (
    typesafeConfig,
    scalaLogging,
    http4sDsl,
    http4sBlazeServer
  ))
  .settings(libraryDependencies ++= testDependencies(Seq(
    scalatest
  )))

lazy val clint = (project in file("archery/arrow"))
  .configs(IntegrationTest)
  .settings(Defaults.itSettings : _*)
  .settings(Settings.general: _*)
  .settings(
    name := "arrow",
    organization := "lab.acme",
  )
  .settings(
    test in assembly := {},
    target in assembly := file("target"),
    assemblyJarName in assembly := s"${name.value}.jar",
    mainClass in assembly := Some("lab.acme.Main"),
  )
  .settings(libraryDependencies ++= Seq (
    typesafeConfig,
    scalaLogging,
  ))
  .settings(libraryDependencies ++= testDependencies(Seq(
    scalatest
  )))
