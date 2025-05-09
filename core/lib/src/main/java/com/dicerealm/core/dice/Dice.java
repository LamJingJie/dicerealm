package com.dicerealm.core.dice;

import com.dicerealm.core.strategy.RandomStrategy;

public class Dice {
	private int sides;
	transient RandomStrategy randomStrategy = new DefaultRandomStrategy();

	public Dice(int sides) {
		this.sides = sides;
	}

	public int roll() {
		// don't ask
		if (randomStrategy == null) {
			randomStrategy = new DefaultRandomStrategy();
		}
		return (int) (randomStrategy.random() * sides) + 1;
	}

	public void setRandomStrategy(RandomStrategy randomStrategy) {
		this.randomStrategy = randomStrategy;
	}

	private class DefaultRandomStrategy implements RandomStrategy {
		@Override
		public double random() {
			return Math.random();
		}
	}

	public int getSides() { return sides; }

	@Override
	public String toString() { return "d" + sides; }

}

