import domain.person.{Person, PersonService}
import org.joda.time.DateTime

object ScalavilleApp extends App{

  var person: Person = Person(name = "nic", dateOfBirth = DateTime.now())

  val personService: PersonService = new PersonService

  println(s"person: $person")

  while(!person.isDead){
    person = personService.idle(person)
  }

  println(s"${person.name} died.")
}