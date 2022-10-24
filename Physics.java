public class Physics{
  private static final double GRAVITY = -9.81; //Upercase bcause constant (naming convention)

   
  /*xf = xi + vi * t + 1/2 * a * t^2
  *final position = initial position position + the product of initial speed + product of 1/2 and acceration and time squared
  */

  /* Position after a constant acceleration
  *using the above information, we know all of the information except final position
  *Precondition: double valyes are supplied for xi, vi, t and a
  *Postondition: xf is returned as a double
  */
  public static double positionConstantAccelMissingFinalPosition(
    double xi,
    double vi,
    double t,
    double a){
    
    double xf = xi + vi * t + .5 * a * Math.pow(t,2);
    return xf;
    }


  /* Position after an initial hit upwards 0 < theta < MATH>PI/2
  *Precondition: angle in degress, 0 < theta < 90, and initial speed
  *Postondition: total horizontal distance traveled
  */

public static double distanceAfterProjectileAtAnAngle(double theta, double speed){
  //convert degrees to radians
  double radians =  theta * Math.PI / 180;
  double xSpeed = speed * Math.cos(radians);
  double ySpeed = speed * Math.sin(radians);

  // Calculates the amount of time the ball takes to hit the ground
  double timeBeforeLanding = flightTime(ySpeed);

  // Calculates the total horizontal distance based on xSpeed and how long the ball flies.
  
  double horizontalDistance = positionConstantAccelMissingFinalPosition(0, xSpeed, timeBeforeLanding, 0);

  return horizontalDistance;
}

// flight time (vertical)

/** This method calculates flight time of an object traveling vertically and effected by gravity
  * Precondition : initial speed (up is positive)
  * Postcondition: time is returned as twice the amount of time taken to reach the apex
  */

public static double flightTime(double speed){
  double totalTime = 2* (-1 * speed) / GRAVITY;
  return totalTime;
}
}