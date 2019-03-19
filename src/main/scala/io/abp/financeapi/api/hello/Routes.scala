package io.abp.financeapi.api.hello

import cats.effect.Sync
import io.circe.Json
import org.http4s.HttpRoutes
import org.http4s.circe._
import org.http4s.dsl.Http4sDsl

final case class Routes[F[_]: Sync]() extends Http4sDsl[F] {

  val routes: HttpRoutes[F] = HttpRoutes.of {
    case GET -> Root / "hello" / name =>
      Ok(Json.obj("message" -> Json.fromString(s"Hello, ${name}")))
  }
}