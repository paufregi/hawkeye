package lab.acme

import org.http4s.{Method, Request, Uri}
import org.scalatest.{Matchers, WordSpec}

class EndpointsTest extends WordSpec with Matchers {
  "#liveness" should {
    "should return `No content`" in {
      val response = Endpoints.liveness
        .run(Request(method = Method.GET, uri = Uri.uri("/liveness")))
        .value
        .unsafeRunSync
        .get

      response.status.code shouldBe 204
    }
  }

  "#hello" should {
    "should return `OK - 'world'`" in {
      val response = Endpoints.hello
        .run(Request(method = Method.GET, uri = Uri.uri("/hello")))
        .value
        .unsafeRunSync
        .get

      response.status.code shouldBe 200
      response.as[String].unsafeRunSync shouldBe "Hello World!"
    }
  }
}
