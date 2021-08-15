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

  override def list(): List[Person] = people

  override def update(person: Person): Option[Person] = {
    var updatedPerson: Option[Person] = None
    people = people.map{ p =>
      if(p.uuid == person.uuid) {
        updatedPerson = Some(person)
        person
      } else p
    }
    updatedPerson
  }
}