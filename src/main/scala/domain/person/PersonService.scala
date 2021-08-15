package domain.person

class PersonService {
  def idle(person: Person): Person ={
    person.copy(
      restedness = person.restedness-1,
      hunger = person.hunger-1
    )
  }

  def sleep(person: Person): Person ={
    person.copy(
      restedness = person.restedness+1,
      hunger = person.hunger-1
    )
  }

  def eat(person: Person): Person ={
    person.copy(
      restedness = person.restedness-1,
      hunger = person.hunger+1
    )
  }
}