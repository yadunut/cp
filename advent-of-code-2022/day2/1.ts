import { readFileSync } from "fs";
import { join } from "path";

enum RPS {
	Rock = 1,
	Paper = 2,
	Scissors = 3,
}

enum Result {
	Draw = 3,
	Win = 6,
	Lose = 0,
}

const CONDITIONS = {
	[RPS.Rock]: {
		[RPS.Rock]: Result.Draw,
		[RPS.Paper]: Result.Win,
		[RPS.Scissors]: Result.Lose,
	},
	[RPS.Paper]: {
		[RPS.Rock]: Result.Lose,
		[RPS.Paper]: Result.Draw,
		[RPS.Scissors]: Result.Win,
	},
	[RPS.Scissors]: {
		[RPS.Rock]: Result.Win,
		[RPS.Paper]: Result.Lose,
		[RPS.Scissors]: Result.Draw,
	},
};

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
		.map((s) => s.split(" ").map((s) => nomalise_rps(s)))
		.map((rps) => calculateScore1(rps[0], rps[1]))
		.reduce((a, b) => a + b);
}

function part2(file: string[]): number {
	return file
		.map((s) => s.split(" "))
		.map((rps) =>
			calculateScore2(nomalise_rps(rps[0]), nomalise_result(rps[1])),
		)
		.reduce((a, b) => a + b);

}

function nomalise_rps(a: string): RPS {
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

function nomalise_result(a: string): Result {
	if (a === "X") {
		return Result.Lose;
	} else if (a === "Y") {
		return Result.Draw;
	} else {
		return Result.Win;
	}
}

function calculateScore2(other: RPS, result: Result): number {
	const current = Object.keys(CONDITIONS[other]).find(
		(key) => CONDITIONS[other][Number(key) as RPS] === result
	);
	return Number(current) + result;
}

function calculateScore1(other: RPS, current: RPS): number {
	return current + CONDITIONS[other][current];
}

main();
