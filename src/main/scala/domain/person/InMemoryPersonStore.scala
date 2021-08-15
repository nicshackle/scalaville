package domain.person
import java.util.UUID

class InMemoryPersonStore extends PersonStore {
  var people: List[Person] = List()

  override def create(person: Person): Person = {
    people = person :: people
    person
  }

  override def fetch(uuid: UUID): Option[Person] = {
    people.find(_.uuid == uuid)
  }
}