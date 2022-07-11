ThisBuild / scalaVersion := "2.13.8"

ThisBuild / version := "1.0-SNAPSHOT"

lazy val root = (project in file("."))
  .enablePlugins(PlayScala)
  .settings(
    name := """scala-framework-pratice""",
    libraryDependencies ++= Seq(
      jdbc,
      cacheApi,
      ws,
      guice,
      "org.scalatestplus.play" %% "scalatestplus-play" % "5.1.0" % Test,
      "com.typesafe.play" %% "play-slick" % "5.0.2",
      "com.typesafe.play" %% "play-slick-evolutions" % "5.0.2" % Test,
      "org.playframework.anorm" %% "anorm" % "2.6.10",
      "mysql" % "mysql-connector-java" % "8.0.29"
    )
  )
