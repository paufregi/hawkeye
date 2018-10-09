import lab.acme.hawkeye._
import lab.acme.hawkeye.Dependencies._
import sbt._

lazy val katana = project
  .basic("katana", "katana", "lab.acme")
  .withAssembly("target", "lab.acme.katana.Main")
  .withLibraries(
    typesafeConfig,
    scalaLogging,
    http4sDsl,
    http4sBlazeServer
  )
  .withTestLibraries(scalatest)

lazy val arrow = project
  .basic("archery/arrow", "arrow", "lab.acme")
  .withAssembly("target", "lab.acme.archery.arrow.Main")
  .withLibraries(
    typesafeConfig,
    scalaLogging
  )
  .withTestLibraries(scalatest)
