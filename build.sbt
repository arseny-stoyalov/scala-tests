val common = Seq(
  scalaVersion := "2.13.2"
)

lazy val root = project.in(file("."))
  .aggregate(first, second, third, fourth)

lazy val first = project.in(file("subprojects/first"))
  .settings(
    common,
    libraryDependencies += "org.scalatest" %% "scalatest" % "3.0.8" % Test
  )

lazy val second = project.in(file("subprojects/second"))
  .settings(
    common,
    libraryDependencies += "org.scalatest" %% "scalatest" % "3.0.8" % Test
  )

lazy val third = project.in(file("subprojects/third"))
  .settings(
    common,
    libraryDependencies += "org.scalatest" %% "scalatest" % "3.0.8" % Test
  )

lazy val fourth = project.in(file("subprojects/fourth"))
  .settings(
    common,
    libraryDependencies += "org.scalatest" %% "scalatest" % "3.0.8" % Test
  )

