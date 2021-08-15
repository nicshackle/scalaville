import domain.person.{Person, PersonService}
import org.joda.time.DateTime
import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

class PersonServiceTest extends AnyFlatSpec with Matchers {
  val service = new PersonService()

  behavior of "idle"

  it should "tire a person" in {
    val person = Person(name = "bill", dateOfBirth = DateTime.parse("2001-01-01"))

    val updatedPerson = service.idle(person)
    updatedPerson.restedness shouldEqual 99.00
  }

  it should "make a person more hungry" in {
    val person = Person(name = "bill", dateOfBirth = DateTime.parse("2001-01-01"))

    val updatedPerson = service.idle(person)
    updatedPerson.hunger shouldEqual 99.00
  }

  behavior of "sleep"

  it should "rest a person" in {
    val person = Person(name = "bill", dateOfBirth = DateTime.parse("2001-01-01"), restedness = 50.00)

    val updatedPerson = service.sleep(person)
    updatedPerson.restedness shouldEqual 51.00
  }

  it should "make a person more hungry" in {
    val person = Person(name = "bill", dateOfBirth = DateTime.parse("2001-01-01"))

    val updatedPerson = service.sleep(person)
    updatedPerson.hunger shouldEqual 99.00
  }

  behavior of "eat"

  it should "tire a person" in {
    val person = Person(name = "bill", dateOfBirth = DateTime.parse("2001-01-01"))

    val updatedPerson = service.eat(person)
    updatedPerson.restedness shouldEqual 99.00
  }

  it should "make a person less hungry" in {
    val person = Person(name = "bill", dateOfBirth = DateTime.parse("2001-01-01"), hunger = 50.00)

    val updatedPerson = service.eat(person)
    updatedPerson.hunger shouldEqual 51.00
  }
}