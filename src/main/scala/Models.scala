import java.sql.Timestamp

/**
 * Created by android on 22/2/15.
 */
object Models {
  case class Position(name: String, description: String, positionId: Option[Int] = None)
  case class Player(name: String, positionId: Int, playerId: Option[Int] = None)
  case class Match(tournamentName: String, dateAndTime: Timestamp, venue: String, opponentTeam: String, matchId: Option[Int] = None)
  case class Team(matchId: Int, playerId: Int, teamId: Option[Int] = None)
}
