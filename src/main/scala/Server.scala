import akka.actor.ActorSystem
import akka.http.scaladsl.Http
import akka.stream.ActorMaterializer
import handlers.HelloHandlerImpl

import scala.concurrent.ExecutionContext
import rochapaulo.railguard.poc.endpoints.hello.HelloResource

object Server extends App {

  val host = "0.0.0.0"
  val port = 9000

  implicit val system: ActorSystem = ActorSystem("GuardrailPOC")
  implicit val executor: ExecutionContext = system.dispatcher
  implicit val materializer: ActorMaterializer = ActorMaterializer()

  val route = {
    HelloResource.routes(new HelloHandlerImpl)
  }

  Http().bindAndHandle(route, host, port)

}
