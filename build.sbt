import Dependencies._

lazy val arrow = (project in file("arrow"))
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
