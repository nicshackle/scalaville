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
}