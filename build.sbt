enablePlugins(ScalaJSPlugin)

//name := "CanvasApp"
name := "Graph"
scalaVersion := "2.12.2"
//scalaVersion := "2.12.13"

// This is an application with a main method
//scalaJSUseMainModuleInitializer := true // Vreemd, deed het niet. Toch  maar 1 main
scalaJSUseMainModuleInitializer := false
//mainClass := Some("canvasapp.ScratchPad")
mainClass := Some("graph.opstart.StartGraph")

//Stap 3. Later vervangen door JQuery.Ik probeer <p> erin te houden.

libraryDependencies += "org.scala-js" %%% "scalajs-dom" % "0.9.1"

//JQuery:
libraryDependencies += "be.doeraene" %%% "scalajs-jquery" % "0.9.1"

skip in packageJSDependencies := false

jsDependencies +=
  "org.webjars" % "jquery" % "2.1.4" / "2.1.4/jquery.js"

jsDependencies += RuntimeDOM

// uTest settings
libraryDependencies += "com.lihaoyi" %%% "utest" % "0.4.4" % "test"
testFrameworks += new TestFramework("utest.runner.Framework")
