name := """Slick-Demos"""

version := """1.0.0"""

scalaVersion := "2.11.4"

mainClass := Some("""Main""")

libraryDependencies ++= Seq("com.typesafe.slick" %% "slick" % "2.1.0",
                            "org.apache.derby" % "derbyclient" % "10.10.1.1")
