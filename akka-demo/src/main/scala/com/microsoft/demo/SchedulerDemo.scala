package com.microsoft.demo

import akka.actor.{Actor, ActorRef, ActorSystem, Props}
import com.typesafe.config.ConfigFactory

object SchedulerDemo {
//1.定义一个actor
  object ReceiveActor extends Actor{
    override def receive: Receive = {
      case x => println(x)
    }
  }
  //2.创建actorSystem
  def main(args: Array[String]): Unit = {
    val actorSystem = ActorSystem("actorSystem",ConfigFactory.load())
    val receiveActor: ActorRef = actorSystem.actorOf(Props(ReceiveActor),"receiveActor")
    import scala.concurrent.duration._
    import  actorSystem.dispatcher
    actorSystem.scheduler.schedule(0 seconds,1 seconds,receiveActor,"hello")
  }

}