package domain.person

import java.util.UUID

trait PersonStore{
  def create(person: Person): Person

  def fetch(uuid: UUID): Option[Person]
}