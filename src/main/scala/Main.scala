/**
 * Created by android on 22/2/15.
 */

import scala.slick.driver.DerbyDriver.simple._

object Main extends App {
  println("Derby Database Application")
  
  import Tables._
  
  println("1) " + positions.ddl.createStatements.mkString)
  println("2) " + players.ddl.createStatements.mkString)
  println("3) " + matches.ddl.createStatements.mkString)
  println("4) " + teams.ddl.createStatements.mkString)

  
  import DBUtils._
  db.withSession { implicit session => {
    ( positions.ddl ++
      players.ddl ++
      matches.ddl ++
      teams.ddl ).drop
    }
  }

}
