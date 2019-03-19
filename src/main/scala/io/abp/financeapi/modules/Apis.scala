package io.abp.financeapi.modules

import cats.effect.Sync

import io.abp.financeapi.api._

final case class Apis[F[_]](
    companies: CompanyRoutes[F],
    hello: HelloRoutes[F]
)

object Apis {
  def apply[F[_]: Sync](): Apis[F] =
    Apis(
      CompanyRoutes(),
      HelloRoutes()
    )
}