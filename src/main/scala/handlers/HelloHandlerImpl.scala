package handlers

import rochapaulo.railguard.poc.endpoints.definitions.HelloResponse
import rochapaulo.railguard.poc.endpoints.hello.{HelloHandler, HelloResource}

import scala.concurrent.{ExecutionContext, Future}

class HelloHandlerImpl(implicit context: ExecutionContext) extends HelloHandler {
  override def getHello(respond: HelloResource.getHelloResponse.type)(): Future[HelloResource.getHelloResponse] = {
    Future(respond.OK(HelloResponse("Hello")))
  }
}
