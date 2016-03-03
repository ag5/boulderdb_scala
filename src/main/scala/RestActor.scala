import akka.actor.Actor
import spray.routing.{Route, HttpService}

class RestActor extends Actor with HttpService {
  def actorRefFactory = context

  def receive = runRoute(pathPrefix("") {
    complete("Kaas")
  })
}