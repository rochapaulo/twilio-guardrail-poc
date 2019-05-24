val CirceVersion = "0.11.1"
val AkkaVersion = "10.1.6"
val AkkaStreamVersion = "2.5.23"

name := "twilio-guardrail-poc"
version := "0.1"
scalaVersion := "2.12.8"


libraryDependencies ++= Seq(
  "io.circe"              %% "circe-java8"        % CirceVersion,
  "io.circe"              %% "circe-generic"      % CirceVersion,
  "io.circe"              %% "circe-jawn"         % CirceVersion,
  "com.typesafe.akka"     %% "akka-http"          % AkkaVersion,
  "com.typesafe.akka"     %% "akka-http-core"     % AkkaVersion,
  "com.typesafe.akka"     %% "akka-stream"        % AkkaStreamVersion

)


guardrailTasks in Compile := List(
  ScalaServer(
    specPath = (Compile / resourceDirectory).value / "contract.yml",
    pkg = "rochapaulo.railguard.poc.endpoints",
    framework = "akka-http"
  )
)