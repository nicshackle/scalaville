package domain.person

import java.util.UUID

import org.joda.time.DateTime
import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

class PersonTest extends AnyFlatSpec with Matchers {
  behavior of "Person"

  it should "instantiate with defaults" in {
    val person = Person(name="bill", dateOfBirth = DateTime.now)

    person.uuid.isInstanceOf[UUID] shouldEqual true
    person.restedness shouldEqual 100.00
    person.hunger shouldEqual 100.00
    person.dateOfBirth.dayOfYear shouldEqual DateTime.now.dayOfYear
  }
}
