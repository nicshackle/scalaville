package domain.person

import java.util.UUID

trait PersonStore{
  def create(person: Person): Person

  def fetch(uuid: UUID): Option[Person]

  def list(): List[Person]

  def update(person: Person): Option[Person]
}