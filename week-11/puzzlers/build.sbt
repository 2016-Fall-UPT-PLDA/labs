import Dependencies._

lazy val root = (project in file(".")).
  settings(
    inThisBuild(List(
      scalaVersion := "2.11.7"
    )),
    name := "puzzlers",
    libraryDependencies += scalaTest % Test
  )
