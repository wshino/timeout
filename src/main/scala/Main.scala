import scala.concurrent._
import ExecutionContext.Implicits.global
import scala.concurrent.duration._
import scala.util.{Try, Success, Failure}

/**
  * Created by wshino on 2017/07/14.
  */
object Main extends App {

  val f: Future[String] = Future {
    Thread.sleep(10000)
    "exit 0"
  }

  val result = Try {
    Await.ready(f, 1 seconds).value.get
  }

  result match {
    case Success(t) => t.map(x => println(x))
    case Failure(e) => println("timeout")
  }
}
