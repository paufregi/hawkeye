package lab.acme.katana

import language.postfixOps
import cats.effect._
import org.http4s.{HttpService, _}
import org.http4s.dsl.io._

object Endpoints {
  val liveness: HttpService[IO] = HttpService[IO] {
    case GET -> Root / "liveness" => NoContent()
  }

  val hello: HttpService[IO] = HttpService[IO] {
    case GET -> Root / "hello" => Ok("Hello World!")
  }
}
