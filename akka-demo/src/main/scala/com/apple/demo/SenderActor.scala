package com.apple.demo

import akka.actor.Actor

object SenderActor extends Actor{
  override def receive = {
    case "start" => println("senderActor接收到start消息")
      val receiveActor = context.actorSelection("akka://actorSystem/user/receiveActor")
      receiveActor ! SubmitTaskMessage("提交任务")
    case SuccessSubmitTaskMessage(message) =>
      println(s"senderActor,接收到任务提交成功消息${message}")
  }

}
