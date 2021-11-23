val scala3Version = "3.1.0"

lazy val root = project
  .in(file("."))
  .settings(
    name := "opinion-dynamics",
    version := "0.1.0",

    scalaVersion := scala3Version,

    libraryDependencies += "com.github.scopt" %% "scopt" % "4.0.1" cross(CrossVersion.for3Use2_13),
    libraryDependencies += "com.github.pathikrit" %% "better-files" % "3.9.1" cross(CrossVersion.for3Use2_13),
    libraryDependencies += "org.apache.commons" % "commons-math3" % "3.6.1",

  )
