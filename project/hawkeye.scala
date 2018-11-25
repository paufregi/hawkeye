package lab.acme

import sbt._
import sbt.Keys._
import sbtassembly.AssemblyKeys._

package object hawkeye {

  implicit class HawkeyeProject(inner: Project) {
    def basic(path: String, projectName: String, org: String): Project =
      inner
        .in(file(path))
        .configs(IntegrationTest)
        .settings(Defaults.itSettings: _*)
        .settings(Settings.general: _*)
        .settings(DirectoryLayoutSettings.defaults)
        .settings(
          name := projectName,
          organization := org
        )
    def withAssembly(folder: String, main: String): Project =
      inner
        .settings(
          test in assembly := {},
          target in assembly := file(folder),
          assemblyJarName in assembly := s"${name.value}.jar",
          mainClass in assembly := Some(main),
        )

    def withLibraries(libs: ModuleID*): Project =
      inner.settings(libraryDependencies ++= libs)

    def withTestLibraries(libs: ModuleID*): Project =
      inner.settings(libraryDependencies ++= testDependencies(libs))

    private def testDependencies(list: Seq[ModuleID]): Seq[ModuleID] = list.map(_ % "test,it")
  }

}
