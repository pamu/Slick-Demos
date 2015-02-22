/**
 * Created by android on 22/2/15.
 */

import java.sql.Timestamp

import Models._
import scala.slick.driver.DerbyDriver.simple._

object Tables {
  class Positions(tag: Tag) extends Table[Position](tag, "Positions") {
    def name = column[String]("positionName", O.NotNull)
    def description = column[String]("description", O.NotNull)
    def positionId = column[Int]("positionId", O.PrimaryKey, O.AutoInc)
    def * = (name, description, positionId.?) <> (Position.tupled, Position.unapply)
  }
  val positions = TableQuery[Positions]
  
  class Players(tag: Tag) extends Table[Player](tag, "Players") {
    def name = column[String]("playerName", O.NotNull)
    def positionId = column[Int]("positionId", O.NotNull)
    def playerId = column[Int]("playerId", O.PrimaryKey, O.AutoInc)
    def * = (name, positionId, playerId.?) <> (Player.tupled, Player.unapply)
    def positionIdFk = foreignKey("player_positionId_fk", positionId, positions)(_.positionId)
  }
  val players = TableQuery[Players]
  
  class Matches(tag: Tag) extends Table[Match](tag, "Matches") {
    def tournamentName = column[String]("tournamentName", O.NotNull)
    def dateAndTime = column[Timestamp]("dateAndTime", O.NotNull)
    def venue = column[String]("venue", O.NotNull)
    def opponentTeam = column[String]("opponentTeam", O.NotNull)
    def matchId = column[Int]("matchId", O.PrimaryKey, O.AutoInc)
    def * = (tournamentName, dateAndTime, venue, opponentTeam, matchId.?) <> (Match.tupled, Match.unapply)
  }
  val matches = TableQuery[Matches]
  
  class Teams(tag: Tag) extends Table[Team](tag, "Teams") {
    def matchId = column[Int]("matchId", O.NotNull)
    def playerId = column[Int]("playerId", O.NotNull)
    def teamId = column[Int]("teamId", O.PrimaryKey, O.AutoInc)
    def * =  (matchId, playerId, teamId.?) <> (Team.tupled, Team.unapply)
    
    def matchIdFk = foreignKey("teams_matchId_fk", matchId, matches)(_.matchId)
    def playerIdFk = foreignKey("teams_playerId_fk", playerId, players)(_.playerId)
  }
  val teams = TableQuery[Teams]
  
}
