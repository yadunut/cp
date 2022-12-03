import { readFileSync } from "fs";
import { join } from "path";

async function main() {
	const fileContents = readFileSync(join(__dirname, "./1.in"), {
		encoding: "utf-8",
	});
	const file = fileContents.split("\n");
	console.log(part1(file));
	console.log(part2(file));
}

function part1(file: string[]): number {
	return file
		.map((s) => s.split(" ").map((s) => nomalise(s)))
		.map((rps) => calculateScore1(rps[0], rps[1]))
		.reduce((a, b) => a + b);
}

function part2(file: string[]): number {
	console.log(RPS[2]);
	return 0;
}

enum RPS {
	Rock = 1,
	Paper = 2,
	Scissors = 3,
}

function nomalise(a: string): RPS {
	switch (a) {
		case "A":
		case "X":
			return RPS.Rock;
		case "B":
		case "Y":
			return RPS.Paper;
		case "C":
		case "Z":
			return RPS.Scissors;
		default:
			throw new Error();
	}
}

function calculateScore2(other: RPS, current: RPS): number {
	if (current === RPS.Rock) {
		// lose
		const result = RPS.Rock;
		return 0 + result;
	} else if (current === RPS.Paper) {
		// draw
		return 3 + other;
	} else {
		const result = RPS.Rock;
		return 0 + result;
		// win
	}
}

function calculateScore1(other: RPS, current: RPS): number {
	if (other === current) {
		return other + 3;
	}
	if (current - other === 1 || current - other === -2) {
		return current + 6;
	}
	return current;
}

main();
