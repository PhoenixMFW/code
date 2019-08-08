package com.apple.demo

import akka.actor.{ActorSystem, Props}
import com.typesafe.config.ConfigFactory

object Entrance {
  def main(args: Array[String]): Unit = {
     // 实现一个actor trait

    //创建actorSystem
    val actorSystem = ActorSystem("actorSystem",ConfigFactory.load())
   //加载actor
    val senderActor = actorSystem.actorOf(Props(SenderActor),"senderActor")
    val receiveActor = actorSystem.actorOf(Props(ReceiveActor),"receiveActor")
    senderActor ! "start"
  }
}
