package domain.person

import java.util.UUID

class PersonApplicationService(personStore: PersonStore){
  def create(person: Person): Person = {
    personStore.create(person)
  }

  def fetch(uuid: UUID): Option[Person] = {
    personStore.fetch(uuid)
  }

  def list(): List[Person] = {
    personStore.list()
  }

  def update(person: Person): Option[Person] = {
    personStore.update(person)
  }
}