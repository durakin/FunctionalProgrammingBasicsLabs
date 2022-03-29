ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "3.1.1"

lazy val root = (project in file("."))
  .settings(
    name := "FunctionalProgrammingBasicsLabs",
    idePackagePrefix := Some("com.github.durakin")
  )
