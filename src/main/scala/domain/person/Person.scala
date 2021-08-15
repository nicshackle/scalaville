package domain.person

import java.util.UUID

import org.joda.time.DateTime

case class Person (
                  uuid: UUID = UUID.randomUUID(),
                  dateOfBirth: DateTime,
                  name: String,
                  restedness: Double = 100,
                  hunger: Double = 100
                  ) {
  val isDead: Boolean = (restedness<0.00) || (hunger<0.00)
}