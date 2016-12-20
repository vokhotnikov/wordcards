name := """wordcards"""

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayScala)

scalaVersion := "2.11.7"

pipelineStages := Seq(digest, gzip)

libraryDependencies ++= Seq(
  jdbc,
  cache,
  ws,
  "org.scalatestplus.play" %% "scalatestplus-play" % "1.5.1" % Test,
  "org.webjars" % "foundation" % "6.2.3",
  "org.webjars" % "foundation-icon-fonts" % "d596a3cfb3",
  "org.webjars.npm" % "what-input" % "2.1.1"
)

