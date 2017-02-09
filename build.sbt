name := """wordcards"""

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayScala)

scalaVersion := "2.11.8"

pipelineStages := Seq(digest, gzip)

val doobieVersion = "0.4.1"

val monixVersion = "2.2.1"

libraryDependencies ++= Seq(
  cache,
  jdbc,
  evolutions,
  ws,
  "org.scalatestplus.play" %% "scalatestplus-play" % "1.5.1" % Test,
  "org.webjars" % "foundation" % "6.2.3",
  "org.webjars" % "foundation-icon-fonts" % "d596a3cfb3",
  "org.webjars.npm" % "what-input" % "2.1.1",
  "org.webjars" % "knockout" % "3.4.1",
  "org.postgresql" % "postgresql" % "9.3-1102-jdbc41",
  "org.tpolecat" %% "doobie-core-cats" % doobieVersion,
  "org.tpolecat" %% "doobie-postgres-cats" % doobieVersion,
  "org.tpolecat" %% "doobie-scalatest-cats" % doobieVersion,
  "io.monix" %% "monix" % monixVersion,
  "io.monix" %% "monix-cats" % monixVersion
)

