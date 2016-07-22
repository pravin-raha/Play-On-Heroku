package controllers




import javax.inject.Inject

import play.api.db.Database
import play.api.mvc.{Action, Controller}

/**
  * Created by synerzip1 on 21/7/16.
  */
class HomeController @Inject()(db: Database) extends Controller {

  def index = Action {
    Ok("hi ok dfghj")
  }

  def dbs = Action {
    var out = ""
    val conn = db.getConnection()
    try {
      val stmt = conn.createStatement
      stmt.executeUpdate("CREATE TABLE IF NOT EXISTS ticks (tick timestamp)")
      stmt.executeUpdate("INSERT INTO ticks VALUES (now())")

      val rs = stmt.executeQuery("SELECT tick FROM ticks")

      while (rs.next) {
        out += "Read from DB: " + rs.getTimestamp("tick") + "\n"
      }
    } finally {
      conn.close()
    }
    Ok(out)
  }

}
