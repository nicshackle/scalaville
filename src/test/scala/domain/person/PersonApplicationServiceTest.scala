package domain.person

import org.joda.time.DateTime
import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

class PersonApplicationServiceTest extends AnyFlatSpec with Matchers {
  behavior of "person application service"

  val inMemoryStore = new InMemoryPersonStore()
  val personApplicationService = new PersonApplicationService(inMemoryStore)

  it should "create and find person" in{
    val person = Person(name = "bill", dateOfBirth = DateTime.parse("2001-01-01"))
    personApplicationService.create(person)
    val foundPerson = personApplicationService.fetch(person.uuid)
    foundPerson.get shouldEqual person
  }

  it should "list people" in{
    val personOne = Person(name = "bill", dateOfBirth = DateTime.parse("2001-01-01"))
    val personTwo = Person(name = "jane", dateOfBirth = DateTime.parse("2001-01-01"))

    personApplicationService.create(personOne)
    personApplicationService.create(personTwo)

    val people: List[Person] = personApplicationService.list()

    people.length shouldEqual 2
    people.head.name shouldEqual "jane"
    people.last.name shouldEqual "bill"
  }

  it should "update a person" in {
    val person = Person(name = "bill", dateOfBirth = DateTime.parse("2001-01-01"))
    personApplicationService.create(person)
    personApplicationService.list().length shouldEqual 1

    val personToUpdate = personApplicationService.fetch(person.uuid).get.copy(name = "newName")

    val updatedPerson: Option[Person] = personApplicationService.update(personToUpdate)
    updatedPerson.get.uuid shouldEqual personToUpdate.uuid
    updatedPerson.get.name shouldEqual "newName"
    personApplicationService.list().length shouldEqual 1
  }
}