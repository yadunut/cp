import { readFileSync } from "fs";
import path from "path";

async function main() {
	const file = readFileSync(path.join(__dirname, "./input.txt"), {
		encoding: "ascii",
	}).split("\n");
	console.log(part1(file));
	console.log(part2(file));
}

function part1(input: string[]): number {
	return input
		.map((s) => {
			const leftSet: Set<String> = new Set(
				s.substring(0, s.length / 2).split(""),
			);
			return s
				.substring(s.length / 2)
				.split("")
				.filter((c) => leftSet.has(c))
				.map((c) => {
					const code = c[0].charCodeAt(0);
					return code > 96 ? code - 96 : code - 38;
				})[0];
		})
		.reduce((a, b) => a + b);
}

function part2(input: string[]): number {
	let result = 0;
	for (let i = 0; i < input.length; i += 3) {
		const leftSet: Set<String> = new Set(input[i].split(""));
		const second = new Set(
			input[i + 1].split("").filter((c) => leftSet.has(c)),
		);
		const code = input[i + 2]
			.split("")
			.filter((c) => second.has(c))[0]
			.charCodeAt(0);
		result += code > 96 ? code - 96 : code - 38;
	}

	return result;
}

main();
