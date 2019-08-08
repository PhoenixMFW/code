package com.apple.demo

import akka.actor.Actor

object ReceiveActor extends Actor{
  override def receive = {
    case SubmitTaskMessage(message) => println(s"ReceivActor:接收到任务提交消息${message}")
      sender ! SuccessSubmitTaskMessage("成功提交任务")
  }

}
