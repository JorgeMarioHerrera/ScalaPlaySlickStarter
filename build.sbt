import scala.collection.Seq

ThisBuild / scalaVersion := "2.13.14"

ThisBuild / version := "1.0-SNAPSHOT"

name := "person-sample"

lazy val root = (project in file("."))
  .enablePlugins(PlayScala)
  .settings(
    name := """scalaPlaySlickStarter""",
    libraryDependencies ++= Seq(
      guice,
      "org.scalatestplus.play" %% "scalatestplus-play" % "5.1.0" % Test,
      "org.playframework" %% "play-slick" % "6.1.0",
      "org.playframework" %% "play-slick-evolutions" % "6.1.0",
      "com.h2database" % "h2" % "2.2.224",
      specs2 % Test,
    ),
    (Global / concurrentRestrictions) += Tags.limit(Tags.Test, 1)
  )
  .settings((Test / javaOptions) += "-Dslick.dbs.default.connectionTimeout=30 seconds")
  // We use a slightly different database URL for running the slick applications and testing the slick applications.
  .settings((Test / javaOptions) ++= Seq("-Dconfig.file=conf/test.conf"))