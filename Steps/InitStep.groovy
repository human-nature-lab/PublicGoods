// Global variables
curRound = 0

// Parameters
initScore = 1000
coc = 50
po = 100
nRounds = 10


initStep = stepFactory.createStep()

initStep.run = {
  println "initStep.run: ${curRound}"
  
  g.addAI(a, 20)
  g.random(0.2)
  curRound = 1
  // Start dropping players
  a.setDropPlayers(true)
  g.V.each { player->
    player.text = c.get("PleaseWait") + "<p><strong>Click 'Begin' to join the game.</strong></p>"
    a.add(player, [name: "Begin", result: {
      player.text = c.get("PleaseWait") + "<p><strong>Thank you, the game will begin in a moment.</strong></p>"
    }])
  }
}

initStep.done = {
  println "initStep.done: ${curRound}"
  cooperationStep.start()
}