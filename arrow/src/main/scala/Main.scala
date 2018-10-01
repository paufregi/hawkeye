package lab.acme

import language.postfixOps
import cats.effect._
import org.http4s.server.blaze._

import scala.concurrent.ExecutionContext.Implicits.global

object Main extends App {
  BlazeBuilder[IO]
    .bindHttp(9000, "0.0.0.0")
    .mountService(Endpoints.liveness)
    .mountService(Endpoints.hello)
    .serve
    .compile
    .drain
    .unsafeRunSync
}
