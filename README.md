# YoloAssignment
Port: 8080

Endpoint: /game

localhost:8080/game

Message format: 
 
{

  "betAmount": xxx,
  
  "playerNumber": xxx
  
}


Response:

If the user wins -> You won! Your winnings are xxx $

If the user loses -> You lost!

If the fields are empty or contain letters or anything other than numbers -> Invalid format

If the numbers are wrong (the playerNumber is not in the range of 1-100 or the bet is a negative number) -> Invalid bet amount/ player number!



example message: 

{

  "betAmount": 40.5,
  
  "playerNumber": 50
  
}



example response:

User won -> You won! Your winnings are 80.19 $

User lost -> You lost!
