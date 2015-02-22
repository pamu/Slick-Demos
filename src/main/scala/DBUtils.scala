/**
 * Created by android on 22/2/15.
 */

import scala.slick.driver.DerbyDriver.simple._

object DBUtils {
  def db = Database.forURL("jdbc:derby://localhost:1527/demo;create=true", driver = "org.apache.derby.jdbc.ClientDriver")
}
