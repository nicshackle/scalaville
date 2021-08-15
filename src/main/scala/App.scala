import domain.person.{InMemoryPersonStore, Person, PersonApplicationService, PersonService, PersonStore}
import org.joda.time.DateTime

object ScalavilleApp extends App{

  var people: List[Person] = List(
    Person(name = "bill", dateOfBirth = DateTime.now()),
    Person(name = "mary", dateOfBirth = DateTime.now()),
    Person(name = "john", dateOfBirth = DateTime.now())
  )

  val store = new InMemoryPersonStore()
  val personApplicationService = new PersonApplicationService(store)
  val personService = new PersonService()


  people.map{ personApplicationService.create }

  while(!personApplicationService.list().head.isDead){
    personApplicationService.list().map{ person =>
      println(s"${person.name}: ${person.hunger}% hunger, ${person.restedness}% restedness")
      val updatedPerson = personApplicationService.update(personService.idle(person)).get
    }
  }
}