package service


import anorm.SqlParser._
import anorm._
import play.api.db.DBApi

import java.util.Date
import javax.inject._
import scala.language.postfixOps

@Singleton
class MemberService @Inject() (dbapi : DBApi){
  val basicMember = {
    get[Int]("member.mid") ~
    get[String]("member.userid") ~
    get[String]("member.password") ~
    get[String]("member.nickname") ~
    get[String]("member.email") ~
    get[Option[Date]]("member.regdate") map {
      case mid ~ userid ~ password ~ nickname ~ email ~ regdate =>
        Member(mid,userid,password,nickname,email,regdate)
    }
  }
  private val db = dbapi.database("default")

  def getList = db.withConnection{
  implicit connect => SQL("SELECT * FROM member").as(basicMember *)
  }
}
case class Member(mid: Int, userid : String, password : String, nickname : String, email: String, regdate:Option[Date])
/*

class ScalaJdbcConnection @Inject() (db: Database, databaseExecutionContext: DatabaseExecutionContext) {
  def updateSomething(): Unit = {
    Future {
      // get jdbc connection
      val connection = db.getConnection()

      // do whatever you need with the db connection

      // remember to close the connection
      connection.close()
    }(databaseExecutionContext)
  }
}

@Singleton
class DatabaseExecutionContext @Inject()(system: ActorSystem) extends CustomExecutionContext(system, "database.default")*/
