// build.sbt
val scala3Version = "3.7.2"

import scala.scalanative.build._

enablePlugins(ScalaNativePlugin)

lazy val root = project
  .in(file("."))
  .settings(
    name := "thin-scala-native-container",
    version := "0.1.0-SNAPSHOT",
    scalaVersion := scala3Version,
    nativeConfig ~= { c =>
      c.withLinkingOptions(Seq("-static"))
       .withLTO(LTO.thin) // thin
       .withMode(Mode.releaseFast) // releaseFast
       .withGC(GC.immix) // commix
    },
  )
