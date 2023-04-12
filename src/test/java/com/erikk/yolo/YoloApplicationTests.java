package com.erikk.yolo;

import com.erikk.yolo.object.GameResponse;
import com.erikk.yolo.service.GameService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.test.annotation.DirtiesContext;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadLocalRandom;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
class YoloApplicationTests {

	@Autowired
	GameService gameService;


	@Test
	void assignmentTest() {
		assertEquals(gameService.playGame(40.5, 50).getWinningAmount(), 80.19);
	}
	@Test
	void gameTest() throws InterruptedException {
		int threads = 24;
		int rounds = 10;
		CountDownLatch latch = new CountDownLatch(threads);
		ExecutorService executorService = Executors.newFixedThreadPool(threads);
		for (int i = 0; i < threads; i++) {
			executorService.execute(() -> {
				try {
					double moneySpent = 0;
					double winnings =  0;
					for (int j = 0; j < rounds; j++) {
						double randomBet = Math.round(ThreadLocalRandom.current().nextDouble(1, 101)*100.0 /100.0);
						moneySpent += randomBet;
						int randomNumber = ThreadLocalRandom.current().nextInt(1, 101);
						GameResponse randomGame = gameService.playGame(randomBet,randomNumber);
						if (randomGame.isWin()) {
							winnings += randomGame.getWinningAmount();
						}

					}
					System.out.println(Math.round((winnings / moneySpent) * 100));
				} finally {
					latch.countDown();
				}
			});
		}
		latch.await();
	}
}
